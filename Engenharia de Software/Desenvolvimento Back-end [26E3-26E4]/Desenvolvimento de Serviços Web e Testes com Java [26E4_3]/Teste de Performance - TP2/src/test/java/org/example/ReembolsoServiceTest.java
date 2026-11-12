package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReembolsoServiceTest {
    @Test
    @DisplayName("Deve calcular o reembolso quando a consulta estiver autorizada")
    void consultaAutorizada() {
        Consulta consulta = ConsultaHelper.criarConsulta();
        AutorizadorReembolso autorizador = mock(AutorizadorReembolso.class);
        when(autorizador.estaAutorizada(consulta)).thenReturn(true);
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        ReembolsoService servico = new ReembolsoService(calculadora, autorizador);
        PlanoSaude planoSaude = new PlanoSaudeStub(70.0);
        double reembolso = servico.calcularReembolso(consulta, 200.0, planoSaude);
        MargemErro.assertEqualsComMargemErro(140.0, reembolso);
        verify(autorizador).estaAutorizada(consulta);
    }

    @Test
    @DisplayName("Deve lançar exceção quando a consulta não estiver autorizada")
    void consultaNaoAutorizada() {
        Consulta consulta = ConsultaHelper.criarConsulta();
        AutorizadorReembolso autorizador = mock(AutorizadorReembolso.class);
        when(autorizador.estaAutorizada(consulta)).thenReturn(false);
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        ReembolsoService servico = new ReembolsoService(calculadora, autorizador);
        PlanoSaude planoSaude = new PlanoSaudeStub(70.0);
        assertThrows(IllegalStateException.class, () -> servico.calcularReembolso(consulta, 200.0, planoSaude));
        verify(autorizador).estaAutorizada(consulta);
    }
}
