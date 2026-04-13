# Basic To-Do List

O **To-Do List** é um sistema de gerenciamento de tarefas desenvolvido em **Java puro**, com foco na aplicação prática de conceitos fundamentais de desenvolvimento backend, como **CRUD**, **separação de responsabilidades** e **arquitetura em camadas (Layered Architecture)**.

O projeto simula o funcionamento de um sistema real, organizando o código em diferentes camadas, onde cada uma possui uma responsabilidade bem definida:

- **Controller**: responsável por receber as interações do usuário (menu)
- **Service**: onde ficam as regras de negócio e validações
- **Repository**: responsável pela persistência de dados (em memória)
- **Model**: representa as entidades do sistema

Essa abordagem permite um código mais **organizado, escalável e fácil de manter**, além de aproximar a aplicação de padrões utilizados no mercado com frameworks como Spring Boot.

O sistema permite o gerenciamento de usuários e tarefas, incluindo criação, listagem, atualização e remoção, além de aplicar regras de negócio. 

## 🌟 O que este projeto faz

- Cadastra usuários
- Lista usuários cadastrados
- Cadastra tarefas vinculadas a usuários
- Lista todas as tarefas
- Filtra tarefas por status (Pendente, Em andamento, Finalizado)
- Atualiza o status de uma tarefa
- Atualiza a descrição de uma tarefa
- Remove tarefas pendentes e em andamento



## 🧭 Menu interativo

A aplicação abre o terminal com as seguintes opções:

- Cadastrar usuário
- Listar usuários
- Cadastrar tarefa
- Listar todas as tarefas
- Listar tarefas por status
- Alterar status de tarefa
- Alterar descrição de tarefa
- Excluir tarefa

## 🧩 Estrutura do projeto

- `src/main/java/org/example/Main.java` — ponto de entrada e menu interativo
- `src/main/java/org/example/controller/` — controladores que fazem a ponte entre o menu e os serviços
- `src/main/java/org/example/services/` — regras de negócio e validações
- `src/main/java/org/example/repository/` — armazenamento temporário em memória
- `src/main/java/org/example/models/` — classes de modelo de usuário, tarefa e status

## 💡 Regras de negócios aplicadas


- O nome do usuário não pode ser vazio.
- A tarefa é sempre criada com o status **Pendente**.
- Cada usuário só pode ter até 5 tarefas com status **Pendente**.
- Não é permitido cadastrar tarefa sem usuário responsável.
- Tarefas com status **Finalizado** não podem ser excluídas.
- Tarefas com status **Finalizado** não podem ter a descrição alterada.
- Ao alterar status ou descrição, a tarefa deve existir e não estar finalizada.



