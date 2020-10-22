package personal.arc.springboot.actuator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class SecondHelloWorld {

    ExecutorService executorService = Executors.newFixedThreadPool(16);

    @RequestMapping("/test/demo2")
    public Integer test(HttpServletRequest request) {
        CompletableFuture.supplyAsync(() -> {
            request.setAttribute("AAAAAAA", "HEHEHEHEHE");
            request.setAttribute("cadfhafklakhfadhfklweqhte", true);
            return null;
        }, executorService);
        return null;
    }

}
