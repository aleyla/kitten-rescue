# kitten-rescue
This API provides to help find kittens.

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

# Running the application locally

```shell
'mvn spring-boot:run'  or './mvnw spring-boot:run'
```
For running the tests
```shell
'mvn test' or './mvnw test'
```

# Opening Swagger

After running the project, swagger link is: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

# Endpoints
coordinate-clue : Calculates coordinates by using email path parameter.

find : Always rescue kitties by using email path parameter.

guess-location : You can guess woman location with email and coordinate info.

directions : Gets woman directions by using email path parameter.