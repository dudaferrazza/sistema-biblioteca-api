package com.weg.sistema_biblioteca.controller;

import com.weg.sistema_biblioteca.model.Emprestimo;
import org.springframework.web.bind.annotation.*;
import com.weg.sistema_biblioteca.service.EmprestimoService;


import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private EmprestimoService service = new EmprestimoService();

    @PostMapping
    public void cadastrar(@RequestBody Emprestimo e) {
        service.cadastrar(e);
    }

    @GetMapping
    public List<Emprestimo> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Emprestimo buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody Emprestimo e) {
        e.setId(id);
        service.atualizar(e);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @PutMapping("/{id}/devolucao")
    public void devolver(@PathVariable Long id) {
        service.finalizarEmprestimo(id);
    }
}
