package org.example;

import org.example.repository.Aluno;
import org.example.repository.Turma;

public class Main {
    public static void main(String[] args) {

        // Repositories
        Aluno alunoRepository = new Aluno();
        Turma turmaRepository = new Turma();

        // Services: injeção das dependências
        org.example.service.Aluno alunoService = new org.example.service.Aluno(
                alunoRepository,
                turmaRepository
        );

        org.example.service.Turma turmaService = new org.example.service.Turma(
                turmaRepository,
                alunoRepository
        );

        // UI: injeção dos Services
        org.example.ui.Aluno alunoUI = new org.example.ui.Aluno(alunoService);
        org.example.ui.Turma turmaUI = new org.example.ui.Turma(turmaService);

        // Cadastro de alunos
        System.out.println("========== CADASTRO DE ALUNOS ==========");
        alunoUI.cadastrar(1, "André Felipe");
        alunoUI.cadastrar(2, "Bruno Silva");
        alunoUI.cadastrar(3, "Carlos Souza");
        alunoUI.cadastrar(4, "Daniel Oliveira");
        alunoUI.cadastrar(5, "Eduardo Santos");
        alunoUI.cadastrar(6, "Felipe Costa");

        // Cadastro de turmas
        System.out.println("\n========== CADASTRO DE TURMAS ==========");
        turmaUI.cadastrar(101, "Programação Java");
        turmaUI.cadastrar(102, "Banco de Dados");
        turmaUI.cadastrar(103, "Engenharia de Software");

        // Matrícula de alunos na turma 101
        System.out.println("\n========== MATRÍCULAS DA TURMA 101 ==========");
        turmaUI.matricular(101, 1);
        turmaUI.matricular(101, 2);
        turmaUI.matricular(101, 3);
        turmaUI.matricular(101, 4);
        turmaUI.matricular(101, 5);

        // Tentativa de ultrapassar o limite de alunos
        System.out.println("\n========== TESTE DE LIMITE DE MATRÍCULAS ==========");
        turmaUI.matricular(101, 6);

        // Matrícula de alunos na turma 102
        System.out.println("\n========== TESTE DE ABERTURA DE TURMA ==========");
        turmaUI.matricular(102, 1);
        turmaUI.abrir(102);
        turmaUI.matricular(102, 2);

        // Abertura das turmas
        System.out.println("\n========== ABERTURA DE TURMAS ==========");
        turmaUI.abrir(101);
        turmaUI.abrir(102);

        // Exibição de todos os alunos
        System.out.print("\n========== CONSULTA TODOS OS ALUNOS ==========");
        alunoUI.exibirAlunos();

        // Exibição de todas as turmas
        System.out.print("\n========== CONSULTA TODAS AS TURMAS ==========");
        turmaUI.exibirTurmas();

        // Exibição das pautas
        System.out.print("\n========== CONSULTA PAUTAS ==========");
        turmaUI.exibirPauta(101);
        turmaUI.exibirPauta(102);

        // Consulta das turmas de um aluno em específico
        System.out.print("\n========== TURMAS DE UM ALUNO ESPECÍFICO ==========");
        alunoUI.exibirTurmasDoAluno(1);

        // Tentativa de excluir turma já aberta
        System.out.println("\n========== EXCLUSÃO DE TURMAS ==========");
        turmaUI.excluir(101);

        // Exclusão de turma ainda não aberta
        turmaUI.excluir(103);

        turmaUI.exibirTurmas();
    }
}