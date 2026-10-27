/*
Exercício 5 Criando Métodos de Propriedade (Getters e Setters)

Enunciado: Continuando no contexto do pequeno supermercado que gerencia produtos, vamos criar métodos que permitam ler e alterar os valores dos atributos sem precisar acessá-los diretamente. Esses métodos são frequentemente chamados de “getters” e “setters” e ajudam a organizar o código, pois centralizam o modo como cada atributo pode ser modificado ou obtido.
1. Métodos “Get” (Leitura):
- Crie um método que retorne o valor de cada atributo. Por exemplo:
- getNome() deve retornar o valor de nome.
- getPreco() deve retornar o valor de preco.
- getQuantidadeEmEstoque() deve retornar o valor de quantidadeEmEstoque.
2. Métodos “Set” (Atualização):
- Crie um método que receba um novo valor para cada atributo. Por exemplo:
- setNome(String novoNome) deve atualizar o valor de nome.
- setPreco(double novoPreco) deve atualizar o valor de preco.
- setQuantidadeEmEstoque(int novaQuantidade) deve atualizar o valor de quantidadeEmEstoque.
3. Exemplo de Uso:
- Mostre (no main ou em uma classe de teste) como invocar esses métodos de leitura e atualização.
- Por exemplo, chame setPreco(3.75) e depois getPreco() para confirmar que o valor foi atualizado.

Observações:
- Você não precisa, neste momento, utilizar modificadores de visibilidade (public, private, protected). Basta criar métodos simples de “get” e “set” para cada atributo.
- Explique com suas próprias palavras por que esses métodos (getters e setters) podem ser úteis no código, mesmo que não esteja usando modificadores de acesso.

Considerações:
- Criação de métodos de leitura (getters) e métodos de atualização (setters) para cada atributo.
- Demonstração de uso desses métodos (chamada em um main ou classe de teste).
- Clareza e objetividade na explicação sobre a função dos getters e setters no gerenciamento de produtos.
*/

/*
Criar formas de consultar e alterar os dados do produto usando métodos.

Os métodos get servem para PEGAR uma informação.

Os métodos set servem para ALTERAR uma informação.

Por exemplo:

getPreco() -> pega o preço
setPreco() -> altera o preço

Estamos criando esses métodos para deixar
a maneira de acessar os dados mais organizada.
*/

class Produto_5 {
    String nome;
    double preco;
    int quantidadeEmEstoque;

    // Pega o nome.
    String getNome() {
        return nome;
    }

    // Pega o preço.
    double getPreco() {
        return preco;
    }

    // Pega a quantidade em estoque.
    int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    // Altera o nome.
    void setNome(String novoNome) {
        nome = novoNome;
    }

    // Altera o preço.
    void setPreco(double novoPreco) {
        preco = novoPreco;
    }

    // Altera a quantidade em estoque.
    void setQuantidadeEmEstoque(int novaQuantidade) {
        quantidadeEmEstoque = novaQuantidade;
    }
}

public class Exercicio_5 {
    public static void main(String[] args) {
        Produto_5 produto = new Produto_5();

        // Colocando os valores usando os métodos set.
        produto.setNome("Feijão 1kg");
        produto.setPreco(3.50);
        produto.setQuantidadeEmEstoque(30);

        // Alterando o preço.
        produto.setPreco(3.75);

        // Pegando os valores usando os métodos get.
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Preço: R$ " + produto.getPreco());
        System.out.println("Estoque: " + produto.getQuantidadeEmEstoque());
    }
}

/*
set = coloca ou altera um valor
get = pega, ou consulta um valor

setPreco(3.75)
coloca o valor 3.75 na variável que armazena o preço

getPreco()
pega ou retorna o valor atual que está armazenado na variável que armazena o preço
*/