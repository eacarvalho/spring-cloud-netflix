package br.com.iworks.spring.cloud.ws;

import br.com.iworks.spring.cloud.core.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-client")
public class HelloWorldClientRest {

    @Autowired
    private HelloWorldService service;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return service.getHello();
    }
}