using System;

class Program
{
    private static int exercicio = 1; // Colocar aqui, em numeral inteiro, qual dos 12 exercícios executar.

    public static void Main()
    {

        switch (exercicio)
        {
            case 1:
                Exercicio1.Executar();
                break;

            case 2:
                Exercicio2.Executar();
                break;

            case 3:
                Exercicio3.Executar();
                break;
            case 4:
                Exercicio4.Executar();
                break;

            case 5:
                Exercicio5.Executar();
                break;

            case 6:
                Exercicio6.Executar();
                break;
            case 7:
                Exercicio7.Executar();
                break;

            case 8:
                Exercicio8.Executar();
                break;

            case 9:
                Exercicio9.Executar();
                break;
            case 10:
                Exercicio10.Executar();
                break;

            case 11:
                Exercicio11.Executar();
                break;

            case 12:
                Exercicio12.Executar();
                break;
        }
    }
}
/*
 ======================================================================
 Parte 1 Criar um programa que manipule datas
 ======================================================================
 */

/*
 ----------------------------------------------------------------------

 Exercício 1: Cálculo de Idade Precisa

 Crie um programa em C# que solicite a data de nascimento do usuário
 e calcule sua idade exata em anos, meses e dias.

 Observações:
 - Utilize a classe DateTime para capturar e manipular datas.
 - Considere anos bissextos no cálculo.
 - Exiba a idade formatada corretamente.

 Considerações:
 - Uso correto da classe DateTime.
 - Cálculo preciso considerando anos e meses.
 - Formatação adequada da saída.
 */
class Exercicio1
{
    public static void Executar()
    {
        Console.Write("Informe sua data de nascimento (dd/MM/yyyy): ");
        DateTime nascimento = DateTime.Parse(Console.ReadLine());

        DateTime hoje = DateTime.Today;

        if (nascimento > hoje)
        {
            Console.WriteLine("A data de nascimento não pode estar no futuro.");
            return;
        }

        int anos = hoje.Year - nascimento.Year;
        int meses = hoje.Month - nascimento.Month;
        int dias = hoje.Day - nascimento.Day;

        if (dias < 0)
        {
            meses--;

            DateTime mesAnterior = hoje.AddMonths(-1);
            dias += DateTime.DaysInMonth(mesAnterior.Year, mesAnterior.Month); // Não conhecia
        }

        if (meses < 0)
        {
            anos--;
            meses += 12;
        }

        Console.WriteLine("\n=== IDADE ===");
        Console.WriteLine("Data de nascimento: " + nascimento.ToString("dd/MM/yyyy"));
        Console.WriteLine("Data atual: " + hoje.ToString("dd/MM/yyyy"));
        Console.WriteLine($"Idade: {anos} anos, {meses} meses e {dias} dias.");
    }
}

/*
 ----------------------------------------------------------------------

 Exercício 2: Dias até o Próximo Aniversário

 Desenvolva um programa que peça ao usuário sua data de nascimento e
 informe quantos dias faltam para o próximo aniversário.

 Observações:
 - Utilize a classe DateTime para calcular a diferença entre datas.
 - Exiba o resultado em dias.

 Considerações:
 - Uso correto da classe DateTime.
 - Cálculo correto do intervalo de dias.
 - Exibição clara da saída.
 */
class Exercicio2
{
    public static void Executar()
    {
        DateTime hoje = DateTime.Today;

        Console.Write("\nInforme sua data de nascimento (dd/MM/yyyy): ");
        DateTime nascimento = DateTime.Parse(Console.ReadLine());

        if (nascimento > hoje)
        {
            Console.WriteLine("A data de nascimento não pode ser uma data futura.");
            return;
        }

        DateTime proximoAniversario;

        if (nascimento.Month == hoje.Month && nascimento.Day == hoje.Day)
        {
            Console.WriteLine("\nFeliz aniversário!");
            Console.WriteLine("Hoje é o seu aniversário!");
            return;
        }

        proximoAniversario = new DateTime(
            hoje.Year,
            nascimento.Month,
            nascimento.Day
        );

        if (proximoAniversario < hoje)
        {
            proximoAniversario = new DateTime(
                hoje.Year + 1,
                nascimento.Month,
                nascimento.Day
            );
        }

        TimeSpan diferenca = proximoAniversario - hoje;

        Console.WriteLine("\n=== PRÓXIMO ANIVERSÁRIO ===");
        Console.WriteLine(
            "Próximo aniversário: "
            + proximoAniversario.ToString("dd/MM/yyyy")
        );
        Console.WriteLine("Faltam " + diferenca.Days + " dias.");
    }
}

