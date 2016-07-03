package br.com.iworks.spring.cloud.app;

import br.com.iworks.spring.cloud.core.config.FeignConfiguration;
import br.com.iworks.spring.cloud.core.config.RestConfiguration;
import br.com.iworks.spring.cloud.core.config.ServiceConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class Application {

    public static void main(String[] args) {
        log.info("### - Lendo propriedades do Application: " + System.getProperties().toString());
        new SpringApplicationBuilder(Application.class,
                ServiceConfiguration.class,
                FeignConfiguration.class,
                RestConfiguration.class).run(args);
    }
}
