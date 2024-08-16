# Rest OAuth2 Security

Three Spring-Boot projects.

### REST API

The project is a resource server. It requests an access token for authorization.
The project simply outputs JSON to REST requests.

### AUTH-SERVER

The project is an authorization server. It authorizes the client using an authorization code.

### CLIENT

The project is a client for working with the REST API. It authorizes via the AUTH-SERVER and receives an access token.
Using the access token, it receives data from the REST-API.

## Technologies

* Java 21
* Maven
* Spring Boot 3
* Spring Web
* Spring Data JPA
* Spring Security 6:
    * OAuth2 Resource Server
    * OAuth2 Authorization Server
    * OAuth2 Client
* Thymeleaf
* Lombok
* H2

## Run locally

1. You can build and run the project from the command line:

```
cd auth-server
./mvnw package
java -jar .\target\auth-server-0.0.1-SNAPSHOT.jar

cd client
./mvnw package
java -jar .\target\client-0.0.1-SNAPSHOT.jar

cd rest-api
./mvnw package
java -jar .\target\rest-api-0.0.1-SNAPSHOT.jar
```

2. You can then access the project at http://localhost:8080/.
3. Initially, two accounts are set for authorization (username:password):
    * user1:user1
    * user2:user2
