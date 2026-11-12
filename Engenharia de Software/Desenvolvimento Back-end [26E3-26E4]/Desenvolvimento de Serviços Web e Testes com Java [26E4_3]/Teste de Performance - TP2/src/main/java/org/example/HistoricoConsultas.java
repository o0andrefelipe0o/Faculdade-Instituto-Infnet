/*
Etapa 5 - Fake para Histórico de Consultas
Vamos simular o armazenamento de consultas anteriores com uma estrutura simples em memória. Crie uma interface HistoricoConsultas e uma versão fake que guarde os dados em uma lista, permitindo consultar depois. Isso ajuda a testar sem depender de banco de dados real.
*/
package org.example;

import java.util.List;

public interface HistoricoConsultas {

    void adicionarConsulta(Consulta consulta); // Pra ter um histórico de consultas tem que ter a consulta, por conta disso criei Consulta.java

    List<Consulta> listarConsultas();
}
