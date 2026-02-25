package com.weg.sistema_biblioteca.service;

import com.weg.sistema_biblioteca.dao.LivroDAO;
import com.weg.sistema_biblioteca.dto.livro.LivroRequestDto;
import com.weg.sistema_biblioteca.dto.livro.LivroResponseDto;
import com.weg.sistema_biblioteca.mapper.livro.LivroMapper;
import com.weg.sistema_biblioteca.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroDAO dao;

    @Autowired
    private LivroMapper mapper;

    public void salvar(LivroRequestDto dto) {
        Livro livro = mapper.toEntity(dto);
        dao.salvar(livro);
    }

    public List<LivroResponseDto> listarTodos() {
        return dao.buscarTodos()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public LivroResponseDto buscarPorId(Long id) {
        return mapper.toDto(dao.buscarPorId(id));
    }

    public void atualizar(Long id, LivroRequestDto dto) {
        Livro livro = mapper.toEntity(dto);
        livro.setId(id);
        dao.atualizar(livro);
    }

    public void deletar(Long id) {
        dao.deletar(id);
    }
}
