package project.bicbay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.bicbay.dto.TransferDTO;
import project.bicbay.models.Client;
import project.bicbay.models.User;
import project.bicbay.repositories.UserRepository;

import java.util.Optional;

@Service
public class TransferService {

    private final UserRepository userRepository;

    @Autowired
    public TransferService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String transfer(TransferDTO transferDTO) {
        if (transferDTO.getPayer() != null && transferDTO.getPayee() != null) {
            Optional<User> payerOpt = userRepository.findById(transferDTO.getPayer());
            Optional<User> payeeOpt = userRepository.findById(transferDTO.getPayee());

            if (payerOpt.isPresent() && payeeOpt.isPresent()) {
                User sender = payerOpt.get();
                User receiver = payeeOpt.get();

                if (!(sender instanceof Client)) {
                    return "Apenas usuários do tipo 'Cliente' podem realizar transferências.";
                }

                if (sender.getBalance() >= transferDTO.getValue()) {
                    sender.setBalance(sender.getBalance() - transferDTO.getValue());
                    receiver.setBalance(receiver.getBalance() + transferDTO.getValue());

                    userRepository.save(sender);
                    userRepository.save(receiver);

                    return "Transferência realizada com sucesso";
                } else {
                    return "Saldo insuficiente. Tente novamente";
                }
            } else {
                return "Cliente ou Lojista não encontrado. Tente novamente.";
            }
        } else {
            return "IDs do cliente e do lojista não podem ser nulos.";
        }
    }
}