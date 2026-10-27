/*
Competência: Escrever programas em Java que utilizem classes e objetos

Exercício 1 Conceitos de Classe, Objeto, Campos e Métodos

Enunciado: Com base no conteúdo estudado sobre Programação Orientada a Objetos em Java, elabore uma explicação clara e objetiva dos conceitos de classe, objeto, campos (ou atributos) e métodos. Em seguida, crie um exemplo simples (em pseudocódigo ou em Java) que ilustre esses conceitos na prática. Seu exemplo deve conter:
1. Declaração de uma classe.
2. Pelo menos dois campos (ou atributos) diferentes.
3. Pelo menos um método que utilize ou manipule os campos da classe.
4. Criação de um objeto a partir da classe declarada.

Observações:
- Você pode usar exemplos do dia a dia (como “Carro”, “ContaBancaria”, etc.) para tornar a explicação mais clara.
- Procure relacionar cada conceito com o exemplo criado, explicando o que cada parte representa na prática.
- Seja sucinto, mas inclua detalhes suficientes para demonstrar compreensão do assunto.

Considerações:
- Clareza e correção conceitual na explicação dos termos (classe, objeto, campos, métodos).
- Qualidade do exemplo prático e conexão com a teoria.
- Organização do texto e uso correto da linguagem de programação (caso opte por Java).
*/

/*
Uma classe é como uma planta ou um molde.

Ela diz quais informações uma coisa vai ter
e quais ações ela pode fazer.

Os atributos são as informações que pertencem ao objeto.
Por exemplo: um veículo pode ter modelo e velocidade.

Os métodos são as ações que o objeto pode fazer.
Por exemplo: o veículo pode acelerar.

O objeto é algo criado a partir da classe.
A classe é a planta de uma casa por exemplo.
O objeto é a coisa que foi construída usando essa planta, no caso a casa.
*/

class Veiculo {
    String modelo;
    double velocidade;

    void acelerar(double valor) {
        velocidade += valor;
    }
}

public class Exercicio_1 {
    public static void main(String[] args) {

        // Criando um objeto da classe Veiculo.
        Veiculo carro = new Veiculo();

        // Colocando informações no objeto.
        carro.modelo = "Toyota Corolla";
        carro.velocidade = 0;

        // Fazendo o carro acelerar.
        carro.acelerar(50);

        // Mostrando as informações.
        System.out.println("Modelo: " + carro.modelo);
        System.out.println("Velocidade: " + carro.velocidade + " km/h");
    }
}

/*
Nesse exemplo:

Veiculo = classe
modelo e velocidade = atributos
acelerar() = método
carro = objeto

Ou seja, criamos um modelo chamado Veiculo
e depois criamos um objeto chamado carro a partir dele.
*/
