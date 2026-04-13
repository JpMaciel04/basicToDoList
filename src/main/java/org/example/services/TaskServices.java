package org.example.services;

import org.example.models.EnumStatus;
import org.example.models.TaskModel;
import org.example.models.UserModel;
import org.example.repository.TaskRepository;

import java.util.List;

public class TaskServices {
    private final TaskRepository taskRepository = new TaskRepository();

    public void cadastrarTarefa(String descricao, UserModel usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Para criar tarefa é necessário selecionar um usuário");
        }
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia");
        }

        int qtdDeTarefasPendentes = taskRepository.qtdDeTarefasPorUsuarioEStatus(usuario, EnumStatus.PENDENTE);

        if (qtdDeTarefasPendentes >= 5) {
            throw new IllegalArgumentException("Usuário já atingiu o limite de tarefas pendentes");
        }

        TaskModel tarefa = new TaskModel(descricao, usuario, EnumStatus.PENDENTE);
        taskRepository.salvarTarefa(tarefa);
    }

    public void deletarTarefaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Valores maiores ou igual a 1");
        }

        TaskModel excluido = taskRepository.tarefaPorId(id);
        if (excluido == null) {
            throw new IllegalArgumentException("Tarefa não encontrada");
        }
        if (excluido.getStatus() == EnumStatus.FINALIZADO) {
            throw new IllegalArgumentException("Não é possivel excluir tarefa já finalizada");
        }

        taskRepository.deletarTarefaPorId(id);
    }

    public List<TaskModel> listarTarefas() {
        return taskRepository.listarTodasTarefas();
    }

    public TaskModel listarTarefaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Valores maiores ou igual a 1");
        }

        TaskModel tarefa = taskRepository.tarefaPorId(id);
        if (tarefa == null) {
            throw new IllegalArgumentException("Usuário criador da tarefa não existe");
        }
        return tarefa;
    }

    public List<TaskModel> listarTarefasPorStatus(EnumStatus status) {
        return taskRepository.listarTarefasPorStatus(status);
    }

    public void alterarStatusTarefa(TaskModel tarefa, EnumStatus status) {
        if (tarefa == null) {
            throw new IllegalArgumentException("Tarefa não encontrada");
        }
        if (tarefa.getStatus() == EnumStatus.FINALIZADO) {
            throw new IllegalArgumentException("Tarefa já foi finalizada");
        }
        taskRepository.alterarStatus(tarefa, status);
    }

    public void alterarDescricaoTarefa(TaskModel tarefa, String descricao) {
        if (tarefa == null) {
            throw new IllegalArgumentException("Tarefa não encontrada");
        }
        if (tarefa.getStatus() == EnumStatus.FINALIZADO) {
            throw new IllegalArgumentException("Tarefa já foi finalizada");
        }
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia");
        }
        taskRepository.alterarDescricao(tarefa, descricao);
    }
}
