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
            case 11:
                Exercicio11.Executar();
                break;
        }
    }
}
/*
1. Implementação de Delegate Personalizado para Descontos
Imagine que você está desenvolvendo um módulo de regras de negócio para uma aplicação de vendas online. Esse sistema deve aplicar diferentes políticas de desconto conforme o perfil do cliente. Para isso, é necessário encapsular as regras de cálculo de desconto em uma estrutura reutilizável.
Tarefas:
Crie uma aplicação de console em C#.
Solicite ao usuário que informe o preço original de um produto.
Crie um delegate chamado CalculateDiscount que receba esse valor como decimal e retorne o preço com 10% de desconto aplicado.
Implemente um método compatível com esse delegate.
Utilize o delegate no fluxo da aplicação para calcular e exibir o valor final ao usuário.
Este exercício introduz o uso de delegates personalizados para encapsular lógicas de negócio com alta reutilização e manutenção.
*/
class Exercicio1
{
    // 2) Crie um delegate chamado CalculateDiscount que receba esse valor como decimal e retorne o preço com 10% de desconto aplicado.
    public delegate decimal CalculateDiscount(decimal preco);

    // 3) Implemente um método compatível com esse delegate.
    public static decimal AplicarDezPorCento(decimal preco)
    {
        return preco - (preco * 0.10m); // Retorna o valor final diretamente com 10% de desconto
    }
    public static void Executar()
    {
        // 1) Solicite ao usuário que informe o preço original de um produto.
        decimal precoOriginal;
        bool entradaValida;
        do
        {
            Console.Write("Informe o preço original do produto: R$ ");
            string entrada = Console.ReadLine();
            // Valida se é um número decimal válido E se é maior que zero
            entradaValida = decimal.TryParse(entrada, out precoOriginal) && precoOriginal > 0;
            if (!entradaValida)
            {
                Console.Clear();
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine("Valor inválido! Por favor, informe um preço numérico positivo.");
                Console.ResetColor();
            }
        } while (!entradaValida);
        Console.ForegroundColor = ConsoleColor.Green;
        Console.WriteLine($"Preço original registrado: {precoOriginal:C2}");
        Console.ResetColor();

        // 4) Utilize o delegate no fluxo da aplicação para calcular e exibir o valor final ao usuário.
        CalculateDiscount aplicarDesconto = AplicarDezPorCento;
        decimal precoComDesconto = aplicarDesconto(precoOriginal);
        Console.ForegroundColor = ConsoleColor.Cyan;
        Console.WriteLine($"Preço com 10% de desconto: {precoComDesconto:C2}");
        Console.ResetColor();
    }
}
/*
2. Ações Multilíngues com Action<string>
Uma aplicação SaaS voltada ao público internacional precisa exibir mensagens de boas-vindas em diferentes idiomas, conforme a configuração do cliente.
Tarefas:
Crie um programa de console em C#.
Solicite ao usuário que escolha um idioma (português, inglês ou espanhol).
Crie uma estrutura com Action<string> para exibir a mensagem de boas-vindas no idioma escolhido.
Implemente ao menos três versões de mensagens encapsuladas nos delegates.
Este exercício mostra como delegates com Action são úteis em interações que envolvem ações sem retorno, como feedback ao usuário.
*/
class Exercicio2
{
    public static void Executar()
    {
        //Console.Write("Qual seu nome? / What is your name? / ¿Cuál es tu nombre?: ");
        //string nomeUsuario = Console.ReadLine();
        bool back;
        do
        {
            back = false;

            // 1) Solicite ao usuário que escolha um idioma (português, inglês ou espanhol).
            Console.WriteLine("Escolha um idioma / Choose a language / Elija un idioma:");
            Console.WriteLine("1 - Português");
            Console.WriteLine("2 - English");
            Console.WriteLine("3 - Español");
            Console.Write("Qual opção? / Which option? / ¿Qué opción?: ");
            string opcao = Console.ReadLine();

            // 2) Crie uma estrutura com Action<string> para exibir a mensagem de boas-vindas no idioma escolhido.
            Action<string> exibirBoasVindas = null;

            // 3) Implemente ao menos três versões de mensagens encapsuladas nos delegates.
            exibirBoasVindas = (selecao) =>
            {
                Console.ForegroundColor = ConsoleColor.Green;
                switch (selecao)
                {
                    case "1":
                        Console.WriteLine($"Olá! Seja muito bem-vindo ao nosso sistema!");
                        break;
                    case "2":
                        Console.WriteLine($"Hello! Welcome to our system!");
                        break;
                    case "3":
                        Console.WriteLine($"¡Hola! ¡Bienvenido a nuestro sistema!");
                        break;
                    default:
                        Console.Clear();
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.WriteLine("Opção desconhecida / Unknown option / Opción desconocida");
                        back = true;
                        break;
                }
                Console.ResetColor();
            };
            exibirBoasVindas(opcao);
        } while (back);
    }
}
/*
3. Cálculo de Área Utilizando Func
Um sistema de engenharia precisa realizar cálculos de área com base em entradas fornecidas pelo operador.
Tarefas:
Crie um programa de console em C#.
Solicite ao usuário que insira a base e a altura de um retângulo.
Crie um Func<double, double, double> para calcular a área.
Utilize o delegate para exibir o resultado ao final do processo.
Esse exercício demonstra o uso prático do Func como abstração de cálculos com retorno.
*/
class Exercicio3
{
    public static void Executar()
    {
        // 1) Solicite ao usuário que insira a base e a altura de um retângulo.
        double baseRetangulo = 0;
        double alturaRetangulo = 0;
        bool entradaValida;
        do
        {
            Console.Write("Informe o valor da BASE do retângulo em numeral: ");
            string entradaBase = Console.ReadLine();
            Console.Write("Informe o valor da ALTURA do retângulo em numeral: ");
            string entradaAltura = Console.ReadLine();
            // Valida se ambos são números válidos e maiores que zero
            entradaValida = double.TryParse(entradaBase, out baseRetangulo) && baseRetangulo > 0 &&
                            double.TryParse(entradaAltura, out alturaRetangulo) && alturaRetangulo > 0;
            if (!entradaValida)
            {
                Console.Clear();
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine("Valores inválidos! Certifique-se de iformar numerais positivos.");
                Console.ResetColor();
            }
        } while (!entradaValida);

        // 2) Crie um Func<double, double, double> para calcular a área.
        Func<double, double, double> calcularArea = (b, h) => b * h;

        // 3) Utilize o delegate para exibir o resultado ao final do processo.
        double areaFinal = calcularArea(baseRetangulo, alturaRetangulo);
        Console.ForegroundColor = ConsoleColor.Green;
        Console.WriteLine($"Base: {baseRetangulo} | Altura: {alturaRetangulo}\nÁrea: {areaFinal} m²");
        Console.ResetColor();
    }
}
/*
4. Monitoramento de Temperatura com Evento Personalizado
Sistemas embarcados em ambientes industriais monitoram sensores em tempo real. Uma funcionalidade comum é emitir alertas quando a temperatura ultrapassa o limite seguro.
Tarefas:
Crie uma classe TemperatureSensor com um evento TemperatureExceeded.
Solicite entradas do usuário para simular leituras de temperatura.
Dispare o evento sempre que o valor ultrapassar 100 ºC.
Crie um manipulador que mostre um alerta no console.
Com este exercício, você aprende a usar eventos para tornar aplicações mais reativas e seguras.
*/
class Exercicio4
{
    // Dados enviados junto com o evento
    public class TemperatureEventArgs : EventArgs
    {
        public double Temperatura { get; }
        public double Limite { get; }

