package org.example.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Aluno {
    private final List<org.example.models.Aluno> alunos = new ArrayList<>();

    public void adicionar(org.example.models.Aluno aluno) {
        alunos.add(aluno);
    }

    public List<org.example.models.Aluno> listarTodos() {
        return Collections.unmodifiableList(new ArrayList<>(alunos));
    }

    public Optional<org.example.models.Aluno> buscarPorId(int idAluno) {
        return alunos.stream()
                .filter(aluno -> aluno.getIdAluno() == idAluno)
                .findFirst();
    }

    public void atualizar(org.example.models.Aluno alunoAtualizado) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getIdAluno() == alunoAtualizado.getIdAluno()) {
                alunos.set(i, alunoAtualizado);
                return;
            }
        }

        throw new IllegalArgumentException("Aluno não encontrado.");
    }

    public void remover(int idAluno) {
        boolean removido = alunos.removeIf(
                aluno -> aluno.getIdAluno() == idAluno
        );

        if (!removido) {
            throw new IllegalArgumentException("Aluno não encontrado.");
        }
    }
}