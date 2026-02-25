package com.weg.sistema_biblioteca.mapper.usuario;

import com.weg.sistema_biblioteca.dto.usuario.UsuarioRequestDto;
import com.weg.sistema_biblioteca.dto.usuario.UsuarioResponseDto;
import com.weg.sistema_biblioteca.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDto usuarioRequestDto) {
        return new Usuario(usuarioRequestDto.nome(), usuarioRequestDto.email());
    }

    public UsuarioResponseDto toDto(Usuario usuario) {
        return new UsuarioResponseDto(usuario.getNome(), usuario.getEmail());
    }
}
