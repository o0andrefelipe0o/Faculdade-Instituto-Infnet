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

            default:
                Console.WriteLine("Exercício inválido.");
                break;
        }
    }
}
//-------------------------------------------------------------------------------------------------
class Exercicio1
{
    public static void Executar()
    {
        Console.WriteLine("Olá, meu nome é André Felipe de Moraes!");
        Console.WriteLine("Nasci em 25/06/1998 e estou aprendendo C#!");
    }
}
//-------------------------------------------------------------------------------------------------
class Exercicio2
{
    public static void Executar()
    {
        Console.Write("Informe seu nome completo: ");
        string nome = Console.ReadLine();

        char[] caracteres = nome.ToCharArray();

        for (int i = 0; i < caracteres.Length; i++)
        {
            if (caracteres[i] >= 'A' && caracteres[i] <= 'Z')
            {
                caracteres[i] = (char)(caracteres[i] + 2);

                if (caracteres[i] > 'Z')
                {
                    caracteres[i] = (char)(caracteres[i] - 26);
                }
            }
            else if (caracteres[i] >= 'a' && caracteres[i] <= 'z')
            {
                caracteres[i] = (char)(caracteres[i] + 2);

                if (caracteres[i] > 'z')
                {
                    caracteres[i] = (char)(caracteres[i] - 26);
                }
            }
        }

        Console.WriteLine("Nome cifrado: " + new string(caracteres));
    }
}
//-------------------------------------------------------------------------------------------------
class Exercicio3
{
    public static void Executar()
    {
        double numero1;
        double numero2;
        int operacao;

        Console.Write("Informe o primeiro número: ");
        numero1 = double.Parse(Console.ReadLine());

        Console.Write("Informe o segundo número: ");
        numero2 = double.Parse(Console.ReadLine());

        Console.WriteLine();
        Console.WriteLine("1 - Soma");
        Console.WriteLine("2 - Subtração");
        Console.WriteLine("3 - Multiplicação");
        Console.WriteLine("4 - Divisão");
        Console.Write("Informe o número da operação desejada: ");
        operacao = int.Parse(Console.ReadLine());

        switch (operacao)
        {
            case 1:
                Console.WriteLine("Resultado: " + (numero1 + numero2));
                break;

            case 2:
                Console.WriteLine("Resultado: " + (numero1 - numero2));
                break;

            case 3:
                Console.WriteLine("Resultado: " + (numero1 * numero2));
                break;

            case 4:
                if (numero2 == 0)
                {
                    Console.WriteLine("Erro: não é possível dividir por zero.");
                }
                else
                {
                    Console.WriteLine("Resultado: " + (numero1 / numero2));
                }
                break;

            default:
                Console.WriteLine("Operação selecionada inválida.");
                break;
        }
    }
}
//-------------------------------------------------------------------------------------------------
class Exercicio4
{
    public static void Executar()
    {
        Console.Write("Informe sua data de nascimento (dd/MM/yyyy): ");
        DateTime nascimento = DateTime.ParseExact(Console.ReadLine(), "dd/MM/yyyy", null);

        DateTime hoje = DateTime.Today;
        DateTime proximoAniversario;

        bool anoBissexto = (hoje.Year % 4 == 0 && hoje.Year % 100 != 0) || hoje.Year % 400 == 0;

        if (nascimento.Month == 2 && nascimento.Day == 29 && !anoBissexto)
        {
            proximoAniversario = new DateTime(hoje.Year, 2, 28);
        }
        else
        {
            proximoAniversario = new DateTime(hoje.Year, nascimento.Month, nascimento.Day);
        }

        if (proximoAniversario < hoje)
        {
            int ano = hoje.Year + 1;

            bool proximoAnoBissexto = (ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0;

            if (nascimento.Month == 2 && nascimento.Day == 29 && !proximoAnoBissexto)
            {
                proximoAniversario = new DateTime(ano, 2, 28);
            }
            else
            {
                proximoAniversario = new DateTime(ano, nascimento.Month, nascimento.Day);
            }
        }

        TimeSpan diferenca = proximoAniversario - hoje;
        int dias = diferenca.Days;

        Console.WriteLine("Faltam " + dias + " dias para seu próximo aniversário!");

        if (dias < 7)
        {
            Console.WriteLine("Seu aniversário está chegando!");
        }
    }
}
//-------------------------------------------------------------------------------------------------
class Exercicio5
{
    public static void Executar()
    {
        // Data prevista de formatura definir manualmente no código
        DateTime dataFormatura = new DateTime(2029, 12, 31);

        try
        {
            Console.Write("Informe a data atual (dd/MM/yyyy): ");
            DateTime dataAtual = DateTime.ParseExact(Console.ReadLine(), "dd/MM/yyyy", null);

            if (dataAtual > DateTime.Today)
            {
                Console.WriteLine("Erro: A data informada não pode ser no futuro!");
            }
            else if (dataAtual >= dataFormatura)
            {
                Console.WriteLine("Parabéns! Você já deveria estar formado!");
            }
            else
            {
                int anos = 0;
                int meses = 0;

                DateTime dataTemporaria = dataAtual;

                while (dataTemporaria.AddYears(1) <= dataFormatura)
                {
                    dataTemporaria = dataTemporaria.AddYears(1);
                    anos++;
                }

                while (dataTemporaria.AddMonths(1) <= dataFormatura)
                {
                    dataTemporaria = dataTemporaria.AddMonths(1);
                    meses++;
                }

                int dias = (dataFormatura - dataTemporaria).Days;

                Console.WriteLine("Faltam " + anos + " anos, " + meses + " meses e " + dias + " dias para sua formatura!");

                if (dataAtual.AddMonths(6) > dataFormatura)
                {
                    Console.WriteLine("A reta final chegou! Prepare-se para a formatura!");
                }
            }
        }
        catch
        {
            Console.WriteLine("Erro: informe uma data válida no formato dd/MM/yyyy.");
        }
    }
}
//-------------------------------------------------------------------------------------------------
class Exercicio6
{
    public static void Executar()
    {
        Aluno aluno = new Aluno();

        aluno.Nome = "André Felipe de Moraes";
        aluno.Matricula = "20260001";
        aluno.Curso = "Engenharia de Software";
        aluno.MediaNotas = 7.5;

        aluno.ExibirDados();

        Console.WriteLine("Situação: " + aluno.VerificarAprovacao());
    }
}

class Aluno
{
    public string Nome;
    public string Matricula;
    public string Curso;
    public double MediaNotas;

