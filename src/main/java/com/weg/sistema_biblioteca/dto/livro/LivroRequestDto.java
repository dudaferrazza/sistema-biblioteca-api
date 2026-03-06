package com.weg.sistema_biblioteca.dto.livro;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LivroRequestDto(

        @NotBlank(message = "titulo não pode estar em branco")
        @Size(min = 2, max = 150, message = "titulo deve ter entre 2 e 150 caracteres")
        String titulo,

        @NotBlank(message = "autor não pode estar em branco")
        @Size(min = 2, max = 100, message = "autor deve ter entre 2 e 100 caracteres")
        String autor,

        @Min(value = 1000, message = "anoPublicacao deve ser maior que 1000")
        @Max(value = 2100, message = "anoPublicacao deve ser menor que 2100")
        int anoPublicacao
){
}
