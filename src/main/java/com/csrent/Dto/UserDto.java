package com.csrent.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserDto
{
    @NotBlank(message = "El nombre no puede quedar vacío")
    private String name;

    @Email (message = "El correo no es válido")
    @NotBlank(message = "El correo no puede quedar vacío")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d)(?=.*[!@#$%^&*()]).{8,}$",
    message = "La contraseña debe de tener Mayusculas y numeros ")
    private String password;

    private String rol;

    public UserDto() {
    }

    public UserDto(String name, String email, String password, String rol) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
