package org.example.ui;

import org.example.models.Aluno;

import java.util.List;

public class Turma {
    private final org.example.service.Turma turmaService;

    public Turma(org.example.service.Turma turmaService) {
        this.turmaService = turmaService;
    }

    public void cadastrar(int idTurma, String nome) {
        try {
            turmaService.cadastrar(idTurma, nome);
            System.out.println("Turma " + nome.trim() + " (ID " + idTurma + ") cadastrada com sucesso.");
        } catch (RuntimeException e) {
            System.out.println("Erro ao cadastrar turma " + nome + " (ID " + idTurma + "): " + e.getMessage());
        }
    }

    public void exibirTurmas() {
        System.out.println("\n--- Turmas cadastradas ---");

        List<org.example.models.Turma> turmas = turmaService.listarTodas();

        for (org.example.models.Turma turma : turmas) {
            System.out.println(turma);
        }
    }

    public void matricular(int idTurma, int idAluno) {
        try {
            turmaService.matricular(idTurma, idAluno);
            System.out.println("Aluno " + descreverAlunoDaTurma(idTurma, idAluno)
                    + " matriculado na turma " + descreverTurma(idTurma) + " com sucesso.");
        } catch (RuntimeException e) {
            System.out.println("Erro ao matricular aluno: " + e.getMessage());
        }
    }

    public void abrir(int idTurma) {
        try {
            turmaService.abrir(idTurma);
            System.out.println("Turma " + descreverTurma(idTurma) + " aberta com sucesso.");
        } catch (RuntimeException e) {
            System.out.println("Erro ao abrir turma: " + e.getMessage());
        }
    }

    public void exibirPauta(int idTurma) {
        try {
            System.out.println("\n--- Pauta da turma " + descreverTurma(idTurma) + " ---");

            List<Aluno> alunos = turmaService.exibirPauta(idTurma);

            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        } catch (RuntimeException e) {
            System.out.println("Erro ao exibir pauta: " + e.getMessage());
        }
    }

    public void excluir(int idTurma) {
        String turma = descreverTurma(idTurma); // Descrição obtida antes, pois depois da exclusão a turma deixa de existir.

        try {
            turmaService.excluir(idTurma);
            System.out.println("Turma " + turma + " excluída com sucesso.");
        } catch (RuntimeException e) {
            System.out.println("Erro ao excluir turma: " + e.getMessage());
        }
    }

    // Retorna "Nome (ID n)"; se a turma não existir, retorna apenas "ID n".
    private String descreverTurma(int idTurma) {
        return turmaService.listarTodas()
                .stream()
                .filter(t -> t.getIdTurma() == idTurma)
                .findFirst()
                .map(t -> t.getNome() + " (ID " + t.getIdTurma() + ")")
                .orElse("ID " + idTurma);
    }

    // Retorna "Nome (ID n)" do aluno a partir da pauta da turma; se não estiver nela, retorna "ID n".
    private String descreverAlunoDaTurma(int idTurma, int idAluno) {
        return turmaService.exibirPauta(idTurma)
                .stream()
                .filter(a -> a.getIdAluno() == idAluno)
                .findFirst()
                .map(a -> a.getNome() + " (ID " + a.getIdAluno() + ")")
                .orElse("ID " + idAluno);
    }
}