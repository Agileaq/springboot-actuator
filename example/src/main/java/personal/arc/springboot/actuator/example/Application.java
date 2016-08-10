package personal.arc.springboot.actuator.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Arc on 29/7/2016.
 */
@SpringBootApplication
@ComponentScan("personal.arc.springboot.actuator")
public class Application{
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