/*
 ----------------------------------------------------------------------

 Exercício 3: Diferença Entre Duas Datas

 Escreva um programa que solicite ao usuário duas datas e calcule a
 diferença em dias, meses e anos entre elas.

 Observações:
 - Utilize a classe DateTime e TimeSpan para o cálculo.
 - Exiba o intervalo formatado corretamente.

 Considerações:
 - Uso adequado das classes DateTime e TimeSpan.
 - Cálculo correto da diferença entre datas.
 - Exibição clara e bem formatada do resultado.
 */
class Exercicio3
{
    public static void Executar()
    {
        Console.Write("Informe a primeira data (dd/MM/yyyy): ");
        DateTime data1 = DateTime.Parse(Console.ReadLine());

        Console.Write("Informe a segunda data (dd/MM/yyyy): ");
        DateTime data2 = DateTime.Parse(Console.ReadLine());

        if (data1 > data2)
        {
            DateTime temp = data1;
            data1 = data2;
            data2 = temp;
        }

        TimeSpan diferenca = data2 - data1;

        int anos = data2.Year - data1.Year;
        int meses = data2.Month - data1.Month;
        int dias = data2.Day - data1.Day;

        if (dias < 0)
        {
            meses--;

            DateTime mesAnterior = data2.AddMonths(-1);
            dias += DateTime.DaysInMonth(
                mesAnterior.Year,
                mesAnterior.Month
            );
        }

        if (meses < 0)
        {
            anos--;
            meses += 12;
        }

        Console.WriteLine("\n=== DIFERENÇA ENTRE DATAS ===");
        Console.WriteLine("Primeira data: " + data1.ToString("dd/MM/yyyy"));
        Console.WriteLine("Segunda data: " + data2.ToString("dd/MM/yyyy"));

        Console.WriteLine("\nDiferença total em dias: " + diferenca.Days);
        Console.WriteLine(
            $"Diferença em anos, meses e dias: {anos} anos, {meses} meses e {dias} dias."
        );
    }
}

/*
 ======================================================================
 Parte 2 Escrever programas que utilizam entrada do usuário
 ======================================================================
 */

/*
 ----------------------------------------------------------------------

 Exercício 4: Formulário de Cadastro Simples

 Crie um programa que solicite nome, idade, telefone e e-mail do usuário
 e exiba os dados cadastrados de forma organizada.

 Observações:
 - Utilize Console.ReadLine() para entrada de dados.
 - Exiba os dados de forma formatada e clara.

 Considerações:
 - Uso correto de Console.ReadLine().
 - Exibição organizada e formatada das informações.
 */
class Exercicio4
{
    public static void Executar()
    {
        Console.Write("Informe seu nome completo: ");
        string nome = Console.ReadLine();

        Console.Write("Informe sua idade: ");
        string idade = Console.ReadLine();

        Console.Write("Informe seu telefone: ");
        string telefone = Console.ReadLine();

        Console.Write("Informe seu e-mail: ");
        string email = Console.ReadLine();

        Console.WriteLine("\n=== DADOS CADASTRADOS ===");
        Console.WriteLine("Nome: " + nome);
        Console.WriteLine("Idade: " + idade);
        Console.WriteLine("Telefone: " + telefone);
        Console.WriteLine("E-mail: " + email);
    }
}

/*
 ----------------------------------------------------------------------

 Exercício 5: Conversor de Temperatura

 Desenvolva um programa que peça ao usuário um valor em graus Celsius
 e o converta para Fahrenheit e Kelvin.

 Observações:
 - Utilize a fórmula: F = C * 9/5 + 32 e K = C + 273.15.
 - Exiba os resultados com duas casas decimais.

 Considerações:
 - Cálculo correto das conversões.
 - Exibição formatada dos valores convertidos.
 */
class Exercicio5
{
    public static void Executar()
    {
        Console.Write("Informe a temperatura em Celsius e numeral: ");
        string input = Console.ReadLine().Replace(",", ".");
        double celsius = double.Parse(input);

        double fahrenheit = celsius * 9 / 5 + 32;
        double kelvin = celsius + 273.15;

        Console.WriteLine("\n=== CONVERSÃO DE TEMPERATURA ===");
        Console.WriteLine($"Celsius: {celsius:F2} °C");
        Console.WriteLine($"Fahrenheit: {fahrenheit:F2} °F");
        Console.WriteLine($"Kelvin: {kelvin:F2} K");
    }
}

