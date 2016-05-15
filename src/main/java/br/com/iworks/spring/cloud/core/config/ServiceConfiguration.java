package br.com.iworks.spring.cloud.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {ServiceConfiguration.SCAN_PACKAGE})
public class ServiceConfiguration {

    public static final String SCAN_PACKAGE = "br.com.iworks.spring.cloud.core.service";
}