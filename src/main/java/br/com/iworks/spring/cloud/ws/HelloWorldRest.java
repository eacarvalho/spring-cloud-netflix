package br.com.iworks.spring.cloud.ws;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloWorldRest {

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        log.info("Hello World");

        return "Hello World";
    }
}