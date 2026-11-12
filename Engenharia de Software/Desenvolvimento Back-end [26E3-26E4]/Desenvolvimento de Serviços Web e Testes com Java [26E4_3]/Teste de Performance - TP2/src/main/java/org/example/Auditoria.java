/*
Etapa 7 - Spy para Auditoria
Agora queremos garantir que o sistema está chamando o serviço de auditoria ao registrar uma consulta. Crie uma interface Auditoria e implemente um spy que registra se o método registrarConsulta() foi chamado durante os testes.
*/
package org.example;

public interface Auditoria {
    void registrarConsulta(Consulta consulta); // Será necessário criar uma classe responsável por coordenar o registro de consultas RegistroConsultaService.java
}
