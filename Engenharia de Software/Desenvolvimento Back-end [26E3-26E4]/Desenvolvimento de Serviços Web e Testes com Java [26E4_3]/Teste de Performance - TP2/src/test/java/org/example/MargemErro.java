/*
Etapa 10 - Comparação com Margem de Erro
Testes com números decimais podem falhar por pequenas diferenças. Crie uma função de apoio que compare dois valores com margem de erro de 0.01. Substitua as comparações diretas por essa função nos testes relevantes.
*/
package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MargemErro {
    public static void assertEqualsComMargemErro(double esperado, double atual) {
        assertEquals(esperado, atual, 0.01);
    }
}