/*
Etapa 9 - Helper para Criação de Consultas
Comece a criar um método auxiliar para gerar objetos Consulta com dados padrão. Isso vai evitar repetição de código nos testes. Aplique esse helper em pelo menos três testes já feitos.
*/
package org.example;

public class ConsultaHelper {
    public static Consulta criarConsulta() {
        return new Consulta(new Paciente());
    }
}