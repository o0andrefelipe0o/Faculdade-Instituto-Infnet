/*
Etapa 6 - Stub de Plano de Saúde
Implemente uma interface PlanoSaude com um método que retorna o percentual de cobertura. Nos testes, crie stubs para simular diferentes planos com percentuais fixos, como 50% ou 80%, e garanta que o cálculo responda corretamente.
*/
package org.example;

public class PlanoSaudeStub implements PlanoSaude {
    private double percentualCobertura;

    public PlanoSaudeStub(double percentualCobertura) {
        this.percentualCobertura = percentualCobertura;
    }

    @Override
    public double getPercentualCobertura() {
        return percentualCobertura;
    }
}
