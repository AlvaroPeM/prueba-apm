# Prueba Inditex por Álvaro Peña Meléndez

He creado una aplicación utilizando spring-boot v3.0.0
La aplicación está desarrolada en java v17 y se ejecuta en un proceso java en segundo plano que incluye un servidor Tomcat v10.1.1 embebido
La aplicación consume una BDD H2 cargada en memoria en el momento de lanzarse, existe un scritp data.sql que carga los datos cada vez que se inicializa. 
Esta BDD está pensada para realizar los tests, en una aplicación real el scope debería cambiar de "runtime" a "test" y el fichero data.sql debería ubicarse en "src/test/resources/" (se recomiendan el uso de perfiles)
El proyecto utiliza maven para importar las librerías de las que depende y también para utlizar algún que otro plugin.
Descripción de las librerías utilizadas:
	- spring-boot-starter (compendio de librerías de spring/spring-boot que contienen el core de spring y spring-boot)
	- spring-boot-starter-data-jpa (compendio de librerías de spring/spring-boot utilizadas para persistencia de la aplicación)
	- spring-boot-starter-web (compendio de librerías de spring/spring-boot utilizadas para exponer los recursos al exterior mediante REST)
	- spring-boot-starter-validation (compendio de librerías de spring/spring-boot utilizadas para controlar el formato de los datos recibidos en la interfaz de las llamadas de nuestra API)
	- mapstruct (librería de mapeo utilizada para el intercambio de datos entre las distintas capas de la aplicación)
	- h2 (librería que simula una BDD relacional, la cual se carga en memoria)
	- spring-boot-starter-test (compendio de librerías de spring/spring-boot utilizadas para crear los test unitarios/integración de la aplicación)
	- spring-boot-devtools (compendio de librerías de spring/spring-boot utilizadas para la ayuda al desarrollo)
	- lombok (librería utilizada para evitar la escritura de código repetitivo)
	- spring-boot-configuration-processor (compendio de librerías de spring/spring-boot utilizadas para el procesamiento de las anotaciones de configuración)
Descripción de los plugins utilizados:
	- spring-boot-maven-plugin (plugin de maven necesario para la utilización de spring-boot con maven)
	- maven-compiler-plugin (plugin de maven utilizado para crear y compilar las clases autogeneradas por ciertas librerías utilizadas, en este caso, mapstruct y lombok)
La aplicación expone sus enpoints la siguiente URL -> http:servidor:puerto/basepath (http:localhost:8080/prices)
Hemos aplicado versionado a la aplicación (por ahora solamente incluye la primera versión v1)
La aplicación consta solamente de un único endpoint que se expone en la siguiente URL -> http://localhost:8080/prices/v1/getFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc/{productId}/{brandId}/{date}
Aparte de la respuesta esperada, me he tomado la libertad de crear otro tipo de respuesta en caso de error y he añadido 4 tests adicionales:
	- integrationTestPricesControllerWrongProductId
	- integrationTestPricesControllerWrongBrandId
	- integrationTestPricesControllerWrongDate
	- integrationTestPricesControllerNotInDB
La consulta a BDD esta realizada con JPA, en un caso real en donde existan distintos tipos de llamadas con numerosos filtros y relaciones entre distintas tablas es recomendable usar JPQL o JPA Metadata models
No he llegado a implementar ninguna estrategia en los logs aplicativos y he dejado los que utliza spring-boot junto con la librería de logback por defecto. En un caso real lo suyo sería configurar la estrategia de logback mediante un fichero xml. 
Se ha utilizado el patrón DAO para las llamadas a las entidades de BDD.
Se ha utilizado el patrón DTO para el intercambio de datos entre las diferentes capas de la aplicación.
Los componentes que conforman la aplicación se consumen a traves de interfaces y se inyectan utilizando la anotación @Autowired para ser utilizados.
No se ha utilizado la estrategia de inyectarlos en un contructor o a través de un setter debido a que los Tests realizados son de integración. 
Además, ya es posible realizar Test Unitarios en base a integración mediante la anotación @SpringBootTest + la base de datos H2 (en vez de mockear objetos de java, mockeo la estructura de datos y los cargo en memoria usando H2)
Para más información sobre la aplicación, he añadido algún comentario en el código y en los archivos del tipo "package-info.java"