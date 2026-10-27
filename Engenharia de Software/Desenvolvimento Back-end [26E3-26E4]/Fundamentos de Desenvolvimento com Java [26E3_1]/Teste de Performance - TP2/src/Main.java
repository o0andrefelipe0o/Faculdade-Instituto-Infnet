import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

/*
 ======================================================================
 Parte 1 Escrever programas que utilizam entrada do usuário
 ======================================================================
 */

/*
 ----------------------------------------------------------------------

Exercício 1: Cadastro de Usuário Completo Enunciado
 Crie um programa em Java que solicite ao usuário seu nome completo, idade, nome da mãe e nome do pai. O programa deve exibir as informações de forma organizada e verificar se o nome do usuário tem mais letras que o nome da mãe ou do pai.

 Observações:
 - Utilize a classe Scanner para capturar todas as entradas do usuário.
 - Compare os tamanhos das strings para determinar o nome mais longo.

 Considerações:
 - Uso correto da classe Scanner para entrada de dados.
 - Comparação correta do tamanho das strings.
 - Exibição organizada das informações.
 */
class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe seu nome completo: ");
        String nome = scanner.nextLine();

        System.out.print("Informe sua idade: ");
        String idade = scanner.nextLine();

        System.out.print("Informe o nome da sua mãe: ");
        String nomeMae = scanner.nextLine();

        System.out.print("Informe o nome do seu pai: ");
        String nomePai = scanner.nextLine();

        System.out.println("\n=== DADOS DO USUÁRIO ===");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Mãe: " + nomeMae);
        System.out.println("Pai: " + nomePai);

        int tamanhoNome = nome.length();
        int tamanhoMae = nomeMae.length();
        int tamanhoPai = nomePai.length();

        System.out.println("\n=== COMPARAÇÃO DOS NOMES ===");

        if (tamanhoNome > tamanhoMae && tamanhoNome > tamanhoPai) {
            System.out.println("Seu nome tem mais letras que o nome da sua mãe e do seu pai.");
        } else if (tamanhoNome == tamanhoMae && tamanhoNome == tamanhoPai) {
            System.out.println("Seu nome possui a mesma quantidade de letras que o nome da sua mãe e do seu pai.");
        } else if (tamanhoNome > tamanhoMae) {
            System.out.println("Seu nome tem mais letras que o nome da sua mãe.");
        } else if (tamanhoNome == tamanhoMae) {
            System.out.println("Seu nome possui a mesma quantidade de letras que o nome da sua mãe.");
        } else if (tamanhoNome > tamanhoPai) {
            System.out.println("Seu nome tem mais letras que o nome do seu pai.");
        } else if (tamanhoNome == tamanhoPai) {
            System.out.println("Seu nome possui a mesma quantidade de letras que o nome do seu pai.");
        } else {
            System.out.println("Seu nome não possui mais letras que o nome da sua mãe ou do seu pai.");
        }
        scanner.close();
    }
}

/*
 ----------------------------------------------------------------------

 Exercício 2: Calculadora de Média de Notas Enunciado
 Desenvolva um programa que solicite ao usuário quatro notas bimestrais. O programa deve calcular a média e informar se o usuário foi aprovado (média >= 7), está em recuperação (média entre 5 e 6.9) ou foi reprovado (média < 5).

 Observações:
 - Utilize a classe Scanner para entrada de dados.
 - Realize o cálculo da média aritmética.
 - Exiba uma mensagem personalizada com o resultado.

 Considerações:
 - Uso correto da classe Scanner.
 - Cálculo correto da média.
 - Verificação correta das condições para aprovação, recuperação e reprovação.
 */
class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a primeira nota em numeral: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Informe a segunda nota em numeral: ");
        double nota2 = scanner.nextDouble();

        System.out.print("Informe a terceira nota em numeral: ");
        double nota3 = scanner.nextDouble();

        System.out.print("Informe a quarta nota em numeral: ");
        double nota4 = scanner.nextDouble();

        double media = (nota1 + nota2 + nota3 + nota4) / 4;

        System.out.printf("\nMédia final: %.2f%n", media);

        if (media >= 7) {
            System.out.println("Situação: Aprovado!");
        } else if (media >= 5) {
            System.out.println("Situação: Recuperação.");
        } else {
            System.out.println("Situação: Reprovado.");
        }

        scanner.close();
    }
}

/*
 ----------------------------------------------------------------------

 Exercício 3: Conversor de Moedas Enunciado
 Crie um programa que peça ao usuário um valor em reais e uma moeda de destino (dólar, euro ou libra). O programa deve converter o valor informado na moeda escolhida com base em taxas de câmbio pré-definidas no código.

 Observações:
 - Utilize a classe Scanner para capturar o valor e a moeda de destino.
 - Defina as taxas de câmbio diretamente no código.
 - Exiba o valor convertido com duas casas decimais.

 Considerações:
 - Uso correto da classe Scanner para entrada de dados.
 - Conversão correta do valor com base na taxa de câmbio.
 - Formatação adequada da saída com duas casas decimais.
 */
