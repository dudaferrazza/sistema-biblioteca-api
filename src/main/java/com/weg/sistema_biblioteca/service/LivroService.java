package com.weg.sistema_biblioteca.service;

import com.weg.sistema_biblioteca.dao.LivroDAO;
import com.weg.sistema_biblioteca.model.Livro;

import java.util.List;

public class LivroService {

    private LivroDAO dao = new LivroDAO();

    public void salvar(Livro livro) {
        dao.salvar(livro);
    }

    public List<Livro> listarTodos() {
        return dao.buscarTodos();
    }

    public Livro buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    public void atualizar(Livro livro) {
        dao.atualizar(livro);
    }

    public void deletar(Long id) {
        dao.deletar(id);
    }
}
