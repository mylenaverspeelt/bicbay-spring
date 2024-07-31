package project.bicbay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.bicbay.dto.TransferDTO;
import project.bicbay.models.Client;
import project.bicbay.models.Retailers;
import project.bicbay.models.User;
import project.bicbay.repositories.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    //TODO: MUDAR ESSES OBJETOS
    Client cliente1 = new Client("Mylena", "mymy@email.com", "123456", 500, "123456789");
    Retailers retailer1 = new Retailers("Ana", "ana@email.com", "123456", 400, "1234567890");

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String registerNewUser() {

        boolean isUser = findUser();

        if (!isUser) {
            userRepository.save(cliente1);
            userRepository.save(retailer1);
            return "Cliente salvo com sucesso";
        } else {
            return "Cliente já cadastrado na base de dados.";

        }
    }

//    @PostMapping("/transfer")
//    public String transfer() {
//
//       User user = dto.user();
//       float value = dto.value();
//
//       if (!findUser()){
//           return "Algum erro aconteceu. A transferencia não foi realizada."
//       }else{
//           return "Transferencia realizada com sucesso.";
//       }
//    }

    public Boolean findUser() {
        Optional<User> user = this.userRepository.findByEmail(cliente1.getEmail());
        return user.isPresent();
    }
}