    public void ExibirDados()
    {
        Console.WriteLine("Nome: " + Nome);
        Console.WriteLine("Matrícula: " + Matricula);
        Console.WriteLine("Curso: " + Curso);
        Console.WriteLine("Média das notas: " + MediaNotas);
    }

    public string VerificarAprovacao()
    {
        if (MediaNotas >= 7)
        {
            return "Aprovado";
        }
        else
        {
            return "Reprovado";
        }
    }
}

//-------------------------------------------------------------------------------------------------
class Exercicio7
{
    public static void Executar()
    {
        ContaBancaria conta = new ContaBancaria();

        conta.Titular = "André Felipe de Moraes";

        Console.WriteLine("Titular: " + conta.Titular);

        conta.Depositar(500);
        conta.ExibirSaldo();

        Console.WriteLine("Tentativa de saque: R$ 700,00");

        conta.Sacar(700);
        conta.Sacar(200);
        conta.ExibirSaldo();
    }
}

class ContaBancaria
{
    public string Titular;
    private decimal Saldo;

    public void Depositar(decimal valor)
    {
        if (valor <= 0)
        {
            Console.WriteLine("O valor do depósito deve ser positivo!");
        }
        else
        {
            Saldo += valor;

            Console.WriteLine("Depósito de R$ " + valor.ToString("F2") + " realizado com sucesso!");
        }
    }

    public void Sacar(decimal valor)
    {
        if (valor > Saldo)
        {
            Console.WriteLine("Saldo insuficiente para realizar o saque!");
        }
        else
        {
            Saldo -= valor;

            Console.WriteLine("Saque de R$ " + valor.ToString("F2") + " realizado com sucesso!");
        }
    }

