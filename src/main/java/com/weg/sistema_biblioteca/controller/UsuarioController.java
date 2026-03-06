package com.weg.sistema_biblioteca.controller;

import com.weg.sistema_biblioteca.dto.usuario.UsuarioRequestDto;
import com.weg.sistema_biblioteca.dto.usuario.UsuarioResponseDto;
import com.weg.sistema_biblioteca.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public void cadastrar(@RequestBody @Valid UsuarioRequestDto dto) {
        service.salvar(dto);
    }

    @GetMapping
    public List<UsuarioResponseDto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public UsuarioResponseDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioRequestDto dto) {
        service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
