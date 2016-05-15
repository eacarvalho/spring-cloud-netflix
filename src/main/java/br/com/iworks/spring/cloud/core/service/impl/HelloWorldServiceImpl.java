package br.com.iworks.spring.cloud.core.service.impl;

import br.com.iworks.spring.cloud.core.integration.HelloWorldIntegration;
import br.com.iworks.spring.cloud.core.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Autowired
    private HelloWorldIntegration integration;

    @Override
    public String getHello() {
        return integration.getHello();
    }
}