    public void ExibirSaldo()
    {
        Console.WriteLine("Saldo atual: R$ " + Saldo.ToString("F2"));
    }
}
//-------------------------------------------------------------------------------------------------
class Exercicio8
{
    public static void Executar()
    {
        Funcionario funcionario = new Funcionario();

        funcionario.Nome = "Amdré Felipe de Moraes";
        funcionario.Cargo = "Estagiário de TI";
        funcionario.SalarioBase = 1100;

        Gerente gerente = new Gerente();

        gerente.Nome = "Bernardo";
        gerente.Cargo = "Gerente";
        gerente.SalarioBase = 9000;

        Console.WriteLine("=== Estagiário ===");
        Console.WriteLine("Nome: " + funcionario.Nome);
        Console.WriteLine("Cargo: " + funcionario.Cargo);
        Console.WriteLine("Salário: R$ " + funcionario.CalcularSalario().ToString("F2"));

        Console.WriteLine();

        Console.WriteLine("=== Gerente ===");
        Console.WriteLine("Nome: " + gerente.Nome);
        Console.WriteLine("Cargo: " + gerente.Cargo);
        Console.WriteLine("Salário: R$ " + gerente.CalcularSalario().ToString("F2"));
    }
}

class Funcionario
{
    public string Nome;
    public string Cargo;
    public decimal SalarioBase;

