package org.example.repository;

import org.example.models.EnumStatus;
import org.example.models.TaskModel;
import org.example.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private final List<TaskModel> bancoFalso = new ArrayList<>();

    public void salvarTarefa(TaskModel tarefa) {
        bancoFalso.add(tarefa);
    }

    public List<TaskModel> listarTodasTarefas() {
        return new ArrayList<>(bancoFalso);
    }

    public TaskModel tarefaPorId(int id) {
        for (TaskModel tarefa : bancoFalso) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }
        return null;
    }

    public List<TaskModel> listarTarefasPorStatus(EnumStatus status) {
        List<TaskModel> tarefas = new ArrayList<>();
        for (TaskModel tarefa : bancoFalso) {
            if (tarefa.getStatus() == status) {
                tarefas.add(tarefa);
            }
        }
        return tarefas;
    }

    public int qtdDeTarefasPorUsuarioEStatus(UserModel usuario, EnumStatus status) {
        int qtd = 0;
        for (TaskModel tarefa : bancoFalso) {
            if (tarefa.getUsuario().equals(usuario) && tarefa.getStatus() == status) {
                qtd++;
            }
        }
        return qtd;
    }

    public void deletarTarefaPorId(int id) {
        for (int i = 0; i < bancoFalso.size(); i++) {
            if (bancoFalso.get(i).getId() == id) {
                bancoFalso.remove(i);
                return;
            }
        }
    }

    public void alterarStatus(TaskModel tarefa, EnumStatus status) {
        tarefa.setStatus(status);
    }

    public void alterarDescricao(TaskModel tarefa, String descricao) {
        tarefa.setDescricao(descricao);
    }
}
