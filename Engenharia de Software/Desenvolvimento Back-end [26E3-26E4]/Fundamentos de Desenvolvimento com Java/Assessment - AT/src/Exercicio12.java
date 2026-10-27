import java.util.Scanner;

public class Exercicio12 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] mensagens = new String[10];
        String[] usuarios = new String[10];

        System.out.print("Informe o nome do primeiro usuário: ");
        String usuario1 = scanner.nextLine();

        System.out.print("Informe o nome do segundo usuário: ");
        String usuario2 = scanner.nextLine();

        for (int i = 0; i < 10; i++) {

            if (i % 2 == 0) {
                System.out.print(usuario1 + ", Informe sua mensagem: ");
                mensagens[i] = scanner.nextLine();
                usuarios[i] = usuario1;
            } else {
                System.out.print(usuario2 + ", Informe sua mensagem: ");
                mensagens[i] = scanner.nextLine();
                usuarios[i] = usuario2;
            }
        }

        System.out.println("\n===== Histórico de Mensagens =====");

        for (int i = 0; i < 10; i++) {
            System.out.println(usuarios[i] + ": " + mensagens[i]);
        }

        System.out.println("\nObrigado por utilizarem o sistema! Boa sorte para vocês! 🚀");

        scanner.close();
    }
}