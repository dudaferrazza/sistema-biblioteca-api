package com.weg.sistema_biblioteca.controller;

import com.weg.sistema_biblioteca.dto.livro.LivroRequestDto;
import com.weg.sistema_biblioteca.dto.livro.LivroResponseDto;
import com.weg.sistema_biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @PostMapping
    public void cadastrar(@RequestBody LivroRequestDto dto) {
        service.salvar(dto);
    }

    @GetMapping
    public List<LivroResponseDto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public LivroResponseDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody LivroRequestDto dto) {
        service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}