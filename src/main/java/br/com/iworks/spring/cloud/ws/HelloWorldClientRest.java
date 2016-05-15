package br.com.iworks.spring.cloud.ws;

import br.com.iworks.spring.cloud.core.service.HelloWorldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-client")
@Slf4j
public class HelloWorldClientRest {

    @Autowired
    private HelloWorldService service;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        log.info("Executando a chamada ao service hello world - feign");
        return service.getHello();
    }
}