/*
 ----------------------------------------------------------------------

 Exercício 6: Cálculo de IMC

 Escreva um programa que solicite peso e altura do usuário e calcule
 seu Índice de Massa Corporal (IMC), classificando-o em faixas de peso.

 Observações:
 - Utilize a fórmula: IMC = peso / (altura * altura).
 - Classifique o usuário conforme as faixas do IMC.

 Considerações:
 - Cálculo correto do IMC.
 - Exibição da classificação correta.
 */
class Exercicio6
{
    public static void Executar()
    {
        Console.Write("Informe seu peso em kg e numeral: ");
        string inputPeso = Console.ReadLine().Replace(",", ".");
        double peso = double.Parse(inputPeso);

        Console.Write("Informe sua altura em metros e numeral: ");
        string inputAltura = Console.ReadLine().Replace(",", ".");
        double altura = double.Parse(inputAltura);

        if (peso <= 0 || altura <= 0)
        {
            Console.WriteLine("O peso e a altura devem ser maiores que zero.");
            return;
        }

        double imc = peso / (altura * altura);

        string classificacao;

        if (imc < 18.5)
        {
            classificacao = "Abaixo do peso";
        }
        else if (imc < 25)
        {
            classificacao = "Peso normal";
        }
        else if (imc < 30)
        {
            classificacao = "Sobrepeso";
        }
        else if (imc < 35)
        {
            classificacao = "Obesidade grau I";
        }
        else if (imc < 40)
        {
            classificacao = "Obesidade grau II";
        }
        else
        {
            classificacao = "Obesidade grau III";
        }

        Console.WriteLine("\n=== RESULTADO DO IMC ===");
        Console.WriteLine($"Peso: {peso:F2} kg");
        Console.WriteLine($"Altura: {altura:F2} m");
        Console.WriteLine($"IMC: {imc:F2}");
        Console.WriteLine("Classificação: " + classificacao);
    }
}

/*
 ======================================================================
 Parte 3 Escrever códigos usando elementos de controle de fluxo
 ======================================================================
 */

/*
 ----------------------------------------------------------------------

 Exercício 7: Verificador de Número Par ou Ímpar

 Crie um programa que solicite um número inteiro e determine se ele é
 par ou ímpar.

 Observações:
 - Utilize estruturas condicionais para verificar a paridade.
 - Exiba uma mensagem indicando o resultado.

 Considerações:
 - Uso correto de estruturas condicionais.
 - Cálculo correto da paridade.
 */
class Exercicio7
{
    public static void Executar()
    {
        Console.Write("Informe em numeral um número inteiro: ");
        int numero = int.Parse(Console.ReadLine());

        if (numero % 2 == 0)
        {
            Console.WriteLine("O número " + numero + " é par.");
        }
        else
        {
            Console.WriteLine("O número " + numero + " é ímpar.");
        }
    }
}

/*
 ----------------------------------------------------------------------

 Exercício 8: Classificação de Nota Escolar

 Desenvolva um programa que peça ao usuário uma nota de 0 a 10 e
 classifique-a como "Insuficiente", "Regular", "Bom" ou "Excelente".

 Observações:
 - Utilize estruturas condicionais para determinar a classificação.

 Considerações:
 - Uso adequado das estruturas condicionais.
 - Classificação correta conforme a nota informada.
 */
class Exercicio8
{
    public static void Executar()
    {
        Console.Write("Informe uma nota de 0 a 10: ");
        string input = Console.ReadLine().Replace(",", ".");
        double nota = double.Parse(input);

        if (nota < 0 || nota > 10)
        {
            Console.WriteLine("A nota deve estar entre 0 e 10.");
            return;
        }

        if (nota < 5)
        {
            Console.WriteLine("Classificação: Insuficiente.");
        }
        else if (nota < 7)
        {
            Console.WriteLine("Classificação: Regular.");
        }
        else if (nota < 9)
        {
            Console.WriteLine("Classificação: Bom.");
        }
        else
        {
            Console.WriteLine("Classificação: Excelente.");
        }
    }
}

/*
 ----------------------------------------------------------------------

 Exercício 9: Calculadora de Salário Líquido

 Escreva um programa que solicite o salário bruto do usuário e calcule
 o valor líquido após descontos de impostos.

 Observações:
 - Utilize faixas de imposto definidas no código.
 - Exiba o salário bruto, os descontos e o salário líquido.

 Considerações:
 - Uso correto de estruturas condicionais.
 - Cálculo correto dos descontos.
 - Exibição formatada das informações.
 */
