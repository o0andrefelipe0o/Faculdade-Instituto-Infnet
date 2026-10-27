/*
Exercício 7 Modelando uma Conta Bancária

Enunciado: Imagine que você é responsável por criar um sistema simples de gerenciamento de contas bancárias. Esse sistema deverá cadastrar informações básicas sobre a conta, bem como realizar operações essenciais, como saque e depósito.
1. Criar a Classe Conta
- Nome da classe: Conta (respeitando convenções Java).
- A classe deve conter no mínimo os seguintes atributos:
1. titular (String) – representa o nome do dono da conta.
2. numero (int) – identifica a conta.
3. agencia (String) – identifica a agência bancária.
4. saldo (double) – indica o valor atualmente disponível na conta.
5. dataAbertura (String) – registra quando a conta foi aberta.
*/

/*
Supondo que uma conta bancária precisaria guardar as seguintes informações:

titular -> nome do dono da conta
numero -> número da conta
agencia -> agência
saldo -> dinheiro disponível
dataAbertura -> data em que a conta foi criada

Tudo isso ficaria dentro da classe Conta_7.
*/

class Conta_7 {
    String titular;
    int numero;
    String agencia;
    double saldo;
    String dataAbertura;
}

/*
A classe Conta_7 ainda não faz nenhuma ação.
Ela está apenas guarda as informações de uma conta bancária.
*/
