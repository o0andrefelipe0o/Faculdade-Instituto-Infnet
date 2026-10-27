/*
Exercício 4 Testando a Classe “Produto”

Enunciado: Dando sequência ao contexto de gerenciamento de produtos em um pequeno supermercado, agora é hora de testar a classe Produto que você desenvolveu. Para isso:
1. Criar Classe de Teste ou Método main
- Crie uma nova classe (por exemplo, AppProduto ou Main) ou utilize um método principal (main) em alguma classe existente.
2. Instanciar um Produto
- Dentro do main, instancie (crie um objeto) da classe Produto.
- Atribua valores iniciais aos atributos nome, preco e quantidadeEmEstoque.
3. Chamar os Métodos de Atualização
- Chame os métodos alterarPreco e alterarQuantidade para modificar o preço e a quantidade em estoque do produto que você criou.
4. Exibir Informações
- Por fim, chame o método exibirInformacoes para confirmar se as alterações foram aplicadas corretamente, exibindo as informações atualizadas do produto no console (ou retornando-as de alguma forma).

Considerações:
- Criação correta de uma classe ou método principal que possa executar o código.
- Instanciação da classe Produto e atribuição de valores iniciais.
- Uso correto dos métodos implementados para atualizar e exibir as informações do produto.
- Clareza na organização do código de teste (legibilidade e boa prática).
*/
/*
Exercício 4 Testando a Classe “Produto”

Enunciado: Dando sequência ao contexto de gerenciamento de produtos em um pequeno supermercado, agora é hora de testar a classe Produto que você desenvolveu. Para isso:
1. Criar Classe de Teste ou Método main
- Crie uma nova classe (por exemplo, AppProduto ou Main) ou utilize um método principal (main) em alguma classe existente.
2. Instanciar um Produto
- Dentro do main, instancie (crie um objeto) da classe Produto.
- Atribua valores iniciais aos atributos nome, preco e quantidadeEmEstoque.
3. Chamar os Métodos de Atualização
- Chame os métodos alterarPreco e alterarQuantidade para modificar o preço e a quantidade em estoque do produto que você criou.
4. Exibir Informações
- Por fim, chame o método exibirInformacoes para confirmar se as alterações foram aplicadas corretamente, exibindo as informações atualizadas do produto no console (ou retornando-as de alguma forma).

Considerações:
- Criação correta de uma classe ou método principal que possa executar o código.
- Instanciação da classe Produto e atribuição de valores iniciais.
- Uso correto dos métodos implementados para atualizar e exibir as informações do produto.
- Clareza na organização do código de teste (legibilidade e boa prática).
*/

/*
Criando um produto e testando os métodos.

Dentro da Main criamos o objeto.

Depois colocamos os valores iniciais.

Em seguida alteramos o preço e a quantidade.

Por fim, mostramos as informações atualizadas.
*/

class Produto_4 {
    String nome;
    double preco;
    int quantidadeEmEstoque;

    void alterarPreco(double novoPreco) {
        preco = novoPreco;
    }

    void alterarQuantidade(int novaQuantidade) {
        quantidadeEmEstoque = novaQuantidade;
    }

    void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Quantidade em estoque: " + quantidadeEmEstoque);
    }
}

public class Exercicio_4 {
    public static void main(String[] args) {

        // Criando um produto.
        Produto_4 produto = new Produto_4();

        // Colocando os valores iniciais.
        produto.nome = "Arroz 5kg";
        produto.preco = 25.90;
        produto.quantidadeEmEstoque = 20;

        // Alterando o preço.
        produto.alterarPreco(27.50);

        // Alterando a quantidade em estoque.
        produto.alterarQuantidade(15);

        // Mostrando as informações atualizadas.
        produto.exibirInformacoes();
    }
}

/*
O produto começou com:

Preço: 25.90
Estoque: 20

Depois usamos os métodos para mudar para:

Preço: 27.50
Estoque: 15
*/
