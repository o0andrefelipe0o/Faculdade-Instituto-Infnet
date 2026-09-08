/*
Exercício 3 Métodos Básicos da Classe “Produto”

Enunciado: Dando continuidade ao contexto em que você é responsável pelo gerenciamento de produtos em um pequeno supermercado, agora vamos aprimorar a classe Produto adicionando métodos básicos de manipulação:
1. Implementar Método de Atualização de Preço
- Crie um método chamado alterarPreco que receba um novo preço (do tipo double) e atualize o atributo preco do produto.
2. Implementar Método de Atualização de Quantidade
- Crie um método chamado alterarQuantidade que receba um valor inteiro representando a nova quantidade e atualize o atributo quantidadeEmEstoque.
3. Exibir Informações do Produto
- Crie um método chamado exibirInformacoes, que mostre (no console ou como retorno) o nome, o preço e a quantidade em estoque do produto, refletindo o estado atual do objeto.

Considerações:
- Correta implementação dos métodos solicitados.
- Clareza e objetividade no código, evidenciando como cada método cumpre sua função de atualizar ou exibir informações.
- Utilização adequada dos atributos já criados na classe Produto.
*/

/*
Fazendo o produto conseguir alterar o próprio preço e a quantidade em estoque através dos métodos:

alterarPreco() vai trocar o preço.

alterarQuantidade() vai trocar a quantidade em estoque.

exibirInformacoes() vai mostrar os dados do produto.
*/

class Produto_3 {
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

/*
Agora o produto não serve apenas para guardar informações.
Ele também consegue realizar as ações:
alterar o preço,
alterar a quantidade
e mostrar suas informações.
*/
