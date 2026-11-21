package org.example.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Turma {
    private final List<org.example.models.Turma> turmas = new ArrayList<>();

    public void adicionar(org.example.models.Turma turma) {
        turmas.add(turma);
    }

    public List<org.example.models.Turma> listarTodos() {
        return Collections.unmodifiableList(new ArrayList<>(turmas));
    }

    public Optional<org.example.models.Turma> buscarPorId(int idTurma) {
        return turmas.stream()
                .filter(turma -> turma.getIdTurma() == idTurma)
                .findFirst();
    }

    public void atualizar(org.example.models.Turma turmaAtualizada) {
        for (int i = 0; i < turmas.size(); i++) {
            if (turmas.get(i).getIdTurma() == turmaAtualizada.getIdTurma()) {
                turmas.set(i, turmaAtualizada);
                return;
            }
        }

        throw new IllegalArgumentException("Turma não encontrada.");
    }

    public void remover(int idTurma) {
        boolean removida = turmas.removeIf(
                turma -> turma.getIdTurma() == idTurma
        );

        if (!removida) {
            throw new IllegalArgumentException("Turma não encontrada.");
        }
    }
}