package org.example.repository;

import org.example.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final List<UserModel> bancoFalso = new ArrayList<>();

    public void salvarUsuario(UserModel usuario) {
        bancoFalso.add(usuario);
    }

    public void lerTodosUsuarios() {
        for (UserModel usuario : bancoFalso) {
            System.out.println(usuario.toString());
        }
    }

    public UserModel lerUsuarioPorNome(String nome) {
        for (UserModel usuario : bancoFalso) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }
        return null;
    }

    public void deletarUsuarioPorId(int id) {
        for (int i = 0; i < bancoFalso.size(); i++) {
            if (bancoFalso.get(i).getId() == id) {
                bancoFalso.remove(i);
                return;
            }
        }
    }
}
