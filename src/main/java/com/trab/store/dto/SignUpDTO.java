package com.trab.store.dto;

import com.trab.store.model.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SignUpDTO(
        @NotBlank(message = "Name is mandatory") String name,

        @NotBlank(message = "Email is mandatory") @Email(message = "Email should be valid") String email,

        @NotBlank(message = "Password is mandatory") @Size(min = 8, message = "Password must be at least 8 characters long") String password,

        @NotNull(message = "Role is mandatory") UserRole role) {

}
