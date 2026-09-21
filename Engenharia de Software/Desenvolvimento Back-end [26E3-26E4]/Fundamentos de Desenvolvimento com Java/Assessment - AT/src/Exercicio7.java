import java.util.Scanner;

class Aluno {

    String nome;
    String matricula;
    double nota1;
    double nota2;
    double nota3;

    public Aluno(String nome, String matricula, double nota1, double nota2, double nota3) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public double calcularMedia() {
        return (nota1 + nota2 + nota3) / 3;
    }

    public void verificarAprovacao() {

        double media = calcularMedia();

        System.out.printf("Média: %.2f%n", media);

        if (media >= 7) {
            System.out.println("Aluno aprovado.");
        } else {
            System.out.println("Aluno reprovado.");
        }
    }
}

public class Exercicio7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Informe a matrícula: ");
        String matricula = scanner.nextLine();

        System.out.print("Informe a primeira nota: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Informe a segunda nota: ");
        double nota2 = scanner.nextDouble();

        System.out.print("Informe a terceira nota: ");
        double nota3 = scanner.nextDouble();

        Aluno aluno = new Aluno(nome, matricula, nota1, nota2, nota3);

        System.out.println("\n=== Situação do Aluno ===");
        System.out.println("Nome: " + aluno.nome);
        System.out.println("Matrícula: " + aluno.matricula);
        aluno.verificarAprovacao();

        scanner.close();
    }
}