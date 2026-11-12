package org.example;

public class RegistroConsultaService {
    private HistoricoConsultas historico;
    private Auditoria auditoria;

    public RegistroConsultaService(HistoricoConsultas historico, Auditoria auditoria) {
        this.historico = historico;
        this.auditoria = auditoria;
    }

    public void registrarConsulta(Consulta consulta) {
        historico.adicionarConsulta(consulta);
        auditoria.registrarConsulta(consulta);
    }
}
