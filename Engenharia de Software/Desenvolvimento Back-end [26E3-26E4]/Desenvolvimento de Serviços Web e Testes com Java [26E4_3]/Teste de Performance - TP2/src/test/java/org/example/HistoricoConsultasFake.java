/*
Etapa 5 - Fake para Histórico de Consultas
Vamos simular o armazenamento de consultas anteriores com uma estrutura simples em memória. Crie uma interface HistoricoConsultas e uma versão fake que guarde os dados em uma lista, permitindo consultar depois. Isso ajuda a testar sem depender de banco de dados real.
*/
package org.example;

import java.util.ArrayList;
import java.util.List;

public class HistoricoConsultasFake implements HistoricoConsultas {
    private List<Consulta> consultas = new ArrayList<>();

    @Override
    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    @Override
    public List<Consulta> listarConsultas() {
        return new ArrayList<>(consultas);
    }
}
