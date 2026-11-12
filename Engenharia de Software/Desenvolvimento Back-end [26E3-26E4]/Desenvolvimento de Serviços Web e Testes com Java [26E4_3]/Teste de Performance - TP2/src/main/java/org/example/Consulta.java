package org.example;

public class Consulta {
    private Paciente paciente; // Por enquanto a consulta só tem um dado para ser armazenado

    public Consulta(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente getPaciente() {
        return paciente;
    }
}