using System;
using static System.Net.Mime.MediaTypeNames;

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
Competência: Escrever programas em C# que utilizem classes e objetos

Exercício 1 Conceitos de Classe, Objeto, Campos e Métodos (C#)

Enunciado: Explique, de forma clara e objetiva, os conceitos de classe, objeto, campos (ou atributos) e métodos no contexto da Programação Orientada a Objetos em C#. Em seguida, crie um exemplo simples (pode ser em pseudocódigo ou C#) que ilustre esses conceitos na prática. Seu exemplo deve conter:
- Declaração de uma classe.
- Pelo menos dois campos (ou atributos) diferentes.
- Pelo menos um método que utilize ou manipule esses campos.
- Criação de um objeto a partir da classe declarada.

Observações:
- Use exemplos do dia a dia (por exemplo, "Carro", "Pessoa", "Livro") para tornar a explicação mais acessível.
- Relacione cada conceito do enunciado (classe, objeto, atributos, métodos) com trechos do seu exemplo prático.
- Seja objetivo, mas inclua detalhes suficientes para demonstrar compreensão do tema.

Considerações:
- Clareza e correção conceitual na explicação dos termos (classe, objeto, campos, métodos).
- Qualidade do exemplo prático e conexão com a teoria.
- Organização do texto e, se optar por C#, uso adequado da linguagem (nomes de classe iniciando em maiúscula, etc.).
*/
class Exercicio1
{
    public static void Executar()
    {
        /*
        Uma classe é como um molde ou uma planta e o objeto é o que foi construido com esse molde. Exemplo:
        Classe = planta de uma casa
        Objeto = casa construída
        Ela determina quais informações uma coisa vai ter e quais ações ela pode realizar.

        Na classe:
        Os atributos são as informações do objeto.
        Os métodos são as ações que o objeto pode fazer.

        O objeto é algo criado a partir da classe.
        */

        // Criando o objeto livro a partir da classe Impresso
        Impresso livro = new Impresso();

        // Colocando informações no objeto
        livro.titulo = "O fim da infância";
        livro.autor = "Arthur C. Clarke";
        livro.genero = "Ficção científica, Romance, Literatura apocalíptica";
        livro.lido = false;

        // Mostrando as informações ANTES da leitura
        Console.WriteLine("Livro: " + livro.titulo);
        Console.WriteLine("Autor: " + livro.autor);
        Console.WriteLine("Status antes: " + (livro.lido ? "Já lido" : "Não lido"));

        // Chamando o método para marcar como lido
        livro.MarcarComoLido();

        // Mostrando as informações DEPOIS de ler
        Console.WriteLine("\nApós chamar o método MarcarComoLido():");
        Console.WriteLine("Status depois: " + (livro.lido ? "Já lido" : "Não lido"));
    }

    // Criação da classe Impresso
    class Impresso
    {
        // Atributos (Informações)
        public string titulo;
        public string autor;
        public string genero;
        public bool lido;

        // Método (Ação) da classe
        public void MarcarComoLido()
        {
            lido = true; // Altera o status do atributo para verdadeiro, marcando como "Já lido"
        }
    }
}

/*
Contexto para as próximas questões (Exercícios 2 a 6): Venda de Show
Imagine que você é responsável pela venda de ingressos para um grande evento musical. É preciso cadastrar ingressos com nome do show, preço e quantidade disponível, bem como atualizar essas informações sempre que algo mudar. Ao final, você deve exibir as informações do ingresso para ter um registro atualizado do sistema.

Exercício 2 Criando a Classe "Ingresso"

Enunciado: Com base na história de usuário acima, crie uma classe que represente um Ingresso para o show. Sua tarefa é:
1. Declarar a classe e atributos
- Crie uma classe chamada Ingresso.
- Insira nela, pelo menos, os atributos: nomeDoShow (string), preco (double) e quantidadeDisponivel (int).
- Explique brevemente por que cada atributo é importante no contexto de venda de shows.

Considerações:
- Declaração correta dos atributos e criação da classe Ingresso.
- Clareza na explicação da importância de cada atributo.
- Organização adequada do código (sem se preocupar ainda com métodos mais avançados).
*/

class Exercicio2
{
    public static void Executar()
    {
        /*
        Cada ingresso precisa guardar três informações:
        NomeDoShow = qual show será realizado
        Preco = quanto custa o ingresso
        QuantidadeDisponivel = quantos ingressos ainda existem

        Essas informações serão os atributos da classe Ingresso.
        */

        // Criando um ingresso para mostrar que a classe funciona.
        Ingresso ingresso = new Ingresso();

        ingresso.NomeDoShow = "Rock Festival";
        ingresso.Preco = 150.00;
        ingresso.QuantidadeDisponivel = 500;

        Console.WriteLine("Nome do show: " + ingresso.NomeDoShow);
        Console.WriteLine("Preço: R$ " + ingresso.Preco);
        Console.WriteLine("Ingressos disponíveis: " + ingresso.QuantidadeDisponivel);
    }

    class Ingresso
    {
        // Nome do show.
        public string NomeDoShow;

        // Preço do ingresso.
        public double Preco;

        // Quantidade de ingressos disponíveis.
        public int QuantidadeDisponivel;
    }
}

/*
Exercício 3 Métodos Básicos da Classe "Ingresso"

Enunciado: Dando continuidade ao contexto da venda de ingressos para um show, agora vamos aprimorar a classe Ingresso com métodos básicos:
1. Atualizar Preço
- Crie um método chamado AlterarPreco(double novoPreco) que recebe um novo preço e atualiza o atributo preco.
2. Atualizar Quantidade
- Crie um método chamado AlterarQuantidade(int novaQuantidade) que recebe uma nova quantidade e atualiza o atributo quantidadeDisponivel.
3. Exibir Informações
- Crie um método chamado ExibirInformacoes(), que mostre (no console ou como retorno de string) o nomeDoShow, o preco atual e a quantidadeDisponivel do ingresso.

Considerações:
- Correta implementação dos métodos solicitados.
- Clareza e objetividade no código, demonstrando como cada método cumpre seu papel.
- Uso adequado dos atributos já criados na classe Ingresso.
*/

class Exercicio3
{
    public static void Executar()
    {
        /*
        Acrescentando alguns métodos para que a classe consiga realizar algumas ações:
		AlterarPreco() = muda o preço.
		AlterarQuantidade() = muda a quantidade disponível.
		ExibirInformacoes() = mostra as informações atuais.
		*/

        Ingresso ingresso = new Ingresso();

        // Informações iniciais.
        ingresso.NomeDoShow = "Rock Festival";
        ingresso.Preco = 150.00;
        ingresso.QuantidadeDisponivel = 500;

        Console.WriteLine("Informações iniciais:");
        ingresso.ExibirInformacoes();

        // Alterando o preço.
        ingresso.AlterarPreco(180.00);

        // Alterando a quantidade disponível.
        ingresso.AlterarQuantidade(450);

        // Mostrando os dados atualizados.
        Console.WriteLine("\nInformações atualizadas após o uso dos métodos:");
        ingresso.ExibirInformacoes();
    }

    class Ingresso
    {
        public string NomeDoShow;
        public double Preco;
        public int QuantidadeDisponivel;

        // Altera o preço do ingresso.
        public void AlterarPreco(double novoPreco)
        {
            Preco = novoPreco;
        }

        // Altera a quantidade disponível.
        public void AlterarQuantidade(int novaQuantidade)
        {
            QuantidadeDisponivel = novaQuantidade;
        }

        // Mostra as informações do ingresso.
        public void ExibirInformacoes()
        {
            Console.WriteLine("Nome do show: " + NomeDoShow);
            Console.WriteLine("Preço: R$ " + Preco);
            Console.WriteLine("Ingressos disponíveis: " + QuantidadeDisponivel);
        }
    }
}


/*
Exercício 4 Testando a Classe "Ingresso"

Enunciado: Agora é hora de testar a classe Ingresso. Para isso:
1. Criar Classe de Teste
- Crie uma nova classe (por exemplo, AppIngresso ou Program) com um método Main.
2. Instanciar um Ingresso
- Dentro de Main, crie um objeto da classe Ingresso.
- Atribua valores iniciais aos atributos (nomeDoShow, preco, quantidadeDisponivel).
3. Chamar os Métodos de Atualização
- Chame AlterarPreco e AlterarQuantidade para modificar o preço e a quantidade disponíveis.
- Exibir Informações.
- Por fim, chame ExibirInformacoes() para confirmar se as alterações foram aplicadas corretamente.

Considerações:
- Criação correta de uma classe ou método Main para executar o código.
- Instanciação da classe Ingresso com valores iniciais nos atributos.
- Uso correto dos métodos de atualização e exibição de informações.
- Organização e legibilidade do código.
*/

class Exercicio4
{
    public static void Executar()
    {
        /*
		Fluxo para testar a classe completa:
		1.Primeiro criamos um ingresso.
        2.Depois colocamos os valores iniciais.
        3.Mostramos as informações iniciais.
        5.Depois alteramos o preço e a quantidade.
        5.Por fim, mostramos as informações atualizadas.
		*/

        // 1.Criando o ingresso.
        Ingresso ingresso = new Ingresso();

        // 2.Colocando os valores iniciais.
        ingresso.NomeDoShow = "Rock Festival";
        ingresso.Preco = 150.00;
        ingresso.QuantidadeDisponivel = 500;

        // 3.Mostrando as informações iniciais.
        Console.WriteLine("Informações iniciais:");
        ingresso.ExibirInformacoes();

        // 4.Alterando o preço.
        ingresso.AlterarPreco(200.00);

        // 4.Alterando a quantidade disponível.
        ingresso.AlterarQuantidade(400);

        // 5. Mostra as informações do ingresso atualizadas.
        Console.WriteLine("\nInformações atualizadas após o uso dos métodos:");
        ingresso.ExibirInformacoes();
    }

    class Ingresso
    {
        public string NomeDoShow;
        public double Preco;
        public int QuantidadeDisponivel;

        public void AlterarPreco(double novoPreco)
        {
            Preco = novoPreco;
        }

        public void AlterarQuantidade(int novaQuantidade)
        {
            QuantidadeDisponivel = novaQuantidade;
        }

        public void ExibirInformacoes()
        {
            Console.WriteLine("Nome do show: " + NomeDoShow);
            Console.WriteLine("Preço: R$ " + Preco);
            Console.WriteLine("Ingressos disponíveis: " + QuantidadeDisponivel);
        }
    }
}


/*
Exercício 5 Criando Métodos de Propriedade (Getters e Setters)

Enunciado: Ainda no contexto de venda de show, vamos criar métodos para ler e alterar os valores dos atributos sem acessar diretamente as variáveis. Esses métodos são os getters e setters.
1. Métodos "Get" (Leitura)
- Crie, na classe Ingresso, um método para retornar o valor de cada atributo: -GetNomeDoShow(), GetPreco(), GetQuantidadeDisponivel(), etc.
2. Métodos "Set" (Atualização)
- Crie métodos que recebam um novo valor para cada atributo: -SetNomeDoShow(string novoNome), SetPreco(double novoPreco), SetQuantidadeDisponivel(int novaQtd), etc.
3. Exemplo de Uso
- Mostre (no Main ou em outra classe de teste) como invocar esses métodos, por exemplo, chamando SetPreco(200.0) e em seguida GetPreco() para confirmar a atualização.

Observações:
- Você não precisa, neste momento, usar modificadores de acesso (public/private). Basta ter métodos simples de leitura e escrita.
- Explique por que esses métodos (getters e setters) podem ser úteis, mesmo que não esteja usando encapsulamento total ainda.

Considerações:
- Criação dos métodos de leitura (getters) e de atualização (setters) para cada atributo.
- Demonstração clara de uso (chamada no Main ou classe de teste).
- Clareza e objetividade na explicação sobre função dos getters e setters no gerenciamento de ingressos.
*/

class Exercicio5
{
    public static void Executar()
    {
        /*
		Criando métodos para consultar e alterar os dados do ingresso.
		Get = pega ou consulta um valor.
		Set = altera um valor.

		Por exemplo:
		GetPreco() -> pega o preço atual.
		SetPreco() -> altera o preço.

		Isso ajuda a deixar organizada a forma como os dados da classe são acessados.
		*/

        Ingresso ingresso = new Ingresso();

        // Colocando os valores usando os métodos Set.
        ingresso.SetNomeDoShow("Rock Festival");
        ingresso.SetPreco(180.00);
        ingresso.SetQuantidadeDisponivel(300);

        // Exibindo preço inicial
        Console.WriteLine("Preço inicial: R$ " + ingresso.GetPreco() + "\n");

        // Alterando o preço.
        ingresso.SetPreco(200.00);

        // Pegando os valores usando os métodos Get.
        Console.WriteLine("Nome do show: " + ingresso.GetNomeDoShow());
        Console.WriteLine("Preço atualizado: R$ " + ingresso.GetPreco());
        Console.WriteLine("Ingressos disponíveis: " + ingresso.GetQuantidadeDisponivel());
    }

    class Ingresso
    {
        public string NomeDoShow;
        public double Preco;
        public int QuantidadeDisponivel;

        // GET: pega o nome do show.
        public string GetNomeDoShow()
        {
            return NomeDoShow;
        }

        // GET: pega o preço.
        public double GetPreco()
        {
            return Preco;
        }

        // GET: pega a quantidade disponível.
        public int GetQuantidadeDisponivel()
        {
            return QuantidadeDisponivel;
        }

        // SET: altera o nome do show.
        public void SetNomeDoShow(string novoNome)
        {
            NomeDoShow = novoNome;
        }

        // SET: altera o preço.
        public void SetPreco(double novoPreco)
        {
            Preco = novoPreco;
        }

        // SET: altera a quantidade disponível.
        public void SetQuantidadeDisponivel(int novaQtd)
        {
            QuantidadeDisponivel = novaQtd;
        }
    }
}

/*
Exercício 6 Adicionando Construtores à Classe "Ingresso"

Enunciado: Para facilitar a criação de novos ingressos no sistema, vamos definir construtores:
1. Criar Construtor
- Na classe Ingresso, crie um construtor que receba parâmetros para inicializar obrigatoriamente nomeDoShow, preco e quantidadeDisponivel.
2. Exemplificar o Uso
- No método Main ou em outra classe de teste, instancie um objeto do tipo Ingresso usando esse construtor.
- Exiba as informações do objeto (usando ExibirInformacoes() ou getters) para confirmar que os valores foram atribuídos corretamente.
3. Justificativa
- Explique por que usar um construtor facilita a criação de objetos em relação a chamar vários métodos Set... separadamente.

Considerações:
- Declaração correta de um construtor com parâmetros na classe Ingresso.
- Atribuição adequada dos atributos nomeDoShow, preco e quantidadeDisponivel.
- Demonstração clara do uso do construtor (instanciando um objeto e exibindo informações).
- Clareza na explicação da utilidade dos construtores.
*/

class Exercicio6
{
    public static void Executar()
    {
        /*
		Ao invés de criávamos o objeto e depois preenchíamos
		cada informação separadamente.

		Agora vamos isso será feito no momento em que o objeto é criado.

		O construtor é executado quando usamos:

		new Ingresso(...)

		Assim podendo criar o ingresso já preenchido com os valores.

        Nome do show = Festival de Rock
        Preço = 200
        Quantidade = 500
        */

        // Ingresso ingresso = new Ingresso("Festival de Rock", 200.00, 500);
        Ingresso ingresso = new Ingresso(
            "Festival de Rock",
            200.00,
            500
        );

        ingresso.ExibirInformacoes();
    }

    class Ingresso
    {
        public string NomeDoShow;
        public double Preco;
        public int QuantidadeDisponivel;

        // Construtor.
        // public Ingresso(string nomeDoShow, double preco, int quantidadeDisponivel)...
        public Ingresso(
            string nomeDoShow,
            double preco,
            int quantidadeDisponivel)
        {
            NomeDoShow = nomeDoShow; // Onde NomeDoShow se refere à classe Ingresso e nomeDoShow ao dado instanciado no objeto ingresso, dentro da função principal Executar().
            Preco = preco;
            QuantidadeDisponivel = quantidadeDisponivel;
        }

        // Mostra os dados do ingresso.
        public void ExibirInformacoes()
        {
            Console.WriteLine("Nome do show: " + NomeDoShow);
            Console.WriteLine("Preço: R$ " + Preco);
            Console.WriteLine("Ingressos disponíveis: " + QuantidadeDisponivel);
        }
    }
}

/*
Contexto para Exercícios 7, 8 e 9: Matrícula de Faculdade
Agora, mude de cenário: você vai criar um sistema simples de matrícula para uma faculdade. A ideia é cadastrar informações básicas do aluno e efetuar operações relacionadas à sua matrícula.

Exercício 7 Modelando uma Matrícula

Enunciado: Crie uma classe chamada 'Matricula' que contenha, no mínimo, os seguintes atributos:
- NomeDoAluno (string)
- Curso (string)
- NumeroMatricula (int) -- identificador da matrícula
- Situacao (string) -- por exemplo, "Ativa", "Trancada", "Concluída" etc.
- DataInicial (string) -- registra a data em que a matrícula foi iniciada

Considerações:
- Declaração correta da classe 'Matricula'.
- Atributos essenciais para representar uma matrícula.
- Código organizado e seguindo convenções básicas de C#.
*/

class Exercicio7
{
    public static void Executar()
    {
        // Criando um objeto da classe Matricula.
        Matricula matricula = new Matricula();

        // Colocando as informações no objeto.
        matricula.NomeDoAluno = "João da Silva";
        matricula.Curso = "Engenharia de Software";
        matricula.NumeroMatricula = 12345;
        matricula.Situacao = "Ativa";
        matricula.DataInicial = "07/09/2026";

        // Mostrando as informações da matrícula.
        Console.WriteLine("Nome do aluno: " + matricula.NomeDoAluno);
        Console.WriteLine("Curso: " + matricula.Curso);
        Console.WriteLine("Número da matrícula: " + matricula.NumeroMatricula);
        Console.WriteLine("Situação: " + matricula.Situacao);
        Console.WriteLine("Data inicial: " + matricula.DataInicial);
    }

    // Criação da classe Matricula.
    class Matricula
    {
        // Atributos da classe.
        public string NomeDoAluno;
        public string Curso;
        public int NumeroMatricula;
        public string Situacao;
        public string DataInicial;
    }
}

/*
Exercício 8 Criando Métodos na Classe de Matrícula

Enunciado: Agora que a classe 'Matricula' foi definida, vamos criar métodos para manipular seu estado:
1. Trancar Matrícula
- Um método Trancar() que altera Situacao para "Trancada".
2. Reativar Matrícula
- Um método Reativar() que altera Situacao para "Ativa".
3. Exibir Informações
- Um método ExibirInformacoes() que mostre (no console ou como retorno) o nome do aluno, o curso, a situação atual e a data inicial da matrícula.

Observações:
- Escolha nomes adequados aos métodos (iniciando com letra maiúscula ou minúscula, conforme convenção do seu projeto, mas seja consistente).

Considerações:
- Implementação adequada dos métodos solicitados (trancar e reativar).
- Exibição clara das informações básicas da matrícula.
- Organização e clareza do código.
*/

class Exercicio8
{
    public static void Executar()
    {
        /*
        A classe não irá servir apenas para guardar informações.
        Ela também poderá alterar o estado da matrícula.
        */

        // Criando um objeto da classe Matricula.
        Matricula matricula = new Matricula();

        // Colocando as informações no objeto.
        matricula.NomeDoAluno = "Irineu";
        matricula.Curso = "Engenharia de Software";
        matricula.NumeroMatricula = 12345;
        matricula.Situacao = "Ativa";
        matricula.DataInicial = "07/09/2026";

        // Mostrando as informações iniciais.
        Console.WriteLine("Informações iniciais:");
        matricula.ExibirInformacoes();

        // Alterando a situação para "Trancada".
        matricula.Trancar();

        // Mostrando as informações depois de trancar.
        Console.WriteLine("\nDepois de trancar a matrícula:");
        matricula.ExibirInformacoes();

        // Alterando a situação novamente para "Ativa".
        matricula.Reativar();

        // Mostrando as informações depois de reativar.
        Console.WriteLine("\nDepois de reativar a matrícula:");
        matricula.ExibirInformacoes();
    }

    class Matricula
    {
        public string NomeDoAluno;
        public string Curso;
        public int NumeroMatricula;
        public string Situacao;
        public string DataInicial;

        // Método que altera a situação para "Trancada".
        public void Trancar()
        {
            Situacao = "Trancada";
        }

        // Método que altera a situação para "Ativa".
        public void Reativar()
        {
            Situacao = "Ativa";
        }

        // Método que mostra as informações da matrícula.
        public void ExibirInformacoes()
        {
            Console.WriteLine("Nome do aluno: " + NomeDoAluno);
            Console.WriteLine("Curso: " + Curso);
            Console.WriteLine("Número da matrícula: " + NumeroMatricula);
            Console.WriteLine("Situação: " + Situacao);
            Console.WriteLine("Data inicial: " + DataInicial);
        }
    }
}

/*
Exercício 9 Testando a Classe de Matrícula

Enunciado: Crie uma classe de teste (por exemplo, TestaMatricula) com um método Main para:
1. Instanciar um objeto Matricula.
2. Atribuir valores aos atributos básicos (nome do aluno, curso, número da matrícula, data inicial etc.).
3. Chamar os métodos Trancar() e Reativar(), além de ExibirInformacoes(), mostrando no console como a situação da matrícula muda.

Observações:
- Mantenha as convenções de nomes e boas práticas de organização de código.
- Você pode colocar as classes em arquivos separados ou no mesmo arquivo, contanto que fique claro onde está o Main.

Considerações:
- Correta instanciação da classe Matricula e atribuição de valores iniciais.
- Chamadas adequadas aos métodos Trancar(), Reativar() e ExibirInformacoes().
- Clareza na evidência de que os métodos funcionam (ex.: imprimir antes e depois).
*/



/*
Exercício 9 Testando a Classe de Matrícula

Enunciado: Crie uma classe de teste (por exemplo, TestaMatricula) com um método Main para:
1. Instanciar um objeto Matricula.
2. Atribuir valores aos atributos básicos (nome do aluno, curso, número da matrícula, data inicial etc.).
3. Chamar os métodos Trancar() e Reativar(), além de ExibirInformacoes(), mostrando no console como a situação da matrícula muda.

Observações:
- Mantenha as convenções de nomes e boas práticas de organização de código.
- Você pode colocar as classes em arquivos separados ou no mesmo arquivo, contanto que fique claro onde está o Main.

Considerações:
- Correta instanciação da classe Matricula e atribuição de valores iniciais.
- Chamadas adequadas aos métodos Trancar(), Reativar() e ExibirInformacoes().
- Clareza na evidência de que os métodos funcionam (ex.: imprimir antes e depois).
*/
class Exercicio9
{
    public static void Executar()
    {
        /*
        Fluxo para testar a classe Matricula:
        1.Primeiro vamos criar o objeto e colocar os valores iniciais. A matrícula começa com a situação "Ativa".
        2.Depois vamos chamar Trancar(). A situação deve mudar para "Trancada".
        3.Por último vamos chamar Reativar(). A situação deve voltar para "Ativa".

        Assim conseguimos acompanhar no console a mudança da situação da matrícula.
        */

        // 1.Criando o objeto da classe Matricula.
        Matricula matricula = new Matricula();

        // 1.Colocando os valores iniciais.
        matricula.NomeDoAluno = "Judesclaudo";
        matricula.Curso = "Engenharia de Software";
        matricula.NumeroMatricula = 54321;
        matricula.Situacao = "Ativa";
        matricula.DataInicial = "01/08/2026";

        // Mostrando as informações iniciais.
        Console.WriteLine("=== Situação inicial ===");
        matricula.ExibirInformacoes();

        // 2.Alterando a situação para "Trancada".
        matricula.Trancar();

        // Mostrando as informações depois de trancar.
        Console.WriteLine("\n=== Depois de trancar ===");
        matricula.ExibirInformacoes();

        // 3.Alterando a situação novamente para "Ativa".
        matricula.Reativar();

        // Mostrando as informações depois de reativar.
        Console.WriteLine("\n=== Depois de reativar ===");
        matricula.ExibirInformacoes();
    }

    class Matricula
    {
        public string NomeDoAluno;
        public string Curso;
        public int NumeroMatricula;
        public string Situacao;
        public string DataInicial;

        // Método que altera a situação para "Trancada".
        public void Trancar()
        {
            Situacao = "Trancada";
        }

        // Método que altera a situação para "Ativa".
        public void Reativar()
        {
            Situacao = "Ativa";
        }

        // Método que mostra as informações da matrícula.
        public void ExibirInformacoes()
        {
            Console.WriteLine("Nome do aluno: " + NomeDoAluno);
            Console.WriteLine("Curso: " + Curso);
            Console.WriteLine("Número da matrícula: " + NumeroMatricula);
            Console.WriteLine("Situação: " + Situacao);
            Console.WriteLine("Data inicial: " + DataInicial);
        }
    }
}

/*
Contexto para Exercícios 10, 11 e 12: Áreas e Volumes em C#
Você está desenvolvendo um sistema para calcular áreas (em figuras 2D) e volumes (em figuras 3D), agora utilizando C#. Não serão utilizados conceitos avançados, como herança: cada classe será independente.

Exercício 10 Definindo Classes de Formas Geométricas

Enunciado: Siga o passo a passo abaixo:
1. Classes Iniciais
- Crie a classe Circulo com o atributo Raio (double).
- Crie a classe Esfera com o atributo Raio (double).
2. Definição de Atributos
- Explique por que o atributo Raio é fundamental para essas figuras.
- Não é preciso criar métodos de cálculo ainda -- apenas estruture as classes.

Considerações:
- Declaração correta das classes Circulo e Esfera.
- Presença e clareza na definição do(s) atributo(s) necessário(s).
- Código organizado e fácil de ler, sem introduzir conceitos não ensinados (como herança).
*/

class Exercicio10
{
    public static void Executar()
    {
        /*
        Figuras geométricas:
        Circulo
        Esfera

        Ambas possuem um atributo chamado Raio.
        No círculo, vamos usar o raio para descobrir a área.
        Na esfera, vamos usar o raio para descobrir o volume.

        Ainda não terá cálculos, apenas as classes e seus atributos.
        */

        // Criando um objeto da classe Circulo.
        Circulo circulo = new Circulo();

        // Criando um objeto da classe Esfera.
        Esfera esfera = new Esfera();

        // Colocando um valor para o raio de cada objeto.
        circulo.Raio = 3.0;
        esfera.Raio = 5.0;

        // Mostrando os valores para testar.
        Console.WriteLine("Raio do círculo: " + circulo.Raio);
        Console.WriteLine("Raio da esfera: " + esfera.Raio);
    }

    // Criação da classe Circulo.
    class Circulo
    {
        // Atributo que guarda o raio do círculo.
        public double Raio;
    }

    // Criação da classe Esfera.
    class Esfera
    {
        // Atributo que guarda o raio da esfera.
        public double Raio;
    }
}


/*
Exercício 11 Criando Métodos de Cálculo

Enunciado: Agora, você adicionará métodos para calcular:
1. Área do Círculo
- Na classe Circulo, crie um método CalcularArea() que retorne Math.PI * (Raio * Raio).
2. Volume da Esfera
- Na classe Esfera, crie um método CalcularVolume() que retorne (4.0 / 3.0) * Math.PI * (Raio * Raio * Raio).

Observações:
- Não utilize recursos avançados de C#, como herança ou interfaces -- fique nos métodos simples.
- Lembre-se de retornar o resultado, não somente imprimir.

Considerações:
- Métodos de cálculo corretos e funcionais.
- Retorno adequado dos valores (pode usar double).
- Código bem organizado.
*/

class Exercicio11
{
    public static void Executar()
    {
        /*
        Acrescentando os métodos de cálculo.

        CalcularArea() = calcula a área do círculo.
        A fórmula:
        Área = PI x Raio x Raio

        CalcularVolume() = calcula o volume da esfera.
        A fórmula:
        Volume = (4 / 3) x PI x Raio x Raio x Raio

        O Math.PI já fornece o valor de PI.
        */

        // Criando um objeto da classe Circulo.
        Circulo circulo = new Circulo();

        // Criando um objeto da classe Esfera.
        Esfera esfera = new Esfera();

        // Definindo o raio do círculo.
        circulo.Raio = 3.0;

        // Definindo o raio da esfera.
        esfera.Raio = 5.0;

        // Chamando o método para calcular a área.
        double area = circulo.CalcularArea();

        // Chamando o método para calcular o volume.
        double volume = esfera.CalcularVolume();

        // Mostrando os resultados.
        Console.WriteLine("Área do círculo: " + area);
        Console.WriteLine("Volume da esfera: " + volume);
    }

    // Criação da classe Circulo.
    class Circulo
    {
        public double Raio;

        // Método que calcula a área do círculo.
        public double CalcularArea()
        {
            return Math.PI * (Raio * Raio);
        }
    }

    // Criação da classe Esfera.
    class Esfera
    {
        public double Raio;

        // Método que calcula o volume da esfera.
        public double CalcularVolume()
        {
            return (4.0 / 3.0) * Math.PI * (Raio * Raio * Raio);
        }
    }
}

/*
Exercício 12 Testando as Classes de Figuras

Enunciado: Crie uma classe de teste (por exemplo, TestaFiguras) com Main para:
1. Instanciar um objeto da classe Circulo e outro da classe Esfera.
2. Definir valores de Raio (por exemplo, 3.0 para o círculo e 5.0 para a esfera).
3. Chamar os métodos CalcularArea() e CalcularVolume().
4. Exibir os resultados no console, validando se funcionam corretamente.

Observações:
- Caso opte por arquivos separados, lembre-se de compilar todos e depois rodar a classe com Main.
- Não use conceitos como herança ou polimorfismo; limite-se a instanciar e chamar métodos.

Considerações:
- Criação de uma classe de teste com método Main.
- Instanciação correta de Circulo e Esfera, atribuindo Raio adequadamente.
- Chamadas corretas aos métodos de cálculo, exibindo resultados plausíveis.
- Organização e legibilidade do código, seguindo convenções de C#.
*/

class Exercicio12
{
    public static void Executar()
    {
        /*
        Fluxo de teste final das duas classes:
        1.Primeiro criamos um círculo e uma esfera.
        2.Depois colocamos os valores dos raios:
        Círculo = 3
        Esfera = 5
        3.Em seguida chamamos os métodos de cálculo.
        4.Por fim, mostramos os resultados no console.
        */

        // Criando um objeto da classe Circulo.
        Circulo circulo = new Circulo();

        // Criando um objeto da classe Esfera.
        Esfera esfera = new Esfera();

        // Definindo o raio do círculo.
        circulo.Raio = 3.0;

        // Definindo o raio da esfera.
        esfera.Raio = 5.0;

        // Chamando o método para calcular a área.
        double area = circulo.CalcularArea();

        // Chamando o método para calcular o volume.
        double volume = esfera.CalcularVolume();

        // Mostrando os resultados com duas casas decimais.
        Console.WriteLine(
            "Área do círculo: " + area.ToString("F2")
        );

        Console.WriteLine(
            "Volume da esfera: " + volume.ToString("F2")
        );
    }

    // Criação da classe Circulo.
    class Circulo
    {
        public double Raio;

        // Método que calcula a área do círculo.
        public double CalcularArea()
        {
            return Math.PI * (Raio * Raio);
        }
    }

    // Criação da classe Esfera.
    class Esfera
    {
        public double Raio;

        // Método que calcula o volume da esfera.
        public double CalcularVolume()
        {
            return (4.0 / 3.0) * Math.PI * (Raio * Raio * Raio);
        }
    }
}
