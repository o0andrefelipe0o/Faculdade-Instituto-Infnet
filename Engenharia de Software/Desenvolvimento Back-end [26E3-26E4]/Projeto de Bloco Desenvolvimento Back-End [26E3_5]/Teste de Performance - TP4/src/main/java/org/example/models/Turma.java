package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Turma {

    private final int idTurma;
    private String nome;
    private final List<Aluno> alunos;
    private boolean aberta;

    public Turma(int idTurma, String nome) {
        this.idTurma = idTurma;
        this.nome = nome;
        this.alunos = new ArrayList<>();
        this.aberta = false;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getAlunos() {
        return Collections.unmodifiableList(alunos);
    }

    public boolean isAberta() {
        return aberta;
    }

    public void matricular(Aluno aluno) {
        alunos.add(aluno);
    }

    public void abrir() {
        aberta = true;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "idTurma=" + idTurma +
                ", nome='" + nome + '\'' +
                ", quantidadeAlunos=" + alunos.size() +
                ", aberta=" + aberta +
                '}';
    }
}