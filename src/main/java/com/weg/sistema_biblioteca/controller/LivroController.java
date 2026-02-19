package com.weg.sistema_biblioteca.controller;

import com.weg.sistema_biblioteca.model.Livro;
import org.springframework.web.bind.annotation.*;
import com.weg.sistema_biblioteca.service.LivroService;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private LivroService service = new LivroService();

    @PostMapping
    public void cadastrar(@RequestBody Livro livro) {
        service.salvar(livro);
    }

    @GetMapping
    public List<Livro> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody Livro livro) {
        livro.setId(id);
        service.atualizar(livro);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
