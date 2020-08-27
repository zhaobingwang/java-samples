package demo.springboot.log.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(String who) {
        if (who == null)
            who = "world";
        return "hello," + who;
    }
}
