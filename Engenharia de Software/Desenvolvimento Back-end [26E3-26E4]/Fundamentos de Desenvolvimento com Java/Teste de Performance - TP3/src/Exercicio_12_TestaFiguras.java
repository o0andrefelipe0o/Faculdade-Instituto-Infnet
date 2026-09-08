/*
Exercício 12 Testando as Classes de Figuras

Enunciado: Finalmente, é hora de testar as classes que você criou. Crie uma classe de teste (por exemplo, TestaFiguras) com um método main para:
1. Instanciar um objeto da classe Circulo e outro da classe Esfera.
2. Atribuir valores de raio (ex.: 3.0 para o círculo, 5.0 para a esfera).
3. Chamar os métodos de cálculo (calcularArea() e calcularVolume()).
4. Exibir os resultados no console para verificar se os métodos estão funcionando corretamente.

Observações:
- Caso opte por arquivos separados, lembre-se de compilar ambos (por exemplo, javac Circulo.java Esfera.java TestaFiguras.java) e depois rodar a classe que tem o main.
- Não use conceitos como herança; limite-se a instanciar e chamar os métodos.

Considerações:
- Criação de uma classe de teste com método main.
- Instanciação correta das classes Circulo e Esfera, atribuindo valores ao atributo raio.
- Chamadas corretas aos métodos de cálculo, exibindo resultados plausíveis.
- Organização e legibilidade do código, seguindo convenções Java.
*/

/*
Testando as duas classes criando:
- um círculo com raio 3;
- uma esfera com raio 5.
Depois vamos chamar os métodos que calculam a área e o volume.
*/

class Circulo_12 {
    double raio;

    double calcularArea() {
        return Math.PI * raio * raio;
    }
}

class Esfera_12 {
    double raio;

    double calcularVolume() {
        return (4.0 / 3.0) * Math.PI * raio * raio * raio;
    }
}

public class Exercicio_12_TestaFiguras {
    public static void main(String[] args) {

        // Criando um objeto da classe Circulo_12.
        Circulo_12 circulo = new Circulo_12();
        // Definindo o raio do círculo.
        circulo.raio = 3.0;
        // Calculando a área do círculo.
        double area = circulo.calcularArea();

        // Criando um objeto da classe Esfera_12.
        Esfera_12 esfera = new Esfera_12();
        // Definindo o raio da esfera.
        esfera.raio = 5.0;
        // Calculando o volume da esfera.
        double volume = esfera.calcularVolume();

        // Mostrando os resultados.
        System.out.printf("Área do círculo: %.2f%n", area);
        System.out.printf("Volume da esfera: %.2f%n", volume);
    }
}
