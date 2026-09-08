/*
Exercício 6 Adicionando Construtores à Classe “Produto”

Enunciado: Você continua responsável pelo gerenciamento de produtos no pequeno supermercado. Agora, deseja facilitar a criação de novos produtos no sistema, definindo valores iniciais de maneira mais simples e organizada.
1. Criar Construtor
- Na classe Produto, crie um construtor que receba parâmetros para inicializar obrigatoriamente os atributos nome, preco e quantidadeEmEstoque.
- Descreva rapidamente como o construtor se comporta ao receber os valores.
2. Exemplificar o Uso
- No método main ou em outra classe de teste, crie um objeto do tipo Produto usando o construtor que recebe parâmetros.
- Atribua valores para nome, preco e quantidadeEmEstoque, e então exiba as informações do produto (usando o método exibirInformacoes ou métodos getters) para confirmar que os valores iniciais foram atribuídos corretamente.
3. Justificativa
- Explique por que usar um construtor facilita a criação de objetos em relação a atribuir valores por vários métodos “set” ou chamadas separadas.

Considerações:
- Declaração correta de um construtor que receba parâmetros na classe Produto.
- Atribuição adequada dos atributos nome, preco e quantidadeEmEstoque dentro do construtor.
- Demonstração clara do uso do construtor (instanciando um objeto, exibindo informações).
- Clareza na explicação sobre a utilidade do construtor no contexto de criação de produtos.
*/

/*
Criando o objeto e colocando os valores de uma vez, executando o construtor ao criar um objeto.

Assim podemos criar o produto já com:
nome
preço
quantidade em estoque

Isso deixa a criação do objeto mais prática.
*/

class Produto_6 {
    String nome;
    double preco;
    int quantidadeEmEstoque;

    // Construtor da classe Produto_6.
    Produto_6(String nome, double preco, int quantidadeEmEstoque) {

        // O this.nome é o nome que pertence a este objeto Produto_6, já nome depois do = pertence ao parâmetro passado entre parênteses no construtor. Ambos podem ter nomes diferentes.
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Quantidade em estoque: " + quantidadeEmEstoque);
    }
}

public class Exercicio_6 {
    public static void main(String[] args) {

        // Criando o produto com todas as informações preenchidas. Parametrizando dentro de ().
        // Produto_6 produto = new Produto_6("Leite 1L",  5.50, 40);
        Produto_6 produto = new Produto_6(
                "Leite 1L",
                5.50,
                40
        );

        produto.exibirInformacoes();
    }
}

/*
O construtor recebe os valores e coloca cada um no atributo correspondente.
Assim evitamos fazer várias linhas depois para preencher o produto.
*/
