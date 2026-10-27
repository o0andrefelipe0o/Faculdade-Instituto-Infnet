import java.util.Random;
import java.util.Scanner;

public class Exercicio11 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] sorteados = new int[6];
        int[] usuario = new int[6];

        for (int i = 0; i < 6; i++) {
            sorteados[i] = random.nextInt(60) + 1;
        }

        System.out.println("Informe 6 números entre 1 e 60:");

        for (int i = 0; i < 6; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            usuario[i] = scanner.nextInt();
        }

        int acertos = 0;

        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 6; j++) {

                if (usuario[i] == sorteados[j]) {
                    acertos++;
                    break;
                }
            }
        }

        System.out.print("\nNúmeros sorteados: ");

        for (int numero : sorteados) {
            System.out.print(numero + " ");
        }

        System.out.println("\nQuantidade de acertos: " + acertos);

        scanner.close();
    }
}