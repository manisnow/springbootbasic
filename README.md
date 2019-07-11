# springbootbasic
This has spring boot skelatal project.. and has sample of drools and msql jpa ,ehcache and swagger code generator

This repository is a sample of spring boot with gradle

# How to use this springbootbasic
download this project with the next commands:

* **git clone https://github.com/manisnow/springbootbasic.git**
* **cd springbootbasic**
 

* **update the msql properties in src/main/resourses/application.yml**

spring:
  jpa:
    hibernate:
      ddl-auto: create
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/sampledb
    username: user
    password: user
  cache:
    jcache:
      config: classpath:ehcache.xml

* type **gradle build**
* go to **build/libs** folder
* type **java -jar springbootbasic.0.0.1-SNAPSHOT.jar**

Open your favorite navigator and go to http://localhost:8080/swagger-ui.html

It will sow swagger html where you can see and test your resources

# Recommendation to use this application as a Docker Container
This link is useful to start my application as a Docker container:

* https://spring.io/guides/gs/spring-boot-docker/

Go to the point *Build a Docker Image with Gradle*
