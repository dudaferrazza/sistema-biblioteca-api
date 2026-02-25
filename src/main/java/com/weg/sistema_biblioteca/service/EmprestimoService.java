package com.weg.sistema_biblioteca.service;

import com.weg.sistema_biblioteca.dao.EmprestimoDAO;
import com.weg.sistema_biblioteca.dto.emprestimo.EmprestimoRequestDto;
import com.weg.sistema_biblioteca.dto.emprestimo.EmprestimoResponseDto;
import com.weg.sistema_biblioteca.mapper.emprestimo.EmprestimoMapper;
import com.weg.sistema_biblioteca.model.Emprestimo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoDAO dao;

    @Autowired
    private EmprestimoMapper mapper;

    public void cadastrar(EmprestimoRequestDto dto) {

        Emprestimo emprestimo = mapper.toEntity(dto);

        List<Emprestimo> lista = dao.buscarTodos();

        for (Emprestimo emp : lista) {
            if (emp.getLivroId().equals(emprestimo.getLivroId())
                    && emp.getDataDevolucao() == null) {
                throw new RuntimeException("Livro já emprestado!");
            }
        }

        dao.salvar(emprestimo);
    }

    public List<EmprestimoResponseDto> listarTodos() {
        return dao.buscarTodos()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public EmprestimoResponseDto buscarPorId(Long id) {
        return mapper.toDto(dao.buscarPorId(id));
    }

    public void finalizarEmprestimo(Long id) {
        Emprestimo e = dao.buscarPorId(id);
        e.setDataDevolucao(LocalDate.now());
        dao.atualizar(e);
    }
}