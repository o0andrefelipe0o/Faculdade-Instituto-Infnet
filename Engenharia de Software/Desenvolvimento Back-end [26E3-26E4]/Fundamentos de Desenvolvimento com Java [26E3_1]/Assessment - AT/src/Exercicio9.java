class ContaBancaria {

    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado.%n", valor);
    }

    public void sacar(double valor) {

        if (valor <= saldo) {
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado.%n", valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void exibirSaldo() {
        System.out.printf("Titular: %s%n", titular);
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
    }
}

public class Exercicio9 {

    public static void main(String[] args) {

        ContaBancaria conta = new ContaBancaria("André Felipe de Moraes", 75);

        conta.exibirSaldo();

        System.out.println();
        conta.depositar(1370);

        conta.sacar(1200);

        System.out.println();
        conta.exibirSaldo();
    }
}