package br.com.api.rh.api.domain.dto;

public record PutPasswordUserDTO(String currentPassword, String newPassword) {
}
