package org.example.ui;

import org.example.models.Turma;

import java.util.List;

public class Aluno {
    private final org.example.service.Aluno alunoService;

    public Aluno(org.example.service.Aluno alunoService) {
        this.alunoService = alunoService;
    }

    public void cadastrar(int idAluno, String nome) {
        try {
            alunoService.cadastrar(idAluno, nome);
            System.out.println("Aluno " + nome.trim() + " (ID " + idAluno + ") cadastrado com sucesso.");
        } catch (RuntimeException e) {
            System.out.println("Erro ao cadastrar aluno " + nome + " (ID " + idAluno + "): " + e.getMessage());
        }
    }

    public void exibirAlunos() {
        System.out.println("\n--- Alunos cadastrados ---");

        List<org.example.models.Aluno> alunos = alunoService.listarTodos();

        for (org.example.models.Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    public void exibirTurmasDoAluno(int idAluno) {
        String aluno = descreverAluno(idAluno);

        try {
            System.out.println("\n--- Turmas do aluno " + aluno + " ---");

            List<Turma> turmas =
                    alunoService.listarTurmasDoAluno(idAluno);

            if (turmas.isEmpty()) {
                System.out.println("O aluno " + aluno + " não está matriculado em nenhuma turma.");
                return;
            }

            for (Turma turma : turmas) {
                System.out.println(turma);
            }
        } catch (RuntimeException e) {
            System.out.println("Erro ao consultar as turmas do aluno " + aluno + ": " + e.getMessage());
        }
    }

    // Retorna "Nome (ID n)"; se o aluno não existir, retorna apenas "ID n".
    private String descreverAluno(int idAluno) {
        return alunoService.listarTodos()
                .stream()
                .filter(aluno -> aluno.getIdAluno() == idAluno)
                .findFirst()
                .map(aluno -> aluno.getNome() + " (ID " + aluno.getIdAluno() + ")")
                .orElse("ID " + idAluno);
    }
}