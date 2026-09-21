import java.util.Scanner;

public class Exercicio3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe seu salário mensal: R$ ");
        double salarioMensal = scanner.nextDouble();

        double salarioAnual = salarioMensal * 12;
        double percentualImposto;

        if (salarioAnual <= 22847.76) {
            percentualImposto = 0;
        } else if (salarioAnual <= 33919.80) {
            percentualImposto = 0.075;
        } else if (salarioAnual <= 45012.60) {
            percentualImposto = 0.15;
        } else {
            percentualImposto = 0.275;
        }

        double imposto = salarioAnual * percentualImposto;
        double salarioLiquidoAnual = salarioAnual - imposto;
        double salarioLiquidoMensal = salarioLiquidoAnual / 12;

        System.out.println("\nNome: " + nome);
        System.out.printf("Salário anual: R$ %.2f%n", salarioAnual);
        System.out.printf("Imposto: R$ %.2f%n", imposto);
        System.out.printf("Salário líquido anual: R$ %.2f%n", salarioLiquidoAnual);
        System.out.printf("Salário líquido mensal: R$ %.2f%n", salarioLiquidoMensal);

        scanner.close();
    }
}