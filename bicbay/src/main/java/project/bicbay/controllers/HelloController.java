package project.bicbay.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.bicbay.models.Client;
import project.bicbay.models.Retailers;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }
}
