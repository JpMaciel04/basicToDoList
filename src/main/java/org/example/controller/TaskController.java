package org.example.controller;

import java.util.List;

import org.example.models.EnumStatus;
import org.example.models.TaskModel;
import org.example.models.UserModel;
import org.example.services.TaskServices;

public class TaskController {
    private final TaskServices taskServices = new TaskServices();

    public void cadastrarTarefa(String descricao, UserModel usuario) {
        taskServices.cadastrarTarefa(descricao, usuario);
    }

    public void deletarTarefaPorId(int id) {
        taskServices.deletarTarefaPorId(id);
    }

    public List<TaskModel> listarTarefas() {
        return taskServices.listarTarefas();
    }

    public TaskModel listarTarefaPorId(int id) {
        return taskServices.listarTarefaPorId(id);
    }

    public List<TaskModel> listarTarefasPorStatus(EnumStatus status) {
        return taskServices.listarTarefasPorStatus(status);
    }

    public void alterarStatusTarefa(TaskModel tarefa, EnumStatus status) {
        taskServices.alterarStatusTarefa(tarefa, status);
    }

    public void alterarDescricaoTarefa(TaskModel tarefa, String descricao) {
        taskServices.alterarDescricaoTarefa(tarefa, descricao);
    }
}
