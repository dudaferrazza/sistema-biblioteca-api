package com.weg.sistema_biblioteca.controller;

import com.weg.sistema_biblioteca.dto.emprestimo.EmprestimoRequestDto;
import com.weg.sistema_biblioteca.dto.emprestimo.EmprestimoResponseDto;
import com.weg.sistema_biblioteca.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService service;

    @PostMapping
    public void cadastrar(@RequestBody EmprestimoRequestDto dto) {
        service.cadastrar(dto);
    }

    @GetMapping
    public List<EmprestimoResponseDto> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public EmprestimoResponseDto buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}/devolucao")
    public void devolver(@PathVariable Long id) {
        service.finalizarEmprestimo(id);
    }
}