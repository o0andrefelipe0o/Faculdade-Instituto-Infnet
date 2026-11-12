/*
Etapa 7 - Spy para Auditoria
Agora queremos garantir que o sistema está chamando o serviço de auditoria ao registrar uma consulta. Crie uma interface Auditoria e implemente um spy que registra se o método registrarConsulta() foi chamado durante os testes.
*/
package org.example;

public class AuditoriaSpy implements Auditoria {
    private boolean chamado = false;
    private Consulta consultaRegistrada;

    @Override
    public void registrarConsulta(Consulta consulta) {
        chamado = true;
        consultaRegistrada = consulta;
    }

    public boolean foiChamado() {
        return chamado;
    }

    public Consulta getConsultaRegistrada() {
        return consultaRegistrada;
    }
}
