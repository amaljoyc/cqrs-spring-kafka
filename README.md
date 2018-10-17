# cqrs-spring-kafka
Spring boot app using DDD, CQRS, Kafka etc

* Domain Driven Design Patterns
* Command Query Responsibility Segregation
* Java 8
* Spring MVC
* Spring Boot
* Spring Cloud Stream
* Spring Data JPA
* Maven
* Kafka
* Postgresql
* Docker Compose

#### to build individual service,
    ./mvnw clean package

#### to build and run all the services,
    docker-compose up --build
    
#### to kill all the running services,
    docker-compose rm -v
