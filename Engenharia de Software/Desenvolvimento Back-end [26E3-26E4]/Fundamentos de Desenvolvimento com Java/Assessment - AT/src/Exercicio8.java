class Funcionario {

    protected String nome;
    protected double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public double calcularSalario() {
        return salarioBase;
    }
}

class Gerente extends Funcionario {

    public Gerente(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase * 1.20;
    }
}

class Estagiario extends Funcionario {

    public Estagiario(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase * 0.90;
    }
}

public class Exercicio8 {

    public static void main(String[] args) {

        Gerente gerente = new Gerente("Bernardo", 9000);
        Estagiario estagiario = new Estagiario("André", 1100);

        System.out.printf("Gerente: %s%n", gerente.nome);
        System.out.printf("Salário final: R$ %.2f%n%n", gerente.calcularSalario());

        System.out.printf("Estagiário: %s%n", estagiario.nome);
        System.out.printf("Salário final: R$ %.2f%n", estagiario.calcularSalario());
    }
}