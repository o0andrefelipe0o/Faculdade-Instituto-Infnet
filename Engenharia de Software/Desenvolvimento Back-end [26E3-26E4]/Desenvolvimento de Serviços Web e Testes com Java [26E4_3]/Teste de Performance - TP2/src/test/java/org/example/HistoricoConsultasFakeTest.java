/*
Etapa 5 - Fake para Histórico de Consultas
Vamos simular o armazenamento de consultas anteriores com uma estrutura simples em memória. Crie uma interface HistoricoConsultas e uma versão fake que guarde os dados em uma lista, permitindo consultar depois. Isso ajuda a testar sem depender de banco de dados real.
*/
package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistoricoConsultasFakeTest {
    @Test
    @DisplayName("Deve retornar uma lista vazia quando não houver consultas")
    void listaVazia() {
        HistoricoConsultas historico = new HistoricoConsultasFake();
        List<Consulta> consultas = historico.listarConsultas();
        assertTrue(consultas.isEmpty());
    }

    @Test
    @DisplayName("Deve adicionar duas consultas ao histórico")
    void adicionarConsultas() {
        HistoricoConsultas historico = new HistoricoConsultasFake();
        Consulta consulta1 = ConsultaHelper.criarConsulta();
        Consulta consulta2 = ConsultaHelper.criarConsulta();
        historico.adicionarConsulta(consulta1);
        historico.adicionarConsulta(consulta2);
        List<Consulta> consultas = historico.listarConsultas();
        assertEquals(2, consultas.size());
	    /*
        assertSame(consulta1, consultas.get(0));
        assertSame(consulta2, consultas.get(1));
	    */
    }
}