    public virtual decimal CalcularSalario()
    {
        return SalarioBase;
    }
}

class Gerente : Funcionario
{
    public override decimal CalcularSalario()
    {
        return SalarioBase * 1.20m;
    }
}
//-------------------------------------------------------------------------------------------------
class Exercicio9
{
    public static void Executar()
    {
        string arquivo = "../../../estoque.txt";

        string[] nomes = new string[5];
        int[] quantidades = new int[5];
        decimal[] precos = new decimal[5];

        int quantidadeProdutos = 0;

        // Cria o arquivo caso ele ainda não exista.
        if (!File.Exists(arquivo))
        {
            File.Create(arquivo).Close();
        }

        // Carrega os produtos existentes para os arrays.
        StreamReader leitor = new StreamReader(arquivo);

        string linha;

        while ((linha = leitor.ReadLine()) != null && quantidadeProdutos < 5)
        {
            if (linha != "")
            {
                string[] dados = linha.Split(';');

                if (dados.Length == 3)
                {
                    nomes[quantidadeProdutos] = dados[0];
                    quantidades[quantidadeProdutos] = int.Parse(dados[1]);
                    precos[quantidadeProdutos] = decimal.Parse(dados[2]);

                    quantidadeProdutos++;
                }
            }
        }

        leitor.Close();

        int opcao = 0;

        while (opcao != 3)
        {
            Console.WriteLine();
            Console.WriteLine("=== Controle de Estoque ===");
            Console.WriteLine("1 - Inserir Produto");
            Console.WriteLine("2 - Listar Produtos");
            Console.WriteLine("3 - Sair");
            Console.Write("Informe o número correpondente à opção desejada: ");

            opcao = int.Parse(Console.ReadLine());

            switch (opcao)
            {
                case 1:

                    if (quantidadeProdutos >= 5)
                    {
                        Console.WriteLine("Limite de produtos atingido!");
                    }
                    else
                    {
                        Console.Write("Informe o nome do produto: ");
                        nomes[quantidadeProdutos] = Console.ReadLine();

                        Console.Write("Informe a quantidade em estoque: ");
                        quantidades[quantidadeProdutos] = int.Parse(Console.ReadLine());

                        Console.Write("Informe o preço unitário: R$ ");
                        precos[quantidadeProdutos] = decimal.Parse(Console.ReadLine());

                        StreamWriter escritor = File.AppendText(arquivo);

                        escritor.WriteLine(nomes[quantidadeProdutos] + ";" + quantidades[quantidadeProdutos] + ";" + precos[quantidadeProdutos].ToString("F2"));

                        escritor.Close();

                        quantidadeProdutos++;

                        Console.WriteLine("Produto cadastrado com sucesso!");
                    }

                    break;

                case 2:

                    leitor = new StreamReader(arquivo);

                    bool encontrou = false;

                    Console.WriteLine();
                    Console.WriteLine("=== Produtos Cadastrados ===");

                    while ((linha = leitor.ReadLine()) != null)
                    {
                        if (linha != "")
                        {
                            string[] dados = linha.Split(';');

                            if (dados.Length == 3)
                            {
                                Console.WriteLine("Produto: " + dados[0] + " | Quantidade: " + dados[1] + " | Preço: R$ " +
                                    decimal.Parse(dados[2]).ToString("F2")
                                );

                                encontrou = true;
                            }
                        }
                    }

                    leitor.Close();

                    if (!encontrou)
                    {
                        Console.WriteLine("Nenhum produto cadastrado.");
                    }

                    break;

                case 3:
                    Console.WriteLine("Encerrando programa...");
                    break;

                default:
                    Console.WriteLine("Opção inválida.");
                    break;
            }
        }
    }
}
//-------------------------------------------------------------------------------------------------
class Exercicio10
{
    public static void Executar()
    {
        Random random = new Random();

        int numeroSecreto = random.Next(1, 51);
        int tentativa;
        bool acertou = false;

        for (int i = 1; i <= 5; i++)
        {
            Console.Write("Informe seu palpite (" + i + "/5): ");
            tentativa = int.Parse(Console.ReadLine());

            if (tentativa < 1 || tentativa > 50)
            {
                Console.WriteLine("Erro: o número deve estar entre 1 e 50.");
                i--;
            }
            else if (tentativa == numeroSecreto)
            {
                Console.WriteLine("Parabéns! Você acertou!");
                acertou = true;
                break;
            }
            else if (tentativa < numeroSecreto)
            {
                Console.WriteLine("O número secreto é maior.");
            }
            else
            {
                Console.WriteLine("O número secreto é menor.");
            }
        }

        if (!acertou)
        {
            Console.WriteLine("Suas tentativas acabaram.");
            Console.WriteLine("O número era " + numeroSecreto + ".");
        }
    }
}
//-------------------------------------------------------------------------------------------------
class Exercicio11
{
    public static void Executar()
    {
        string arquivo = "../../../contatos11.txt";

        if (!File.Exists(arquivo))
        {
            File.Create(arquivo).Close();
        }

        int opcao = 0;

        while (opcao != 3)
        {
            Console.WriteLine();
            Console.WriteLine("=== Gerenciador de Contatos ===");
            Console.WriteLine("1 - Adicionar novo contato");
            Console.WriteLine("2 - Listar contatos cadastrados");
            Console.WriteLine("3 - Sair");
            Console.Write("Informe o número correpondente à opção desejada: ");

            opcao = int.Parse(Console.ReadLine());

            switch (opcao)
            {
                case 1:

                    Console.Write("Informe o nome: ");
                    string nome = Console.ReadLine();

                    Console.Write("Informe o telefone: ");
                    string telefone = Console.ReadLine();

                    Console.Write("Informe o email: ");
                    string email = Console.ReadLine();

                    try
                    {
                        StreamWriter escritor = File.AppendText(arquivo);
                        escritor.WriteLine(nome + ";" + telefone + ";" + email);
                        escritor.Close();

                        Console.WriteLine("Contato cadastrado com sucesso!");
                    }
                    catch
                    {
                        Console.WriteLine("Erro ao salvar o contato.");
                    }

                    break;

                case 2:

                    try
                    {
                        StreamReader leitor = new StreamReader(arquivo);
                        string linha;
                        bool encontrou = false;

                        Console.WriteLine();
                        Console.WriteLine("Contatos cadastrados:");

                        while ((linha = leitor.ReadLine()) != null)
                        {
                            if (linha != "")
                            {
                                string[] dados = linha.Split(';');

                                if (dados.Length == 3)
                                {
                                    Console.WriteLine("Nome: " + dados[0] + " | Telefone: " + dados[1] + " | Email: " + dados[2]);
                                    encontrou = true;
                                }
                            }
                        }

                        leitor.Close();

                        if (!encontrou)
                        {
                            Console.WriteLine("Nenhum contato cadastrado.");
                        }
                    }
                    catch
                    {
                        Console.WriteLine("Erro ao ler o arquivo.");
                    }

                    break;

                case 3:
                    Console.WriteLine("Encerrando programa...");
                    break;

                default:
                    Console.WriteLine("Opção inválida.");
                    break;
            }
        }
    }
}
//-------------------------------------------------------------------------------------------------
class Exercicio12
{
    public static void Executar()
    {
        string arquivo = "../../../contatos12.txt";

        if (!File.Exists(arquivo))
        {
            File.Create(arquivo).Close();
        }

        int opcao = 0;

        while (opcao != 3)
        {
            Console.WriteLine();
            Console.WriteLine("=== Gerenciador de Contatos ===");
            Console.WriteLine("1 - Adicionar novo contato");
            Console.WriteLine("2 - Exibir contatos");
            Console.WriteLine("3 - Sair");
            Console.Write("Informe o número correpondente à opção desejada: ");

            opcao = int.Parse(Console.ReadLine());

            switch (opcao)
            {
                case 1:

                    Console.Write("Informe o nome: ");
                    string nome = Console.ReadLine();

                    Console.Write("Informe o telefone: ");
                    string telefone = Console.ReadLine();

                    Console.Write("Informe o email: ");
                    string email = Console.ReadLine();

                    StreamWriter escritor = File.AppendText(arquivo);
                    escritor.WriteLine(nome + ";" + telefone + ";" + email);
                    escritor.Close();

                    Console.WriteLine("Contato cadastrado com sucesso!");

                    break;

                case 2:

                    List<Contato> contatos = new List<Contato>();

                    StreamReader leitor = new StreamReader(arquivo);
                    string linha;

                    while ((linha = leitor.ReadLine()) != null)
                    {
                        if (linha != "")
                        {
                            string[] dados = linha.Split(';');

                            if (dados.Length == 3)
                            {
                                Contato contato = new Contato(dados[0], dados[1], dados[2]);
                                contatos.Add(contato);
                            }
                        }
                    }

                    leitor.Close();

                    if (contatos.Count == 0)
                    {
                        Console.WriteLine("Nenhum contato cadastrado.");
                        break;
                    }

                    Console.WriteLine();
                    Console.WriteLine("=== Formato de Exibição ===");
                    Console.WriteLine("1 - Markdown");
                    Console.WriteLine("2 - Tabela");
                    Console.WriteLine("3 - Texto Puro");
                    Console.Write("Informe o formato desejado: ");

                    int formato = int.Parse(Console.ReadLine());

                    IContatoFormatter formatter;

                    switch (formato)
                    {
                        case 1:
                            formatter = new MarkdownFormatter();
                            break;

                        case 2:
                            formatter = new TabelaFormatter();
                            break;

                        case 3:
                            formatter = new RawTextFormatter();
                            break;

                        default:
                            Console.WriteLine("Formato inválido.");
                            return;
                    }

                    formatter.ExibirContatos(contatos);

                    break;

                case 3:

                    Console.WriteLine("Encerrando programa...");

                    break;

                default:

                    Console.WriteLine("Opção inválida.");

                    break;
            }
        }
    }
}

class Contato
{
    public string Nome;
    public string Telefone;
    public string Email;

