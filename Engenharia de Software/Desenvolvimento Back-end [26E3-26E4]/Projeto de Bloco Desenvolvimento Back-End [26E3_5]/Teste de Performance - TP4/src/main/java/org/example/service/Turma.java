package org.example.service;

import org.example.repository.Aluno;

import java.util.List;
import java.util.Optional;

public class Turma {
    private static final int MIN_ALUNOS = 2;
    private static final int MAX_ALUNOS = 5;

    private final org.example.repository.Turma turmaRepository;
    private final Aluno alunoRepository;

    public Turma(
            org.example.repository.Turma turmaRepository,
            Aluno alunoRepository
    ) {
        this.turmaRepository = turmaRepository;
        this.alunoRepository = alunoRepository;
    }

    public void cadastrar(int idTurma, String nome) {
        validarDados(idTurma, nome);

        Optional<org.example.models.Turma> existente = turmaRepository.buscarPorId(idTurma);

        if (existente.isPresent()) {
            throw new IllegalArgumentException(
                    "Já existe uma turma cadastrada com esse ID: "
                            + descrever(existente.get()) + "."
            );
        }

        org.example.models.Turma turma = new org.example.models.Turma(idTurma, nome.trim());
        turmaRepository.adicionar(turma);
    }

    public List<org.example.models.Turma> listarTodas() {
        return turmaRepository.listarTodos();
    }

    public void matricular(int idTurma, int idAluno) {
        org.example.models.Turma turma = buscarTurma(idTurma);

        org.example.models.Aluno aluno = alunoRepository.buscarPorId(idAluno)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Aluno com ID " + idAluno + " não encontrado."
                        )
                );

        if (turma.getAlunos().size() >= MAX_ALUNOS) {
            throw new IllegalStateException(
                    "A turma " + descrever(turma) + " já atingiu o limite de cinco alunos "
                            + "e não pode receber o aluno " + descrever(aluno) + "."
            );
        }

        boolean jaMatriculado = turma.getAlunos()
                .stream()
                .anyMatch(a -> a.getIdAluno() == idAluno);

        if (jaMatriculado) {
            throw new IllegalStateException(
                    "O aluno " + descrever(aluno) + " já está matriculado na turma "
                            + descrever(turma) + "."
            );
        }

        turma.matricular(aluno);
    }

    public void abrir(int idTurma) {
        org.example.models.Turma turma = buscarTurma(idTurma);

        if (turma.getAlunos().size() < MIN_ALUNOS) {
            throw new IllegalStateException(
                    "A turma " + descrever(turma) + " precisa ter pelo menos dois alunos "
                            + "para ser aberta (alunos matriculados: "
                            + turma.getAlunos().size() + ")."
            );
        }

        turma.abrir();
    }

    public List<org.example.models.Aluno> exibirPauta(int idTurma) {
        return buscarTurma(idTurma).getAlunos();
    }

    public void excluir(int idTurma) {
        org.example.models.Turma turma = buscarTurma(idTurma);

        if (turma.isAberta()) {
            throw new IllegalStateException(
                    "A turma " + descrever(turma) + " já foi aberta e não pode ser excluída."
            );
        }

        turmaRepository.remover(idTurma);
    }

    private org.example.models.Turma buscarTurma(int idTurma) {
        return turmaRepository.buscarPorId(idTurma)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Turma com ID " + idTurma + " não encontrada."
                        )
                );
    }

    private String descrever(org.example.models.Turma turma) {
        return turma.getNome() + " (ID " + turma.getIdTurma() + ")";
    }

    private String descrever(org.example.models.Aluno aluno) {
        return aluno.getNome() + " (ID " + aluno.getIdAluno() + ")";
    }

    private void validarDados(int idTurma, String nome) {
        if (idTurma <= 0) {
            throw new IllegalArgumentException(
                    "O ID da turma deve ser maior que zero."
            );
        }

        if (nome == null || nome.trim().length() <= 2) {
            throw new IllegalArgumentException(
                    "O nome da turma deve possuir mais de dois caracteres."
            );
        }
    }
}