package com.weg.sistema_biblioteca.dto.emprestimo;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record EmprestimoRequestDto(

        @NotNull(message = "livroId não pode ser nulo")
        Long livroId,

        @NotNull(message = "usuarioId não pode ser nulo")
        Long usuarioId,

        @NotNull(message = "dataEmprestimo não pode ser nula")
        @PastOrPresent(message = "dataEmprestimo deve ser hoje ou uma data passada")
        LocalDate dataEmprestimo,

        @NotNull(message = "dataDevolucao não pode ser nula")
        @Future(message = "dataDevolucao deve ser uma data futura")
        LocalDate dataDevolucao
){
}