class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taxas
        double taxaDolar = 5.40;
        double taxaEuro = 6.30;
        double taxaLibra = 7.30;

        System.out.print("Informe o valor na moeda Real em numeral: R$ ");
        String input = scanner.nextLine().replace(",", ".");
        double valorReais = Double.parseDouble(input);

        System.out.println("\nEscolha a moeda de destino:");
        System.out.println("1 - Dólar");
        System.out.println("2 - Euro");
        System.out.println("3 - Libra");

        System.out.print("Informe o número correspondente à opção desejada em numeral inteiro:");
        int opcao = scanner.nextInt();

        double valorConvertido;

        switch (opcao) {
            case 1:
                valorConvertido = valorReais / taxaDolar;
                System.out.printf("Valor em dólar: US$ %.2f%n", valorConvertido);
                break;

            case 2:
                valorConvertido = valorReais / taxaEuro;
                System.out.printf("Valor em euro: € %.2f%n", valorConvertido);
                break;

            case 3:
                valorConvertido = valorReais / taxaLibra;
                System.out.printf("\nValor em libra: £ %.2f%n", valorConvertido);
                break;

            default:
                System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}

/*
 ----------------------------------------------------------------------

 Exercício 4: Calculadora de Idade em Dias Enunciado
 Escreva um programa que solicite a data de nascimento do usuário (dia, mês e ano) e calcule sua idade em dias.

 Observações:
 - Utilize a classe Scanner para capturar a data de nascimento.
 - Considere anos bissextos no cálculo.
 - Exiba a idade total em dias.

 Considerações:
 - Uso correto da classe Scanner para entrada de dados.
 - Cálculo correto considerando anos bissextos.
 - Exibição correta do total de dias.
 */
class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o dia de nascimento em numeral inteiro: ");
        int dia = scanner.nextInt();

        System.out.print("Informe o mês de nascimento em numeral inteiro: ");
        int mes = scanner.nextInt();

        System.out.print("Informe o ano de nascimento em numeral inteiro: ");
        int ano = scanner.nextInt();

        LocalDate nascimento = LocalDate.of(ano, mes, dia);
        LocalDate hoje = LocalDate.now();

        if (nascimento.isAfter(hoje)) {
            System.out.println("A data de nascimento não pode estar no futuro.");
        } else {
            long idadeEmDias = 0;
            while (nascimento.isBefore(hoje)) {
                idadeEmDias++;
                nascimento = nascimento.plusDays(1);
            }

            System.out.println("\nData de nascimento: " + nascimento);
            System.out.println("Data atual: " + hoje);
            System.out.println("Idade em dias: " + idadeEmDias);
        }

        scanner.close();
    }
}

/*
 ======================================================================
 Parte 2 Escrever códigos usando elementos de controle de fluxo
 ======================================================================
 */

/*
  ----------------------------------------------------------------------

Exercício 5: Calculadora de Descontos Progressivos
 Enunciado: Crie um programa que solicite o valor de uma compra e calcule o desconto aplicável com base no valor total. Se o valor for maior que R$ 1000, aplique um desconto de 10%; entre R$ 500 e R$ 1000, aplique 5%; abaixo de R$ 500, não há desconto.

 Observações:
 - Utilize estruturas condicionais para verificar o valor e aplicar o desconto.
 - Exiba o valor original, o desconto aplicado e o valor final.

 Considerações:
 - Uso correto das estruturas condicionais.
 - Cálculo correto do desconto e do valor final.
 - Exibição clara das informações.
 */
class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o valor da compra em numeral: R$ ");
        String input = scanner.nextLine().replace(",", ".");
        double valorCompra = Double.parseDouble(input);

        double percentualDesconto;

        if (valorCompra > 1000) {
            percentualDesconto = 10;
        } else if (valorCompra >= 500) {
            percentualDesconto = 5;
        } else {
            percentualDesconto = 0;
        }

        double valorDesconto = valorCompra * percentualDesconto / 100;
        double valorFinal = valorCompra - valorDesconto;

        System.out.println("\n=== RESUMO DA COMPRA ===");
        System.out.printf("Valor original: R$ %.2f%n", valorCompra);
        System.out.printf("Desconto: %.0f%%%n", percentualDesconto);
        System.out.printf("Valor do desconto: R$ %.2f%n", valorDesconto);
        System.out.printf("Valor final: R$ %.2f%n", valorFinal);

        scanner.close();
    }
}

