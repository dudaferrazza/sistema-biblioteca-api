package com.weg.sistema_biblioteca.dao;

import com.weg.sistema_biblioteca.model.Livro;
import com.weg.sistema_biblioteca.utils.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    public void salvar(Livro livro) {
        String sql = "INSERT INTO livro (titulo, autor, ano_publicacao) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAnoPublicacao());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Livro> buscarTodos() {
        List<Livro> lista = new ArrayList<>();
        String sql = "SELECT * FROM livro";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Livro livro = new Livro(
                        rs.getLong("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("ano_publicacao")
                );
                lista.add(livro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Livro buscarPorId(Long id) {
        String sql = "SELECT * FROM livro WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Livro(
                        rs.getLong("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("ano_publicacao")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void atualizar(Livro livro) {
        String sql = "UPDATE livro SET titulo=?, autor=?, ano_publicacao=? WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAnoPublicacao());
            stmt.setLong(4, livro.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(Long id) {
        String sql = "DELETE FROM livro WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
