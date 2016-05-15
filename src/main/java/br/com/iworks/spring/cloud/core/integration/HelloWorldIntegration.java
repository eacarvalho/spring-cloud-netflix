package br.com.iworks.spring.cloud.core.integration;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("spring-cloud-netflix")
public interface HelloWorldIntegration {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String getHello();
}