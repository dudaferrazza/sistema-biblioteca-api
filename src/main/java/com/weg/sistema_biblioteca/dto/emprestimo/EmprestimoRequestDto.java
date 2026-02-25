package com.weg.sistema_biblioteca.dto.emprestimo;

import java.time.LocalDate;

public record EmprestimoRequestDto(
        Long livroId,
        Long usuarioId,
        LocalDate dataEmprestimo,
        LocalDate dataDevolucao
){
}
