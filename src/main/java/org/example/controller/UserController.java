package org.example.controller;

import org.example.models.UserModel;
import org.example.services.UserServices;

public class UserController {
    private final UserServices userServices = new UserServices();

    public void cadastrarUsuario(String nome) {
        userServices.cadastrarUsuario(nome);
    }

    public void deletarUsuarioPorId(int id) {
        userServices.deletarUsuarioPorId(id);
    }

    public UserModel listarUsuarioPorNome(String nome) {
        return userServices.listarUsuarioPorNome(nome);
    }

    public void listarUsuarios() {
        userServices.listarUsuarios();
    }
}
