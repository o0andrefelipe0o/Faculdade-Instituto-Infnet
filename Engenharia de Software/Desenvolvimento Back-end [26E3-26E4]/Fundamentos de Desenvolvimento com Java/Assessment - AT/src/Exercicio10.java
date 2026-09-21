import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Exercicio10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            FileWriter arquivo = new FileWriter("compras.txt");

            for (int i = 1; i <= 3; i++) {

                System.out.println("\nCompra " + i);

                System.out.print("Produto: ");
                String produto = scanner.nextLine();

                System.out.print("Quantidade: ");
                int quantidade = Integer.parseInt(scanner.nextLine());

                System.out.print("Preço unitário: R$ ");
                double preco = Double.parseDouble(scanner.nextLine());

                arquivo.write("Produto: " + produto + "\n");
                arquivo.write("Quantidade: " + quantidade + "\n");
                arquivo.write(String.format("Preço unitário: R$ %.2f%n", preco));
                arquivo.write("-------------------------\n");
            }

            arquivo.close();

            System.out.println("\n-- Compras registradas --");

            BufferedReader leitor = new BufferedReader(new FileReader("compras.txt"));

            String linha;

            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }

            leitor.close();

        } catch (IOException e) {
            System.out.println("Erro ao manipular o arquivo: " + e.getMessage());
        }

        scanner.close();
    }
}