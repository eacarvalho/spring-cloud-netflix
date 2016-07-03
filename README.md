# Introdução
Projeto Spring Cloud Client que se registra no Eureka (Netflix Service Discovery), com isso é muito mais robusto a construção
de microservices com alta disponibilidade e pronto para o cloud computing. Esse projeto tem a dependência do Spring
Cloud Eureka Server (https://github.com/eacarvalho/spring-cloud-eureka-server) e opcionalmente do Spring Cloud
Zuul Server (https://github.com/eacarvalho/spring-cloud-zuul-server).

# Tecnologias
Java 8, spring-boot 1.2.8, spring-cloud-netflix, Ribbon e Feign.
* Próximo passo configurar Hystrix

# Como iniciar os Microservices
- mvn spring-boot:run -Dserver.port=7070
- mvn spring-boot:run -Dserver.port=6060

# Visualizar os serviços no Eureka (service-name)
- http://localhost:8761/

# Como acessar os Serviços (spring-cloud-netflix)
- Acessar diretamente os serviços: http://localhost:7070/hello ou http://localhost:6060/hello
- Acessar diretamente os serviços que fazem chamada ao serviço acima usando Ribbon e Feign: http://localhost:7070/hello-client ou http://localhost:6060/hello-client
- Acessar os serviços passando pelo Netflix Zuul Server (intelligent routing): http://localhost:8765/spring-cloud-netflix/hello-client

# Acessar via Gateway Zuul Server
Netflix Zuul Server é um serviço gateway que realiza Dynamic Routing, Monitoramento, Resiliência e Segurança.

- http://localhost:8765/spring-cloud-netflix/hello-client

# Application.yml
```
server:
  port: 7070
  compression:
    enabled: true
    mime-types: application/json

eureka:
  instance:
    hostname: localhost
    instanceId: ${spring.application.name}
    leaseRenewalIntervalInSeconds: 5
    leaseExpirationDurationInSeconds: 10
    preferIpAddress: true
    metadataMap:
      instanceId: ${spring.application.name}:${server.port}
  client:
    healthcheck:
      enabled: true
    registerWithEureka: true
    fetchRegistry: true
    serviceUrl:
      defaultZone: ${vcap.services.eureka-service.credentials.uri:http://127.0.0.1:8761}/eureka/
  server:
      waitTimeInMsWhenSyncEmpty: 0

ribbon:
  eureka:
    enabled: true

spring-cloud-netflix:
  ribbon:
    NIWSServerListClassName: com.netflix.niws.loadbalancer.DiscoveryEnabledNIWSServerList
    ServerListRefreshInterval: 2000

info:
  application:
    name: ${spring.application.name}
  health-path: http://localhost:${server.port}/health
  modulo: spring-cloud-netflix
  projeto: Spring Cloud Netflix

spring:
  service:
    name: spring-cloud-netflix
```

# Bootstrap.yml
```
spring:
  application:
    name: spring-cloud-netflix
  cloud:
    config:
      enabled: false
```
