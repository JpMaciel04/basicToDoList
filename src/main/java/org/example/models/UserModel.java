package org.example.models;

public class UserModel {

    private int id ;
    private String nome;
    private static int cont = 0;

    private int gerarId(){
        return  cont++;
    }

    private void init ( String nome) {
        this.id = gerarId();
        this.nome = nome;
    }


    public UserModel(String nome){
        init(nome);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

}
