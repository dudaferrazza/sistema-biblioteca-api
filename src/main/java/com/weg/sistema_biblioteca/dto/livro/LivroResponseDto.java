package com.weg.sistema_biblioteca.dto.livro;

public record LivroResponseDto(
        Long id,
        String titulo,
        String autor,
        int anoPublicacao
){
}
