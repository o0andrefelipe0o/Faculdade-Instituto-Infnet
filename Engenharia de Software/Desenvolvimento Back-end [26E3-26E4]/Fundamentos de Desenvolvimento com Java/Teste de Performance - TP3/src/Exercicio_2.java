/*
Contexto para as próximas questões:
Imagine que você é responsável pelo gerenciamento de produtos em um pequeno supermercado. É preciso cadastrar cada item com nome, preço e quantidade disponível em estoque, bem como atualizar esses dados sempre que houver mudanças. Ao final, você deve exibir as informações do produto para ter um registro atualizado no sistema.

Exercício 2 Criando a Classe “Produto” (Com Contexto de Usuário)

Enunciado: Com base nessa história de usuário, vamos criar uma classe que represente um produto de supermercado. Sua tarefa é declarar a classe e os atributos:
- Crie uma classe chamada Produto.
- Insira nela, pelo menos, os atributos: nome (String), preco (double) e quantidadeEmEstoque (int).
- Explique brevemente por que cada atributo é importante no contexto de gerenciamento de produtos.

Considerações:
- Declaração correta dos atributos e criação da classe Produto.
*/

/*
Cada produto precisa guardar algumas informações:

- nome: para saber qual é o produto;
- preco: para saber quanto ele custa;
- quantidadeEmEstoque: para saber quantas unidades temos.

Essas informações serão os atributos da classe Produto.
*/

class Produto_2 {
    String nome;
    double preco;
    int quantidadeEmEstoque;
}

/*
A classe Produto_2 ainda não faz nenhuma ação.
Está servindo apenas como um modelo para guardar as informações de um produto.
*/