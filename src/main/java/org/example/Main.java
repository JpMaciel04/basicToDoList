package org.example;

import org.example.controller.TaskController;
import org.example.controller.UserController;
import org.example.models.EnumStatus;
import org.example.models.TaskModel;
import org.example.models.UserModel;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UserController userController = new UserController();
        TaskController taskController = new TaskController();

        cabecalho();
        menu(userController, taskController);
    }



    private static void menu(UserController userController, TaskController taskController) {
        while (true) {
            listarOpcoes();
            int option = lerInt("Escolha uma opção: ");
            System.out.println();

            
                switch (option) {
                    case 1 -> cadastrarUsuario(userController);
                    case 2 -> listarUsuarios(userController);
                    case 3 -> cadastrarTarefa(userController, taskController);
                    case 4 -> listarTodasTarefas(taskController);
                    case 5 -> listarTarefasPorStatus(taskController);
                    case 6 -> alterarStatusTarefa(taskController);
                    case 7 -> alterarDescricaoTarefa(taskController);
                    case 8 -> deletarTarefa(taskController);
                    case 0 -> {
                        conclusao();
                        return;
                    }
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            
            pausar();
        }
    }

    private static void cabecalho() {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                   🚀  BÁSICO TO-DO LIST  🚀                   ║");
        System.out.println("╠════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Bem-vindo ao seu gerenciador simples de tarefas!              ║");
        System.out.println("║ Você pode criar usuários, adicionar tarefas e atualizar status.║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");
    }

    private static void listarOpcoes() {
        System.out.println("========= MENU PRINCIPAL =========");
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Listar usuários");
        System.out.println("3 - Cadastrar tarefa");
        System.out.println("4 - Listar todas as tarefas");
        System.out.println("5 - Listar tarefas por status");
        System.out.println("6 - Alterar status de tarefa");
        System.out.println("7 - Alterar descrição de tarefa");
        System.out.println("8 - Excluir tarefa");
        System.out.println("0 - Sair");
        System.out.println("===================================");
    }

    private static void cadastrarUsuario(UserController userController) {
        String nome = lerLinha("Nome do usuário: ");
        userController.cadastrarUsuario(nome);
    }

    private static void listarUsuarios(UserController userController) {
        System.out.println("\nUsuários cadastrados:");
        userController.listarUsuarios();
    }

    private static void cadastrarTarefa(UserController userController, TaskController taskController) {
        String nomeUsuario = lerLinha("Nome do usuário responsável: ");
        UserModel usuario = userController.listarUsuarioPorNome(nomeUsuario);

        String descricao = lerLinha("Descrição da tarefa: ");
        taskController.cadastrarTarefa(descricao, usuario);
    }

    private static void listarTodasTarefas(TaskController taskController) {
        System.out.println("\nTodas as tarefas:");
        imprimirTarefas(taskController.listarTarefas());
    }

    private static void listarTarefasPorStatus(TaskController taskController) {
        EnumStatus status = escolherStatus();
        System.out.println("\nTarefas com status: " + status);
        imprimirTarefas(taskController.listarTarefasPorStatus(status));
    }

    private static void alterarStatusTarefa(TaskController taskController) {
        int tarefaId = lerInt("ID da tarefa: ");
        TaskModel tarefa = taskController.listarTarefaPorId(tarefaId);
        
        EnumStatus status = escolherStatus();
        taskController.alterarStatusTarefa(tarefa, status);
    }

    private static void alterarDescricaoTarefa(TaskController taskController) {
        int tarefaId = lerInt("ID da tarefa: ");
        TaskModel tarefa = taskController.listarTarefaPorId(tarefaId);
       

        String descricao = lerLinha("Nova descrição: ");
        taskController.alterarDescricaoTarefa(tarefa, descricao);
    }

    private static void deletarTarefa(TaskController taskController) {
        int tarefaId = lerInt("ID da tarefa: ");
        taskController.deletarTarefaPorId(tarefaId);
    }

    private static void imprimirTarefas(List<TaskModel> tarefas) {
        
        cabecalhoTarefas();
        for (TaskModel tarefa : tarefas) {
            System.out.printf("%-4d | %-28s | %-12s | %-10s | %-10s%n",
                    tarefa.getId(), formatarDescricao(tarefa.getDescricao()), tarefa.getUsuario().getNome(), tarefa.getDataDeCriacao(), tarefa.getStatus());
        }
    }

    private static void cabecalhoTarefas() {
        System.out.println("ID   | Descrição                    | Usuário      | Criado     | Status    ");
        System.out.println("-----+------------------------------+--------------+------------+-----------");
    }

    private static String formatarDescricao(String text) {
        if (text == null) {
            return "";
        }
        return text.length() > 28 ? text.substring(0, 25) + "..." : text;
    }

    private static EnumStatus escolherStatus() {
        System.out.println("Escolha o status:");
        for (EnumStatus status : EnumStatus.values()) {
            System.out.printf("%d - %s%n", status.getCodigo(), status);
        }

        int statusCode = lerInt("Status (número): ");
        EnumStatus status = EnumStatus.fromCodigo(statusCode);
        if (status == null) {
            throw new IllegalArgumentException("Status inválido.");
        }
        return status;
    }

    private static int lerInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = scanner.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.println("Entrada inválida. Digite um número válido.");
            }
        }
    }

    private static String lerLinha(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static void pausar() {
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void conclusao() {
        System.out.println("\nObrigado por usar o Básico To-Do List. Até a próxima! ");
    }
}