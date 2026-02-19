package com.weg.sistema_biblioteca.dao;

import com.weg.sistema_biblioteca.model.Emprestimo;
import com.weg.sistema_biblioteca.utils.Conexao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO {

    public void salvar(Emprestimo e) {
        String sql = "INSERT INTO emprestimo (livro_id, usuario_id, data_emprestimo, data_devolucao) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, e.getLivroId());
            stmt.setLong(2, e.getUsuarioId());
            stmt.setDate(3, Date.valueOf(e.getDataEmprestimo()));

            if (e.getDataDevolucao() != null) {
                stmt.setDate(4, Date.valueOf(e.getDataDevolucao()));
            } else {
                stmt.setNull(4, Types.DATE);
            }

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Emprestimo> buscarTodos() {
        List<Emprestimo> lista = new ArrayList<>();
        String sql = "SELECT * FROM emprestimo";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                LocalDate devolucao = null;
                Date dataDev = rs.getDate("data_devolucao");
                if (dataDev != null) {
                    devolucao = dataDev.toLocalDate();
                }

                Emprestimo e = new Emprestimo(
                        rs.getLong("id"),
                        rs.getLong("livro_id"),
                        rs.getLong("usuario_id"),
                        rs.getDate("data_emprestimo").toLocalDate(),
                        devolucao
                );

                lista.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Emprestimo buscarPorId(Long id) {
        String sql = "SELECT * FROM emprestimo WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                LocalDate devolucao = null;
                Date dataDev = rs.getDate("data_devolucao");
                if (dataDev != null) {
                    devolucao = dataDev.toLocalDate();
                }

                return new Emprestimo(
                        rs.getLong("id"),
                        rs.getLong("livro_id"),
                        rs.getLong("usuario_id"),
                        rs.getDate("data_emprestimo").toLocalDate(),
                        devolucao
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void atualizar(Emprestimo e) {
        String sql = "UPDATE emprestimo SET livro_id=?, usuario_id=?, data_emprestimo=?, data_devolucao=? WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, e.getLivroId());
            stmt.setLong(2, e.getUsuarioId());
            stmt.setDate(3, Date.valueOf(e.getDataEmprestimo()));

            if (e.getDataDevolucao() != null) {
                stmt.setDate(4, Date.valueOf(e.getDataDevolucao()));
            } else {
                stmt.setNull(4, Types.DATE);
            }

            stmt.setLong(5, e.getId());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deletar(Long id) {
        String sql = "DELETE FROM emprestimo WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
