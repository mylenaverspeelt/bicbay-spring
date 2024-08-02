package project.bicbay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.bicbay.dto.TransferDTO;
import project.bicbay.dto.UserDTO;
import project.bicbay.repositories.UserRepository;
import project.bicbay.service.TransferService;
import project.bicbay.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final TransferService transferService;

    @Autowired
    public UserController(UserRepository userRepository, UserService service, UserService userService, TransferService transferService) {
        this.userService = userService;
        this.transferService = transferService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerNewUser(@RequestBody UserDTO userDTO) {
        String result = userService.registerUser(userDTO);
        if (result.equals("Cliente salvo com sucesso.")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferDTO transferDTO) {
        if (transferDTO.getPayer() == null || transferDTO.getPayee() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("IDs do pagador e do recebedor não podem ser nulos.");
        }
        String result = transferService.transfer(transferDTO);
        if (result.equals("Transferência realizada com sucesso.")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
