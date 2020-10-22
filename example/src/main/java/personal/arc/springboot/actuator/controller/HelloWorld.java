package personal.arc.springboot.actuator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Arc on 29/7/2016.
 */
@RestController
public class HelloWorld {

    private static Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);

    @Autowired
    private CounterService counterService;

    @RequestMapping("/hello")
    public String hello() {
        counterService.increment("hello.api.success");
        return "Springboot, Hello World!";
    }

    @RequestMapping("/test/demo1")
    public void test(HttpServletRequest httpServletRequest) {
        LOGGER.info(((Boolean)(httpServletRequest.getAttribute("cadfhafklakhfadhfklweqhte") == null)).toString());
    }

}
