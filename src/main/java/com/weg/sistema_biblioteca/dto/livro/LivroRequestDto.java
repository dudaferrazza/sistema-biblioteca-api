package com.weg.sistema_biblioteca.dto.livro;

public record LivroRequestDto(
        String titulo,
        String autor,
        int anoPublicacao
){
}
