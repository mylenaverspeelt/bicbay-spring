package project.bicbay.dto;

import project.bicbay.models.User;

public record TransferDTO(User user, float value) {
}
