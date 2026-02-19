package com.weg.sistema_biblioteca.service;

import com.weg.sistema_biblioteca.dao.UsuarioDAO;
import com.weg.sistema_biblioteca.model.Usuario;

import java.util.List;

public class UsuarioService {

    private UsuarioDAO dao = new UsuarioDAO();

    public void salvar(Usuario usuario) {
        dao.salvar(usuario);
    }

    public List<Usuario> listarTodos() {
        return dao.buscarTodos();
    }

    public Usuario buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    public void atualizar(Usuario usuario) {
        dao.atualizar(usuario);
    }

    public void deletar(Long id) {
        dao.deletar(id);
    }
}
