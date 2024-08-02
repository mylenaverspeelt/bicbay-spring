package project.bicbay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.bicbay.dto.UserDTO;
import project.bicbay.models.Client;
import project.bicbay.models.Retailers;
import project.bicbay.models.User;
import project.bicbay.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

public String registerUser(UserDTO userDTO) {
    User user;

    if (userDTO.getCpf() != null && !userDTO.getCpf().isEmpty()) {
        user = new Client(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getBalance(), userDTO.getCpf());
    } else if (userDTO.getCnpj() != null && !userDTO.getCnpj().isEmpty()) {
        user = new Retailers(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getBalance(), userDTO.getCnpj());
    } else {
        return "Tipo de usuário inválido. CPF ou CNPJ deve ser fornecido.";
    }

    if (findUserByEmail(userDTO.getEmail()).isPresent()) {
        return "Usuário já cadastrado na base de dados.";
    } else {
        userRepository.save(user);
        return "Usuário salvo com sucesso." ;
    }
}

    private Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
