package com.weg.sistema_biblioteca.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDto(

        @NotBlank(message = "nome não pode estar em branco")
        @Size(min = 3, max = 100, message = "nome deve ter entre 3 e 100 caracteres")
        String nome,

        @NotBlank(message = "email não pode estar em branco")
        @Email(message = "email deve ser um endereço válido")
        String email
){
}
