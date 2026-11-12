package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraReembolsoTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /*
    Etapa 1 - Reembolso Básico
    Você começará implementando a função mais simples do sistema: calcular o valor a ser reembolsado com base em um valor fixo e percentual de cobertura. Escreva um teste para validar que uma consulta de R$ 200 com 70% de cobertura resulta em R$ 140 de reembolso.
    */
    @Test
    @DisplayName("Deve validar que uma consulta de R$ 200 com 70% de cobertura resulta em R$ 140 de reembolso")
    void consulta200Cobertura70reembolso140() {
        Paciente paciente = new Paciente();
        PlanoSaude percentualCobertura = new PlanoSaudeStub(70.0);
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        double reembolso = calculadora.calcularReembolso(200.0, percentualCobertura, paciente);
        MargemErro.assertEqualsComMargemErro(140.0, reembolso);
    }

    /*
    Etapa 2 - Casos de Borda
    Agora vamos testar se o sistema responde corretamente a situações limites. Teste casos em que o valor da consulta ou o percentual de cobertura sejam iguais a 0 ou 100. Isso ajuda a validar o comportamento básico da função.
    */
    @Test
    @DisplayName("Deve validar que uma consulta de R$ 0 com qualquer porcentagem de cobertura resulta em R$ 0 de reembolso")
    void consulta0() {
        Paciente paciente = new Paciente();
        PlanoSaude percentualCobertura = new PlanoSaudeStub(70.0);
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        double reembolso = calculadora.calcularReembolso(0.0, percentualCobertura, paciente);
        MargemErro.assertEqualsComMargemErro(0.0, reembolso);
    }

    @Test
    @DisplayName("Deve validar que uma consulta de qualquer valor em real com 0% de cobertura resulta em R$ 0 de reembolso")
    void cobertura0() {
        Paciente paciente = new Paciente();
        PlanoSaude percentualCobertura = new PlanoSaudeStub(0.0);
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        double reembolso = calculadora.calcularReembolso(200.0, percentualCobertura, paciente);
        MargemErro.assertEqualsComMargemErro(0.0, reembolso);
    }

    @Test
    @DisplayName("Deve validar que uma consulta de qualquer valor em real com 100% de cobertura resulta no mesmo valor da consulta para o reembolso")
    void consulta100() {
        Paciente paciente = new Paciente();
        PlanoSaude percentualCobertura = new PlanoSaudeStub(70.0);
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        double reembolso = calculadora.calcularReembolso(100.0, percentualCobertura, paciente);
        MargemErro.assertEqualsComMargemErro(70.0, reembolso);
    }

    @Test
    @DisplayName("Deve retornar o valor integral da consulta quando a cobertura for de 100%")
    void cobertura100() {
        Paciente paciente = new Paciente();
        PlanoSaude percentualCobertura = new PlanoSaudeStub(100.0);
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        double reembolso = calculadora.calcularReembolso(100.0, percentualCobertura, paciente);
        MargemErro.assertEqualsComMargemErro(100.0, reembolso);
    }

    /*
    Etapa 11 - Regras de Teto
    A empresa decidiu que o valor máximo de reembolso será R$ 150 por consulta. Antes de programar, escreva testes que validem esse limite. Depois, ajuste a lógica para garantir esse comportamento.
    */
    @Test
    @DisplayName("Deve limitar o reembolso a R$ 150 quando o cálculo ultrapassar esse valor")
    void reembolsoMaiorTeto151De150() {
        Consulta consulta = ConsultaHelper.criarConsulta();
        PlanoSaude planoSaude = new PlanoSaudeStub(100.0);
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        double reembolso = calculadora.calcularReembolso(151.0, planoSaude, consulta.getPaciente());
        MargemErro.assertEqualsComMargemErro(150.0, reembolso);
    }

    @Test
    @DisplayName("Deve manter o reembolso quando o cálculo resultar exatamente em R$ 150")
    void reembolsoIgualTeto150De150() {
        Consulta consulta = ConsultaHelper.criarConsulta();
        PlanoSaude planoSaude = new PlanoSaudeStub(100.0);
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        double reembolso = calculadora.calcularReembolso(150.0, planoSaude, consulta.getPaciente());
        MargemErro.assertEqualsComMargemErro(150.0, reembolso);
    }

    @Test
    @DisplayName("Deve manter o valor calculado quando o reembolso for inferior a R$ 150")
    void reembolsoMenorTeto149De150() {
        Consulta consulta = ConsultaHelper.criarConsulta();
        PlanoSaude planoSaude = new PlanoSaudeStub(100.0);
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        double reembolso = calculadora.calcularReembolso(149.0, planoSaude, consulta.getPaciente());
        MargemErro.assertEqualsComMargemErro(149.0, reembolso);
    }
}
