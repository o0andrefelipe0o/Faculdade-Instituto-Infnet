package org.example.service;

import org.example.repository.Turma;

import java.util.List;
import java.util.stream.Collectors;

public class Aluno {
    private final org.example.repository.Aluno alunoRepository;
    private final Turma turmaRepository;

    public Aluno(
            org.example.repository.Aluno alunoRepository,
            Turma turmaRepository
    ) {
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
    }

    public void cadastrar(int idAluno, String nome) {
        validarDados(idAluno, nome);

        if (alunoRepository.buscarPorId(idAluno).isPresent()) {
            throw new IllegalArgumentException(
                    "Já existe um aluno cadastrado com esse ID " + idAluno + "."
            );
        }

        org.example.models.Aluno aluno = new org.example.models.Aluno(idAluno, nome.trim());
        alunoRepository.adicionar(aluno);
    }

    public List<org.example.models.Aluno> listarTodos() {
        return alunoRepository.listarTodos();
    }

    public List<org.example.models.Turma> listarTurmasDoAluno(int idAluno) {
        org.example.models.Aluno aluno = alunoRepository.buscarPorId(idAluno)
                .orElseThrow(() ->
                        new IllegalArgumentException("Aluno com ID " + idAluno + " não encontrado.")
                );

        return turmaRepository.listarTodos()
                .stream()
                .filter(turma -> turma.getAlunos()
                        .stream()
                        .anyMatch(matriculado ->
                                matriculado.getIdAluno() == aluno.getIdAluno()
                        )
                )
                .collect(Collectors.toList());
    }

    private void validarDados(int idAluno, String nome) {
        if (idAluno <= 0) {
            throw new IllegalArgumentException(
                    "O ID do aluno deve ser maior que zero."
            );
        }

        if (nome == null || nome.trim().length() <= 2) {
            throw new IllegalArgumentException(
                    "O nome do aluno deve possuir mais de dois caracteres."
            );
        }
    }
}