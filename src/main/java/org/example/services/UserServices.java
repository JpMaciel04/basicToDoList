package org.example.services;

import org.example.models.UserModel;
import org.example.repository.UserRepository;

public class UserServices {

    private final UserRepository userRepository = new UserRepository();

    public void cadastrarUsuario(String nome) {
        if (nome == null || nome.isEmpty() || nome.equalsIgnoreCase(" ")) {
            throw new IllegalArgumentException("Nome do usuário não pode ser vazio");
        }

        UserModel usuario = new UserModel(nome);
        userRepository.salvarUsuario(usuario);
    }

    public void deletarUsuarioPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Valores maiores ou igual a 1");
        }

        userRepository.deletarUsuarioPorId(id);
    }

    public UserModel listarUsuarioPorNome(String nome) {
        if (nome == null || nome.isEmpty() || nome.equalsIgnoreCase(" ")) {
            throw new IllegalArgumentException("Nome do usuário não pode ser vazio");
        }
        return userRepository.lerUsuarioPorNome(nome);
    }

    public void listarUsuarios() {
        userRepository.lerTodosUsuarios();
    }
}
