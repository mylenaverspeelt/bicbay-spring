package project.bicbay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.bicbay.models.Client;
import project.bicbay.models.Retailers;
import project.bicbay.models.User;
import project.bicbay.repositories.UserRepository;

import java.util.Optional;

@RestController
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String registerNewUser() {

        Client cliente1 = new Client("Mylena", "mymy@email.com", "123456", 500, "123456789");

        Retailers retailer1 = new Retailers("Ana", "ana@email.com", "123456", 400, "1234567890");

        Optional<User> user = this.userRepository.findByEmail(cliente1.getEmail());

        if (user.isEmpty()) {
            userRepository.save(cliente1);
            userRepository.save(retailer1);
            return "cliente salvo com sucesso";
        } else {
            return "Cliente já cadastrado na base de dados.";

        }
    }

}