    public Contato(string nome, string telefone, string email)
    {
        Nome = nome;
        Telefone = telefone;
        Email = email;
    }
}

interface IContatoFormatter
{
    void ExibirContatos(List<Contato> contatos);
}

class ContatoFormatter : IContatoFormatter
{
    public virtual void ExibirContatos(List<Contato> contatos)
    {
        for (int i = 0; i < contatos.Count; i++)
        {
            Console.WriteLine("Nome: " + contatos[i].Nome + " | Telefone: " + contatos[i].Telefone + " | Email: " + contatos[i].Email);
        }
    }
}

class MarkdownFormatter : ContatoFormatter
{
    public override void ExibirContatos(List<Contato> contatos)
    {
        Console.WriteLine("## Lista de Contatos");

        for (int i = 0; i < contatos.Count; i++)
        {
            Console.WriteLine("- **Nome:** " + contatos[i].Nome);
            Console.WriteLine("- Telefone: " + contatos[i].Telefone);
            Console.WriteLine("- Email: " + contatos[i].Email);
        }
    }
}

class TabelaFormatter : ContatoFormatter
{
    public override void ExibirContatos(List<Contato> contatos)
    {
        Console.WriteLine("----------------------------------------");
        Console.WriteLine("| Nome | Telefone | Email |");
        Console.WriteLine("----------------------------------------");

        for (int i = 0; i < contatos.Count; i++)
        {
            Console.WriteLine("| " + contatos[i].Nome + " | " + contatos[i].Telefone + " | " + contatos[i].Email + " |");
        }

        Console.WriteLine("----------------------------------------");
    }
}

class RawTextFormatter : ContatoFormatter
{
    public override void ExibirContatos(List<Contato> contatos)
    {
        for (int i = 0; i < contatos.Count; i++)
        {
            Console.WriteLine("Nome: " + contatos[i].Nome + " | Telefone: " + contatos[i].Telefone + " | Email: " + contatos[i].Email);
        }
    }
}
