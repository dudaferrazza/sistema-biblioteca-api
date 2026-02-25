package com.weg.sistema_biblioteca.mapper.emprestimo;

import com.weg.sistema_biblioteca.dto.emprestimo.EmprestimoRequestDto;
import com.weg.sistema_biblioteca.dto.emprestimo.EmprestimoResponseDto;
import com.weg.sistema_biblioteca.model.Emprestimo;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoMapper {

    public Emprestimo toEntity(EmprestimoRequestDto emprestimoRequestDto) {
        return new Emprestimo(emprestimoRequestDto.livroId(), emprestimoRequestDto.usuarioId(), emprestimoRequestDto.dataEmprestimo(), emprestimoRequestDto.dataDevolucao());
    }

    public EmprestimoResponseDto toDto(Emprestimo emprestimo) {
        return new EmprestimoResponseDto(
                emprestimo.getId(),
                emprestimo.getLivroId(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolucao()
        );
    }
}
