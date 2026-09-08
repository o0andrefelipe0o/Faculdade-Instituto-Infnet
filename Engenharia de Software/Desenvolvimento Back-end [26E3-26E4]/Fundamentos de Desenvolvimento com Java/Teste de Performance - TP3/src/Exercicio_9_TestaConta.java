/*
Exercício 9 Vamos testar nossa classe

Enunciado: Continuamos no cenário aonde você é responsável por criar o sistema de gerenciamento de contas e agora você já definiu a Classe Conta. Vamos agora criar a Classe de Teste! Crie uma classe (por exemplo, TestaConta) que contenha o método main. Dentro de main:
- Instancie um objeto da classe Conta.
- Atribua valores aos atributos da conta (titular, número, agência, saldo, data de abertura).
- Chame os métodos saca, deposita e calculaRendimento para testar o comportamento da conta.
- Exiba informações relevantes (por exemplo, saldo antes e depois de cada operação, valor do rendimento etc.) para verificar se tudo está funcionando corretamente.

Observações:
- Utilize a convenção de nomes e padrões Java (por exemplo, nomes de métodos iniciando em minúsculo, nomes de classes iniciando em maiúsculo etc.).
- Você pode criar a classe Conta e a classe de teste (TestaConta) em arquivos separados ou no mesmo arquivo. Para organização, recomendamos separar.
- Caso opte por separar, lembre-se de compilar ambas as classes (por exemplo, javac Conta.java TestaConta.java). Em seguida, rode a classe com o método main (java TestaConta).

Considerações:
- Presença e correta implementação de todos os atributos solicitados.
- Funcionamento adequado dos métodos saca, deposita e calculaRendimento.
- Clareza e objetividade no código, seguindo convenções Java.
- Execução correta do programa de teste (instanciação e uso dos métodos da classe Conta).
*/


/*
Testando as operações com a seguinte ordem de fluxo:
1.Primeiro criamos a conta.
2.Depois colocamos os dados.
3.Depois fazemos um depósito.
4.Depois fazemos um saque.
5.No final calculamos o rendimento.
*/

class Conta_9 {
    String titular;
    int numero;
    String agencia;
    double saldo;
    String dataAbertura;

    void saca(double valor) {
        saldo -= valor;
    }

    void deposita(double valor) {
        saldo += valor;
    }

    double calculaRendimento() {
        return saldo * 0.1;
    }
}

public class Exercicio_9_TestaConta {
    public static void main(String[] args) {

        // Criando a conta.
        Conta_9 conta = new Conta_9();

        // Colocando os dados da conta.
        conta.titular = "João da Silva";
        conta.numero = 12345;
        conta.agencia = "001";
        conta.saldo = 1000.00;
        conta.dataAbertura = "07/09/2026";

        System.out.println("Titular: " + conta.titular);
        System.out.println("Número: " + conta.numero);
        System.out.println("Agência: " + conta.agencia);
        System.out.println("Data de abertura: " + conta.dataAbertura);

        // Mostrando o saldo inicial.
        System.out.println("\nSaldo inicial: R$ " + conta.saldo);

        // Fazendo um depósito.
        conta.deposita(500.00);

        System.out.println("Saldo após depósito: R$ " + conta.saldo);

        // Fazendo um saque.
        conta.saca(200.00);

        System.out.println("Saldo após saque: R$ " + conta.saldo);

        // Calculando o rendimento.
        double rendimento = conta.calculaRendimento();

        System.out.println("Rendimento: R$ " + rendimento);
    }
}

/*
Saldo inicial: 1000

Depósito de 500:
1000 + 500 = 1500

Saque de 200:
1500 - 200 = 1300

Rendimento:
1300 x 0.1 = 130
*/
