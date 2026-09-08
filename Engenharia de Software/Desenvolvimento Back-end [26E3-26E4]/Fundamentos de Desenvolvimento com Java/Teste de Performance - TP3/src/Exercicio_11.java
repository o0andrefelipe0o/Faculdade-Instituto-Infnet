/*
Exercício 11 Criando Métodos de Cálculo

Enunciado: Agora, você adicionará métodos para calcular a área do círculo e o volume da esfera:
1. Cálculo da Área do Círculo
- Na classe Circulo, crie um método (por exemplo, calcularArea()) que retorne a área, dada por π * (raio * raio).
2. Cálculo do Volume da Esfera
- Na classe Esfera, crie um método (por exemplo, calcularVolume()) que retorne o volume, dado por (4.0 / 3.0) * π * (raio * raio * raio).
3. Valor de π
- Você pode usar Math.PI (fornecido pelo Java) ou declarar uma constante (por exemplo, static final double PI = 3.14159;), conforme desejar.

Observações:
- Lembre-se de retornar o resultado dos cálculos ao invés de apenas imprimir.
- Não utilize recursos avançados (como herança), apenas métodos simples dentro de cada classe.

Considerações:
- Métodos de cálculo corretos e funcionais (calcularArea() no círculo, calcularVolume() na esfera).
- Retorno adequado dos valores (sem prints dentro dos métodos, a menos que queira exibir para conferência).
*/


/*
Definindo o calculo de cada classe.

O círculo vai calcular sua área:
Área = PI x raio x raio

A esfera vai calcular seu volume:
Volume = (4 / 3) x PI x raio x raio x raio
*/

class Circulo_11 {
    double raio;

    double calcularArea() {
        return Math.PI * raio * raio;
    }
}

class Esfera_11 {
    double raio;

    double calcularVolume() {
        return (4.0 / 3.0) * Math.PI * raio * raio * raio;
    }
}

/*
Esses métodos fazem a conta e devolvem o valor resultante para quem os chamou.
Mas não imprimem, apenas retornam.
Ainda falta uma forma de passar valores para armazenar nas variáveis raio das classes.
*/
