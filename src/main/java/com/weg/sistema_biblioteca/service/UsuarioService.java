package com.weg.sistema_biblioteca.service;

import com.weg.sistema_biblioteca.dao.UsuarioDAO;
import com.weg.sistema_biblioteca.dto.usuario.UsuarioRequestDto;
import com.weg.sistema_biblioteca.dto.usuario.UsuarioResponseDto;
import com.weg.sistema_biblioteca.mapper.usuario.UsuarioMapper;
import com.weg.sistema_biblioteca.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDAO dao;

    @Autowired
    private UsuarioMapper mapper;

    public void salvar(UsuarioRequestDto dto) {
        Usuario usuario = mapper.toEntity(dto);
        dao.salvar(usuario);
    }

    public List<UsuarioResponseDto> listarTodos() {
        return dao.buscarTodos()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public UsuarioResponseDto buscarPorId(Long id) {
        return mapper.toDto(dao.buscarPorId(id));
    }

    public void atualizar(Long id, UsuarioRequestDto dto) {
        Usuario usuario = mapper.toEntity(dto);
        usuario.setId(id);
        dao.atualizar(usuario);
    }

    public void deletar(Long id) {
        dao.deletar(id);
    }
}
