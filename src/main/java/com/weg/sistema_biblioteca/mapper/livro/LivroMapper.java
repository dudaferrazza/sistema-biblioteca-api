package com.weg.sistema_biblioteca.mapper.livro;

import com.weg.sistema_biblioteca.dto.livro.LivroRequestDto;
import com.weg.sistema_biblioteca.dto.livro.LivroResponseDto;
import com.weg.sistema_biblioteca.model.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {

    public Livro toEntity(LivroRequestDto livroRequestDto) {
        return new Livro(livroRequestDto.titulo(), livroRequestDto.autor(), livroRequestDto.anoPublicacao());
    }

    public LivroResponseDto toDto(Livro livro) {
        return new LivroResponseDto(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao());
    }
}