        public TemperatureEventArgs(double temperatura, double limite)
        {
            Temperatura = temperatura;
            Limite = limite;
        }
    }

    // 1) Crie uma classe TemperatureSensor com um evento TemperatureExceeded.
    public class TemperatureSensor
    {
        public const double LimiteSeguro = 100.0;
        public event EventHandler<TemperatureEventArgs> TemperatureExceeded;
        public void RegistrarLeitura(double temperatura)
        {
            // 3) Dispare o evento sempre que o valor ultrapassar 100 ºC.
            if (temperatura > LimiteSeguro)
            {
                OnTemperatureExceeded(new TemperatureEventArgs(temperatura, LimiteSeguro));
            }
        }
        protected virtual void OnTemperatureExceeded(TemperatureEventArgs e)
        {
            TemperatureExceeded?.Invoke(this, e);
        }
    }

    // 4) Crie um manipulador que mostre um alerta no console.
    private static void ExibirAlerta(object sender, TemperatureEventArgs e)
    {
        Console.ForegroundColor = ConsoleColor.Red;
        Console.WriteLine($"ALERTA! Temperatura de {e.Temperatura:F1} ºC ultrapassou o limite seguro de {e.Limite:F1} ºC!");
        Console.ResetColor();
    }

    public static void Executar()
    {
        TemperatureSensor sensor = new TemperatureSensor();
        sensor.TemperatureExceeded += ExibirAlerta;
        Console.WriteLine("Simulador de sensor de temperatura (envie 'sair' para encerrar).");
        while (true)
        {
            // 2) Solicite entradas do usuário para simular leituras de temperatura.
            Console.Write("Informe a leitura de temperatura em ºC: ");
            string entrada = Console.ReadLine();
            if (entrada == null || entrada.Trim().ToLower() == "sair")
                break;
            double temperatura;
            if (!double.TryParse(entrada, out temperatura) || double.IsNaN(temperatura) || double.IsInfinity(temperatura))
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine("Valor inválido! Informe um numeral.");
                Console.ResetColor();
                continue;
            }

            sensor.RegistrarLeitura(temperatura);
            if (temperatura <= TemperatureSensor.LimiteSeguro)
            {
                Console.ForegroundColor = ConsoleColor.Green;
                Console.WriteLine("Temperatura normal.");
                Console.ResetColor();
            }
        }
        Console.WriteLine("Monitoramento encerrado.");
    }
}
/*
5. Notificação de Conclusão de Download com Eventos
Ao lidar com tarefas assíncronas, como downloads, sistemas devem informar o usuário sobre a finalização do processo.
Tarefas:
Crie uma classe DownloadManager.
Simule o tempo de download usando Thread.Sleep.
Crie um evento DownloadCompleted.
Dispare o evento ao final do processo e exiba uma mensagem no console.
Este exercício ensina como eventos são utilizados para notificar o sistema sobre o fim de uma operação.
*/
class Exercicio5
{
    public class DownloadCompletedEventArgs : EventArgs
    {
        public string Arquivo { get; }
        public DownloadCompletedEventArgs(string arquivo)
        {
            Arquivo = arquivo;
        }
    }

