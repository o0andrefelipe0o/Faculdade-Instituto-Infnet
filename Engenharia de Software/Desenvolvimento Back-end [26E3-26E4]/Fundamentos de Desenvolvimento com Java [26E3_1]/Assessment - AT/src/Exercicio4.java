import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o valor do empréstimo: R$ ");
        double valorEmprestimo = scanner.nextDouble();

        int parcelas;

        do {
            System.out.print("Informe a quantidade de parcelas (6 a 48): ");
            parcelas = scanner.nextInt();

            if (parcelas < 6 || parcelas > 48) {
                System.out.println("Quantidade inválida. Informe um valor entre 6 e 48.");
            }

        } while (parcelas < 6 || parcelas > 48);

        double juros = 0.03;
        double valorTotal = valorEmprestimo * (1 + (juros * parcelas));
        double valorParcela = valorTotal / parcelas;

        System.out.println("\nCliente: " + nome);
        System.out.printf("Valor do empréstimo: R$ %.2f%n", valorEmprestimo);
        System.out.println("Quantidade de parcelas: " + parcelas);
        System.out.printf("Valor total pago: R$ %.2f%n", valorTotal);
        System.out.printf("Valor da parcela mensal: R$ %.2f%n", valorParcela);

        scanner.close();
    }
}