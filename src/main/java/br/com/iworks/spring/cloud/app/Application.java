package br.com.iworks.spring.cloud.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
@Slf4j
public class Application {

    public static void main(String[] args) {
        log.info("### - Lendo propriedades do Application: " + System.getProperties().toString());
        new SpringApplicationBuilder(Application.class, ModuleConfiguration.class).run(args);
    }
}
