# LabfolerELN Backend

LabfolerELN enables scientists to better understand similarities in their data. It currently limited to only search.

Functionality is exposed with using REST API. It currently does not support any authentication mechanism. Return type of all endpoints is JSON.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for the notes on how to deploy the project on a live system.

### Prerequisites
Clone the current repository to your local machine.
#### Build & Run
Inside the project folder use the following command.
```gradle bootRun```

#### Tests
```gradle test```
	 or
```gradle -Dtest.single=TestClassName test```

### API Access

To access the API use the following HTTP methods.

#### via GET

```
http://localhost:8080/find?entry=word Wor word woord&keyword= word


```

#### via POST

```
<url> 
http://localhost:8080/find

<body>
{
"entry": "word Wor word woord",
"keyword": "word"
}
```


## Deployment

To deploy the application to any container based engine. Use the docker file to create the container for the application. Run the following command inside the project directory.

```gradle build```
```docker build -t <image_name> .```

### EndPoint
The application is deployed in on GCP Kubernes Engine. Use the following endpoint to access the API. The production enviroment currently supports only HTTP.

```http://35.244.162.226/find```

## Dependencies

* [Java8](https://www.oracle.com/java) - Programming Enviroment
* [Spring Boot](https://spring.io/projects/spring-boot) - Project Initializer
* [Spring Web](spring.io/projects/spring-framework) - Web framework
* [Gradle](https://gradle.org/) - Dependency Management
* [Jackson](https://fasterxml.github.io/jackson-core) - JSON parser
 * [Apache Commonds Text](https://commons.apache.org/proper/commons-text) - Text Algorithms

## Improvements
This API can be further improved by implementing file upload functionality for uploading large text entry. Furthermore, the API can be secured with authentication. Besides, the structure of the code can be improved for handling complex data types provided by the client.

## Authors

* **Luqman Ul Khair** - *Initial work* - [GitHub](https://github.com/luqmanulkhair)


