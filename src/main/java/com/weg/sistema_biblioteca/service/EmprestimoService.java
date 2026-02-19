package com.weg.sistema_biblioteca.service;

import com.weg.sistema_biblioteca.dao.EmprestimoDAO;
import com.weg.sistema_biblioteca.model.Emprestimo;

import java.time.LocalDate;
import java.util.List;

public class EmprestimoService {

    private EmprestimoDAO dao = new EmprestimoDAO();

    public void cadastrar(Emprestimo e) {

        List<Emprestimo> lista = dao.buscarTodos();

        for (Emprestimo emp : lista) {
            if (emp.getLivroId().equals(e.getLivroId())
                    && emp.getDataDevolucao() == null) {
                throw new RuntimeException("Livro já emprestado!");
            }
        }

        dao.salvar(e);
    }

    public List<Emprestimo> listarTodos() {
        return dao.buscarTodos();
    }

    public Emprestimo buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    public void atualizar(Emprestimo e) {
        dao.atualizar(e);
    }

    public void deletar(Long id) {
        dao.deletar(id);
    }

    public void finalizarEmprestimo(Long id) {
        Emprestimo e = dao.buscarPorId(id);
        e.setDataDevolucao(LocalDate.now());
        dao.atualizar(e);
    }

    public List<Emprestimo> buscarPorUsuario(Long usuarioId) {
        return dao.buscarTodos()
                .stream()
                .filter(e -> e.getUsuarioId().equals(usuarioId))
                .toList();
    }
}
