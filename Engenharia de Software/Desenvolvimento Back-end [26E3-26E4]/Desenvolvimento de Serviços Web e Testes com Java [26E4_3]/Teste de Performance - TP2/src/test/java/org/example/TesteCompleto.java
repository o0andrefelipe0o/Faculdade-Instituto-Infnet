/*
Etapa 12 - Integração com Vários Dublês
Agora combine todos os elementos em um teste mais completo. Use um stub para PlanoSaude, um mock para AutorizadorReembolso e o helper de criação de consultas. Simule um cenário completo e valide o funcionamento conjunto dos componentes.
*/
package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.MargemErro.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TesteCompleto {
    @Test
    @DisplayName("Deve calcular o reembolso considerando plano, autorização e teto")
    void completoAutorizado() {
        // Helper: cria uma consulta com um paciente fictício
        Consulta consulta = ConsultaHelper.criarConsulta();

        // Stub: plano de saúde com cobertura de 80%
        PlanoSaude planoSaude = new PlanoSaudeStub(80.0);

        // Mock: simula a autorização da consulta
        AutorizadorReembolso autorizador = mock(AutorizadorReembolso.class);
        when(autorizador.estaAutorizada(consulta)).thenReturn(true);

        // Instancia os componentes reais
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        ReembolsoService servico = new ReembolsoService(calculadora, autorizador);

        // Executa o cálculo
        double reembolso = servico.calcularReembolso(consulta, 250.0, planoSaude);

        // Verifica o valor do reembolso com a margem de erro de 0.01
        assertEqualsComMargemErro(150.0, reembolso);

        // Verifica se o autorizador foi consultado
        verify(autorizador).estaAutorizada(consulta);
    }

    @Test
    @DisplayName("Não deve calcular o reembolso quando a consulta não estiver autorizada")
    void completoNaoAutorizado() {
        // Helper: cria uma consulta com um paciente fictício
        Consulta consulta = ConsultaHelper.criarConsulta();

        // Stub: plano de saúde com cobertura de 80%
        PlanoSaude planoSaude = new PlanoSaudeStub(80.0);

        // Mock: simula a NÃO autorização da consulta
        AutorizadorReembolso autorizador = mock(AutorizadorReembolso.class);
        when(autorizador.estaAutorizada(consulta)).thenReturn(false);

        // Instancia os componentes reais
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        ReembolsoService servico = new ReembolsoService(calculadora, autorizador);

        assertThrows(IllegalStateException.class, () -> servico.calcularReembolso(consulta, 250.0, planoSaude));

        // Verifica se o autorizador foi consultado
        verify(autorizador).estaAutorizada(consulta);

        verifyNoMoreInteractions(autorizador);
    }
}
