package com.weg.sistema_biblioteca.dto.emprestimo;

import java.time.LocalDate;

public record EmprestimoResponseDto(
        Long id,
        Long livroId,
        LocalDate dataEmprestimo,
        LocalDate dataDevolucao
){
}
