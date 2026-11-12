package org.example;

public class ReembolsoService {
    private CalculadoraReembolso calculadora;
    private AutorizadorReembolso autorizador;

    public ReembolsoService(CalculadoraReembolso calculadora, AutorizadorReembolso autorizador) {
        this.calculadora = calculadora;
        this.autorizador = autorizador;
    }

    public double calcularReembolso(Consulta consulta, double valorConsulta, PlanoSaude planoSaude) {
        if (!autorizador.estaAutorizada(consulta)) {
            throw new IllegalStateException("Consulta não autorizada para reembolso.");
        }
        return calculadora.calcularReembolso(valorConsulta, planoSaude, consulta.getPaciente());
    }
}