    // 1) Crie uma classe DownloadManager.
    public class DownloadManager
    {
        // 3) Crie um evento DownloadCompleted.
        public event EventHandler<DownloadCompletedEventArgs> DownloadCompleted;
        public void IniciarDownload(string arquivo)
        {
            Console.WriteLine($"Iniciando download de '{arquivo}'...");

            // 2) Simule o tempo de download usando Thread.Sleep.
            for (int progresso = 20; progresso <= 100; progresso += 20)
            {
                System.Threading.Thread.Sleep(600);
                Console.WriteLine($"Baixando... {progresso,3}%");
            }

            // 4) Dispare o evento ao final do processo.
            OnDownloadCompleted(new DownloadCompletedEventArgs(arquivo));
        }
        protected virtual void OnDownloadCompleted(DownloadCompletedEventArgs e)
        {
            DownloadCompleted?.Invoke(this, e);
        }
    }
    // Manipulador: exibe a mensagem no console
    private static void ExibirConclusao(object sender, DownloadCompletedEventArgs e)
    {
        Console.ForegroundColor = ConsoleColor.Green;
        Console.WriteLine($"Download concluído com sucesso: '{e.Arquivo}' ({DateTime.Now:HH:mm:ss})");
        Console.ResetColor();
    }
    public static void Executar()
    {
        DownloadManager gerenciador = new DownloadManager();
        gerenciador.DownloadCompleted += ExibirConclusao;
        Console.Write("Nome do arquivo para baixar (ENTER para 'relatorio_vendas.zip'): ");
        string arquivo = Console.ReadLine();
        if (string.IsNullOrWhiteSpace(arquivo))
            arquivo = "relatorio_vendas.zip";
        gerenciador.IniciarDownload(arquivo.Trim());
        Console.WriteLine("Fluxo principal retomado após o download.");
    }
}
/*
6. Sistema de Registro com Multicast Delegate
Uma aplicação corporativa precisa registrar logs simultaneamente em vários destinos: console, arquivo e banco (simulado).
Tarefas:
Crie uma classe Logger com três métodos: LogToConsole, LogToFile, LogToDatabase.
Crie um Action<string> multicast delegate.
Adicione os três métodos ao delegate.
Ao chamar o delegate com uma mensagem, todas as saídas devem ser executadas.
Esse exercício reforça como delegates podem ser encadeados para criar comportamentos complexos com baixo acoplamento.
*/
class Exercicio6
{
    // 1) Crie uma classe Logger com três métodos: LogToConsole, LogToFile, LogToDatabase.
    public class Logger
    {
        private readonly string caminhoArquivo = "log.txt";
        public void LogToConsole(string mensagem)
        {
            Console.ForegroundColor = ConsoleColor.Cyan;
            Console.WriteLine($"[CONSOLE] {DateTime.Now:HH:mm:ss} - {mensagem}");
            Console.ResetColor();
        }
        public void LogToFile(string mensagem)
        {
            try
            {
                System.IO.File.AppendAllText(caminhoArquivo, $"{DateTime.Now:dd/MM/yyyy HH:mm:ss} - {mensagem}{Environment.NewLine}");
                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.WriteLine($"[ARQUIVO] Mensagem gravada em: {System.IO.Path.GetFullPath(caminhoArquivo)}");
            }
            catch (Exception ex)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine($"[ARQUIVO] Falha ao gravar o log: {ex.Message}");
            }
            Console.ResetColor();
        }
        public void LogToDatabase(string mensagem)
        {
            Console.ForegroundColor = ConsoleColor.Magenta;
            Console.WriteLine($"[BANCO] INSERT INTO Logs (DataHora, Mensagem) VALUES ('{DateTime.Now:yyyy-MM-dd HH:mm:ss}', '{mensagem}')");
            Console.ResetColor();
        }
    }
    public static void Executar()
    {
        Logger logger = new Logger();

        // 2) Crie um Action<string> multicast delegate.
        Action<string> registrarLog = logger.LogToConsole;

        // 3) Adicione os três métodos ao delegate.
        registrarLog += logger.LogToFile;
        registrarLog += logger.LogToDatabase;

        Console.Write("Digite a mensagem de log: ");
        string mensagem = Console.ReadLine();
        if (string.IsNullOrWhiteSpace(mensagem))
            mensagem = "Aplicação iniciada com sucesso.";

        // 4) Ao chamar o delegate com uma mensagem, todas as saídas devem ser executadas.
        registrarLog(mensagem);
    }
}
/*
7. Garantia de Robustez em Invocação de Delegates
Ao usar delegates em tempo de execução, é fundamental garantir que invocações não gerem erros caso não haja métodos associados.
Tarefas:
Reutilize o código do exercício anterior (Logger).
Substitua todas as invocações diretas por chamadas usando ?.Invoke().
Teste o sistema sem nenhum método associado ao delegate e verifique que não ocorrem exceções.
Esse exercício promove boas práticas para escrita de código mais robusto.
*/
class Exercicio7
{
    public static void Executar()
    {
        // 1) Reutilize o código do exercício anterior (Logger).
        Exercicio6.Logger logger = new Exercicio6.Logger();

        Action<string> registrarLog = null;


        // 2) Substitua todas as invocações diretas por chamadas usando ?.Invoke().
        // 3) Teste o sistema sem nenhum método associado ao delegate e verifique que não ocorrem exceções.
        Console.WriteLine("--- Delegate sem métodos associados ---");
        registrarLog?.Invoke("Esta mensagem não vai a lugar nenhum.");
        Console.WriteLine($"Delegate é nulo? {registrarLog == null}.\n");

        Console.WriteLine("--- Delegate com os três métodos associados ---");
        registrarLog += logger.LogToConsole;
        registrarLog += logger.LogToFile;
        registrarLog += logger.LogToDatabase;
        registrarLog?.Invoke("Mensagem enviada para os três destinos.");
        Console.WriteLine($"Delegate é nulo? {registrarLog == null}.\n");

        Console.WriteLine("--- Removendo arquivo e banco ---");
        registrarLog -= logger.LogToFile;
        registrarLog -= logger.LogToDatabase;
        registrarLog?.Invoke("Agora só o console recebe a mensagem.");
        Console.WriteLine($"Delegate é nulo? {registrarLog == null}.\n");

        Console.WriteLine("--- Removendo console, ficando sem métodos associados novamente ---");
        registrarLog -= logger.LogToConsole;
        registrarLog?.Invoke("Delegate vazio de novo: nada acontece.");
        Console.WriteLine($"Delegate é nulo? {registrarLog == null}.\n");
    }
}
/*
11. Manipulação de Strings com Delegates Encadeados
Transformações encadeadas são comuns em pipelines de processamento.
Tarefas:
Crie um Func<string, string, string> que concatene nome e sobrenome.
Encadeie mais dois métodos no delegate:
Um que converta a string para maiúsculas.
Outro que remova espaços em branco.
Observe e analise o comportamento do resultado.
Esse exercício ajuda a compreender o comportamento de retorno em delegates multicast.
*/
class Exercicio11
{
    private static int execucoes = 0;
    private static string Concatenar(string nome, string sobrenome)
    {
        execucoes++;
        return nome + " " + sobrenome;
    }