/*
 ----------------------------------------------------------------------

 Exercício 6: Verificador de Ano Bissexto Enunciado
 Desenvolva um programa que peça um ano ao usuário e verifique se ele é bissexto.

 Observações:
 - Utilize estruturas condicionais para verificar as condições de ano bissexto.
 - Exiba uma mensagem indicando se o ano é ou não bissexto.

 Considerações:
 - Uso correto das estruturas condicionais.
 - Lógica correta para verificação de ano bissexto.
 - Exibição clara da mensagem final.
 */
class Exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe um ano em numeral inteiro: ");
        int ano = scanner.nextInt();

        boolean bissexto;

        if ((ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0)) {
            bissexto = true;
        } else {
            bissexto = false;
        }

        if (bissexto) {
            System.out.println("O ano " + ano + " é bissexto.");
        } else {
            System.out.println("O ano " + ano + " não é bissexto.");
        }

        scanner.close();
    }
}

/*
 ----------------------------------------------------------------------

 Exercício 7: Calculadora de Imposto de Renda
 Crie um programa que solicite ao usuário seu salário bruto anual e calcule o imposto de renda a pagar com base em alíquotas definidas no código. Utilize faixas de renda progressivas
 para calcular o imposto.

 Observações:
 - Utilize estruturas condicionais para aplicar as alíquotas.
 - Exiba o valor do imposto a pagar e o salário líquido.

 Considerações:
 - Uso correto das estruturas condicionais.
 - Cálculo correto do imposto de renda progressivo.
 - Exibição organizada das informações.
 */
class Exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o salário bruto anual em numeral: R$ ");
        String input = scanner.nextLine().replace(",", ".");
        double salario = Double.parseDouble(input);

        double imposto;

        /*
         Faixas utilizadas:

         Até R$ 30.000         -> 0%
         De R$ 30.000 a 60.000 -> 10%
         De R$ 60.000 a 90.000 -> 20%
         Acima de R$ 90.000    -> 27,5%
         */

        // Essa lógica de progressão aqui é bem confusa, entendi pouco
        if (salario <= 30000) {
            imposto = 0;

        } else if (salario <= 60000) {
            imposto = (salario - 30000) * 0.10;

        } else if (salario <= 90000) {
            imposto = (30000 * 0.10)
                    + (salario - 60000) * 0.20;

        } else {
            imposto = (30000 * 0.10)
                    + (30000 * 0.20)
                    + (salario - 90000) * 0.275;
        }

        double salarioLiquido = salario - imposto;

        System.out.println("\n=== RESULTADO ===");
        System.out.printf("Salário bruto: R$ %.2f%n", salario);
        System.out.printf("Imposto a pagar: R$ %.2f%n", imposto);
        System.out.printf("Salário líquido: R$ %.2f%n", salarioLiquido);

        scanner.close();
    }
}

/*
 ----------------------------------------------------------------------

 Exercício 8: Classificação de Triângulos
 Escreva um programa que solicite ao usuário os comprimentos de três lados de um triângulo e determine se ele é equilátero, isósceles ou escaleno.

 Observações:
 - Utilize estruturas condicionais para verificar os tipos de triângulo.
 - Verifique também se as medidas formam um triângulo válido.

 Considerações:
 - Uso correto das estruturas condicionais.
 - Verificação correta da validade do triângulo.
 - Classificação correta do tipo de triângulo.
 */
class Exercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o comprimento do primeiro lado do triângulo em numeral: ");
        String input = scanner.nextLine().replace(",", ".");
        double lado1 = Double.parseDouble(input);

        System.out.print("Informe o comprimento do segundo lado do triângulo em numeral: ");
        input = scanner.nextLine().replace(",", ".");
        double lado2 = Double.parseDouble(input);

        System.out.print("Informe o comprimento do terceiro lado do triângulo em numeral: ");
        input = scanner.nextLine().replace(",", ".");
        double lado3 = Double.parseDouble(input);

        if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
            System.out.println("Os lados devem ser maiores que zero.");

        } else if (lado1 + lado2 <= lado3
                || lado1 + lado3 <= lado2
                || lado2 + lado3 <= lado1) {

            System.out.println("As medidas informadas não formam um triângulo.");

        } else if (lado1 == lado2 && lado2 == lado3) {
            System.out.println("Triângulo equilátero.");

        } else if (lado1 == lado2
                || lado1 == lado3
                || lado2 == lado3) {

            System.out.println("Triângulo isósceles.");

        } else {
            System.out.println("Triângulo escaleno.");
        }

        scanner.close();
    }
}

/*
 ======================================================================
 Parte 3 Escrever códigos usando instruções de repetição
 ======================================================================
 */

