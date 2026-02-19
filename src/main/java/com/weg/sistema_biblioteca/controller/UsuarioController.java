package com.weg.sistema_biblioteca.controller;

import com.weg.sistema_biblioteca.model.Emprestimo;
import com.weg.sistema_biblioteca.model.Usuario;
import org.springframework.web.bind.annotation.*;
import com.weg.sistema_biblioteca.service.EmprestimoService;
import com.weg.sistema_biblioteca.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    private UsuarioService service = new UsuarioService();
    private EmprestimoService emprestimoService = new EmprestimoService();

    @PostMapping
    public void cadastrar(@RequestBody Usuario usuario) {
        service.salvar(usuario);
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        service.atualizar(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/{id}/emprestimos")
    public List<Emprestimo> listarEmprestimosDoUsuario(@PathVariable Long id) {
        return emprestimoService.buscarPorUsuario(id);
    }
}
