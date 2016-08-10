package personal.arc.springboot.actuator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Arc on 29/7/2016.
 */
@RestController
public class HelloWorld {
    @Autowired
    private CounterService counterService;

    @RequestMapping("/hello")
    public String hello() {
        counterService.increment("hello.api.success");
        return "Springboot, Hello World!";
    }
}