/*
  ----------------------------------------------------------------------

 Exercício 9: Validador de Senha Enunciado
 Crie um programa que solicite ao usuário que cadastre uma senha e, em seguida, peça a senha novamente até que seja digitada corretamente.

 Observações:
 - Utilize um laço de repetição para solicitar a senha até que esteja correta.
 - Exiba uma mensagem de sucesso ao final.

 Considerações:
 - Uso correto do laço de repetição.
 - Comparação correta das strings para validar a senha.
 - Exibição correta da mensagem de sucesso.
 */
class Exercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Cadastre sua senha: ");
        String senha = scanner.nextLine();

        String input;

        do {
            System.out.print("Informe a senha cadastrada novamente: ");
            input = scanner.nextLine();

            if (!input.equals(senha)) {
                System.out.print("\u001B[31m");
                System.out.print("Senha incorreta! ");
            }
        } while (!input.equals(senha));

        System.out.print("\u001B[32m");
        System.out.println("Senha cadastrada com sucesso!");
        System.out.print("\u001B[0m");
        scanner.close();
    }
}

/*
 ----------------------------------------------------------------------

 Exercício 10: Jogo de Adivinhação Enunciado
 Desenvolva um jogo de adivinhação em que o usuário deve descobrir um número gerado aleatoriamente pelo programa (entre 1 e 100). O programa deve informar se o palpite é maior ou menor
 que o número sorteado até que o usuário acerte.

 Observações:
 - Utilize um laço de repetição para permitir múltiplos palpites.
 - Utilize a classe Random para gerar o número secreto.

 Considerações:
 - Uso correto do laço de repetição.
 - Comparação correta do palpite com o número secreto.
 - Exibição adequada das dicas para o usuário.
 */
class Exercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroSecreto = random.nextInt(100) + 1;
        int palpite = 0;

        System.out.println("=== JOGO DE ADIVINHAÇÃO ===");
        System.out.println("Tente adivinhar o número entre 1 e 100.");

        while (palpite != numeroSecreto) {
            System.out.print("Informe seu palpite em numeral inteiro: ");
            palpite = scanner.nextInt();

            if (palpite < numeroSecreto) {
                System.out.println("O número secreto é maior.");
            } else if (palpite > numeroSecreto) {
                System.out.println("O número secreto é menor.");
            } else {
                System.out.println("Parabéns! Você acertou!");
            }
        }

        scanner.close();
    }
}

/*
 ----------------------------------------------------------------------

 Exercício 11: Sequência Numérica Personalizada Enunciado
 Escreva um programa que solicite dois números ao usuário: um valor inicial e um incremento. O programa deve exibir uma sequência numérica a partir do valor inicial, aumentando de acordo com o incremento até ultrapassar 100.

 Observações:
 - Utilize um laço de repetição para gerar a sequência.
 - Exiba os números separados por vírgulas.

 Considerações:
 - Uso correto do laço de repetição.
 - Cálculo correto da sequência.
 - Formatação adequada da saída.
 */
class Exercicio11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o valor inicial em numeral inteiro: ");
        int valorInicial = scanner.nextInt();

        System.out.print("Informe o incremento em numeral inteiro: ");
        int incremento = scanner.nextInt();

        if (incremento <= 0) {
            System.out.println("O incremento deve ser maior que zero.");
            scanner.close();
            return;
        }

        int valorAtual = valorInicial;

        System.out.println("\n=== SEQUÊNCIA ===");

        while (valorAtual <= 100) {
            System.out.print(valorAtual);

            valorAtual += incremento;

            if (valorAtual <= 100) {
                System.out.print(", ");
            }
        }

        System.out.println();

        scanner.close();
    }
}

/*
 ----------------------------------------------------------------------

 Exercício 12: Contagem de Palavras Enunciado
 Crie um programa que solicite ao usuário uma frase e conte quantas palavras a frase contém.

 Observações:
 - Utilize um laço de repetição para percorrer a frase.
 - Utilize o método split() para separar as palavras.

 Considerações:
 - Uso adequado do laço de repetição.
 - Contagem correta das palavras.
 - Exibição correta do total de palavras.
 */
class Exercicio12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Envie uma frase: ");
        String frase = scanner.nextLine().trim();

        if (!frase.matches(".*[a-zA-ZÀ-ÿ]{2,}.*")) {
            System.out.println("A frase não possui palavras.");
        } else {
            String[] palavras = frase.split("\\s+");

            int quantidadePalavras = 0;

            for (String palavra : palavras) {
                quantidadePalavras++;
            }

            System.out.println("Quantidade de palavras: " + quantidadePalavras);
        }

        scanner.close();
    }
}
