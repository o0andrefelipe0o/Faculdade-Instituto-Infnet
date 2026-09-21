import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe seu nome: ");
        String nome = scanner.nextLine();

        while (true) {

            System.out.print("Informe sua senha: ");
            String senha = scanner.nextLine();

            boolean temMaiuscula = false;
            boolean temNumero = false;
            boolean temEspecial = false;

            for (char c : senha.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    temMaiuscula = true;
                } else if (Character.isDigit(c)) {
                    temNumero = true;
                } else if (!Character.isLetterOrDigit(c)) {
                    temEspecial = true;
                }
            }

            if (senha.length() < 8) {
                System.out.println("Erro: a senha deve ter no mínimo 8 caracteres.");
            } else if (!temMaiuscula) {
                System.out.println("Erro: a senha deve conter pelo menos uma letra maiúscula.");
            } else if (!temNumero) {
                System.out.println("Erro: a senha deve conter pelo menos um número.");
            } else if (!temEspecial) {
                System.out.println("Erro: a senha deve conter pelo menos um caractere especial.");
            } else {
                System.out.println("Senha válida! Cadastro realizado para " + nome + ".");
                break;
            }
        }

        scanner.close();
    }
}