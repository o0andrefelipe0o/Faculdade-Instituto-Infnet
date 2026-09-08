/*
Exercício 8 Criando Métodos

Enunciado: Continuamos no cenário onde você é responsável por criar o sistema de gerenciamento de contas e agora você já definiu a Classe Conta. Vamos agora definir os métodos:
- saca(double valor): recebe um valor como parâmetro e o retira do saldo da conta.
- deposita(double valor): recebe um valor como parâmetro e o adiciona ao saldo da conta.
- calculaRendimento(): não recebe nenhum parâmetro e devolve (retorna) o valor do saldo multiplicado por 0.1 (representando um rendimento mensal de 10%, por exemplo).
*/

/*
Para fazer a conta bancária realizar algumas operações será necessário criar alguns métodos:
saca() -> tira dinheiro da conta.
deposita() -> coloca dinheiro na conta.
calculaRendimento() -> calcula 10% do saldo.
*/

class Conta_8 {
    String titular;
    int numero;
    String agencia;
    double saldo;
    String dataAbertura;

    // Retira dinheiro da conta.
    void saca(double valor) {
        saldo -= valor;
    }

    // Coloca dinheiro na conta.
    void deposita(double valor) {
        saldo += valor;
    }

    // Calcula 10% do saldo atual.
    double calculaRendimento() {
        return saldo * 0.1;
    }
}
