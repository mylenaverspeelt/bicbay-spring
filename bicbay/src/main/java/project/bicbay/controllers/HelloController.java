package project.bicbay.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.bicbay.models.Client;
import project.bicbay.models.Retailers;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {

        Client cliente1 = new Client("Mylena", "mymy@email.com", "123456", 500, "123456789");

        Retailers retailer1 = new Retailers("Ana", "ana@email.com", "123456", 400, "1234567890");

        return cliente1.transfer(retailer1, 50) + " / " + cliente1.getBalance() + " / " + retailer1.getBalance();
    }
}