    // 2) Encadeie mais dois métodos no delegate:
    // 2.1) Um que converta a string para maiúsculas.
    private static string ConverterParaMaiusculas(string nome, string sobrenome)
    {
        execucoes++;
        return (nome + " " + sobrenome).ToUpper();
    }
    // 2.2) Outro que remova espaços em branco.
    private static string RemoverEspacos(string nome, string sobrenome)
    {
        execucoes++;
        return (nome + " " + sobrenome).Replace(" ", "");
    }

    public static void Executar()
    {
        Console.Write("Informe o PRIMEIRO NOME: ");
        string nome = Console.ReadLine();
        Console.Write("Informe o SOBRENOME: ");
        string sobrenome = Console.ReadLine();

        // 1) Crie um Func<string, string, string> que concatene nome e sobrenome.
        Func<string, string, string> processar = Concatenar;
        processar += ConverterParaMaiusculas;
        processar += RemoverEspacos;

        // 3) Observe e analise o comportamento do resultado.
        execucoes = 0;
        string resultado = processar(nome, sobrenome);
        Console.ForegroundColor = ConsoleColor.Red;
        Console.WriteLine($"Valor na ordem em que foram adicionados: \"{resultado}\"");
        Console.WriteLine($"Quantidade de métodos executados nessa chamada: {execucoes}");
        Console.ResetColor();

        Console.ForegroundColor = ConsoleColor.Yellow;
        Console.WriteLine("- Os 3 métodos são executados, na ordem em que foram adicionados.");
        Console.WriteLine("- Cada método recebe os argumentos originais, ou seja o resultado de um NÃO alimenta o próximo.");
        Console.WriteLine("- Por isso o resultado final não está em maiúsculas, embora ConverterParaMaiusculas() tenha rodado.");
        Console.ResetColor();
    }
}