class Exercicio9
{
    public static void Executar()
    {
        Console.Write("Informe o salário bruto em numeral: R$ ");
        string input = Console.ReadLine().Replace(",", ".");
        double salario = double.Parse(input);

        double imposto;

        /*
         Faixas utilizadas:

         Até R$ 1.000,00       -> 0%
         De R$ 1.000 a 3.000   -> 10%
         De R$ 3.000 a 6.000   -> 15%
         Acima de R$ 6.000     -> 20%
        */

        // Cálculo progressivo.

        if (salario <= 1000)
        {
            imposto = 0;
        }
        else if (salario <= 3000)
        {
            imposto = (salario - 1000) * 0.10;
        }
        else if (salario <= 6000)
        {
            imposto = (1000 * 0.10)
                    + (salario - 3000) * 0.15;
        }
        else
        {
            imposto = (1000 * 0.10)
                    + (1000 * 0.15)
                    + (salario - 6000) * 0.20;
        }

        double salarioLiquido = salario - imposto;

        Console.WriteLine("\n=== RESULTADO ===");
        Console.WriteLine($"Salário bruto: R$ {salario:F2}");
        Console.WriteLine($"Desconto de imposto: R$ {imposto:F2}");
        Console.WriteLine($"Salário líquido: R$ {salarioLiquido:F2}");
    }
}

/*
 ======================================================================
 Parte 4 Escrever códigos usando instruções de repetição
 ======================================================================
 */

/*
 ----------------------------------------------------------------------

 Exercício 10: Contagem Regressiva

 Crie um programa que solicite um número ao usuário e exiba uma
 contagem regressiva até 0.

 Observações:
 - Utilize um laço de repetição para realizar a contagem.
 - Exiba os números separados por vírgula.

 Considerações:
 - Uso correto do laço de repetição.
 - Exibição correta da contagem.
 */
class Exercicio10
{
    public static void Executar()
    {
        Console.Write("Informe um número em numeral inteiro: ");
        int numero = int.Parse(Console.ReadLine());

        Console.WriteLine("\n=== CONTAGEM REGRESSIVA ===");

        for (int i = numero; i >= 0; i--)
        {
            Console.Write(i);

            if (i > 0)
            {
                Console.Write(", ");
            }
        }

        Console.WriteLine();
    }
}

/*
 ----------------------------------------------------------------------

 Exercício 11: Tabuada Interativa

 Desenvolva um programa que solicite um número ao usuário e exiba sua
 tabuada de 1 a 10.

 Observações:
 - Utilize um laço de repetição para calcular a tabuada.

 Considerações:
 - Uso adequado do laço de repetição.
 - Cálculo correto da tabuada.
 */
class Exercicio11
{
    public static void Executar()
    {
        Console.Write("Informe um número em numeral inteiro: ");
        int numero = int.Parse(Console.ReadLine());

        Console.WriteLine("\n=== TABUADA ===");

        for (int i = 1; i <= 10; i++)
        {
            int resultado = numero * i;

            Console.WriteLine(
                $"{numero} x {i} = {resultado}"
            );
        }
    }
}

/*
 ----------------------------------------------------------------------

 Exercício 12: Jogo de Adivinhação

 Escreva um programa que gere um número aleatório de 1 a 100 e permita
 que o usuário tente adivinhá-lo, informando se o palpite é maior ou
 menor até acertar.

 Observações:
 - Utilize um laço de repetição para permitir múltiplos palpites.
 - Utilize a classe Random para gerar o número secreto.

 Considerações:
 - Uso correto do laço de repetição.
 - Implementação correta da lógica de adivinhação.
 - Exibição de mensagens de feedback adequadas.
 */
class Exercicio12
{
    public static void Executar()
    {
        Random random = new Random();

        int numeroSecreto = random.Next(1, 101);
        int palpite = 0;

        Console.WriteLine("=== JOGO DE ADIVINHAÇÃO ===");
        Console.WriteLine("Tente adivinhar o número entre 1 e 100.");

        while (palpite != numeroSecreto)
        {
            Console.Write("Informe seu palpite em numeral inteiro: ");
            palpite = int.Parse(Console.ReadLine());

            if (palpite < numeroSecreto)
            {
                Console.WriteLine("O número secreto é maior.");
            }
            else if (palpite > numeroSecreto)
            {
                Console.WriteLine("O número secreto é menor.");
            }
            else
            {
                Console.WriteLine("Parabéns! Você acertou!");
            }
        }
    }
}
