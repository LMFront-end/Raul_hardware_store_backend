# Raul's Hardware Store(_Spring boot, webflux, Router Function Mongo DB_)


## Ejecución del proyecto ⌨️
_`Mongo db: localhost:27017`_
_`Spring boot: localhost:8080

### Dependecias necesarias para la ejecución del proyecto  📦

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb-reactive</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.projectreactor</groupId>
            <artifactId>reactor-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>3.0.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-boot-starter</artifactId>
            <version>3.0.0</version>
        </dependency>

        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-webflux-core</artifactId>
            <version>1.4.3</version>
        </dependency>

        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-webflux-ui</artifactId>
            <version>1.4.3</version>
        </dependency>
    </dependencies>

### Organización de carpetas
`config`
* **WebfluxConfig**

`aplication`
* **mappers**
* **useCase**
* **useCaseImp**
* **JsonReader**

`domain`
* **collection**
* **dto**
* **repository**


`infrastructure`
* **Routes**


### Data
_Se crea un archivo Data.json que contiene una collección de 85 elementos. La data simula una colección de libros, revistas, DVD, rondas infantiles disponibles en una biblioteca_

### JsonReader
_Se crea una clase llamada JsonReader que permite convertir el Data.json en objetos, los cuales se utilizan para ejecutar los tests_

### Endpoints 📌

_Resource command controllers_
`PUT, POST, DELETE`
* [returnResource](http://www) 
* [borrowResource](https://) 
* [deleteAll](https://) - Borrar data
* [deleteResource](https://) 
* [updateResource](https://) 
* [saveResource](https://) 
* [fillData](https://) - llenar data

_Resource query controllers_
`GET`
* [findByName](http://www) 
* [findByAuthor](https://) 
* [recommendByThema&Type](https://) 
* [recommendByThematicArea](https://) 
* [recommendByTypeOfResource](https://) 
* [findByAvailability](https://) 
* [findById](https://) 
* [listResource](https://) 

### pruebas manuales con insomnia y postman
--> Se agrega colección de postman

## Autora ✒️
* **Lina Maria Guerrero** - *Raul's hardware Store* - [LMFront-end](https://github.com/LMFront-end)
