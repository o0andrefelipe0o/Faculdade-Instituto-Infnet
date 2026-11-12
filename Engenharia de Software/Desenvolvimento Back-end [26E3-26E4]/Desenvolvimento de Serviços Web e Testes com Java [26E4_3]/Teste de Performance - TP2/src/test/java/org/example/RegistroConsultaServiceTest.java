package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroConsultaServiceTest {
    @Test
    @DisplayName("Deve chamar a auditoria ao registrar uma consulta")
    void chamarAuditoria() {
        HistoricoConsultas historico = new HistoricoConsultasFake();
        AuditoriaSpy auditoriaSpy = new AuditoriaSpy();
        RegistroConsultaService servico = new RegistroConsultaService(historico, auditoriaSpy);
        Consulta consulta = ConsultaHelper.criarConsulta();
        servico.registrarConsulta(consulta);
        assertEquals(auditoriaSpy.foiChamado(), true);
    }
}
