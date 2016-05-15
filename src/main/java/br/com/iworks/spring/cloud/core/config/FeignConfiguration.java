package br.com.iworks.spring.cloud.core.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {FeignConfiguration.SCAN_PACKAGE})
@ComponentScan(basePackages = {FeignConfiguration.SCAN_PACKAGE})
public class FeignConfiguration {

    public static final String SCAN_PACKAGE = "br.com.iworks.spring.cloud.core.integration";
}