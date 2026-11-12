/*
Etapa 1 - Reembolso Básico
Você começará implementando a função mais simples do sistema: calcular o valor a ser reembolsado com base em um valor fixo e percentual de cobertura. Escreva um teste para validar que uma consulta de R$ 200 com 70% de cobertura resulta em R$ 140 de reembolso.
*/
package org.example;

public class CalculadoraReembolso {
    private static final double LIMITE_REEMBOLSO = 150.0;
    public double calcularReembolso(double valorConsulta, PlanoSaude percentualCobertura, Paciente paciente) {
        double reembolso = (valorConsulta * percentualCobertura.getPercentualCobertura()) / 100;
        // return valorConsulta * percentualCobertura / 100;
        return Math.min(reembolso, LIMITE_REEMBOLSO);
    }
}
