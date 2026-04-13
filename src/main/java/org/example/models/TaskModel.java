package org.example.models;

import java.time.LocalDate;

public class TaskModel {

    private static int ultimo = 0;
    private int id;
    private String desc;
    private UserModel user;
    private LocalDate dataDeCriacao;
    private EnumStatus status;


    private int gerarId(){
        return ultimo++;
    }

    private void init (String desc, UserModel user, EnumStatus status){
        this.id = gerarId();
        this.desc = desc;
        this.user = user;
        this.dataDeCriacao = LocalDate.now();
        this.status=status;
    }

    public TaskModel(String desc, UserModel user, EnumStatus status ) {
        init(desc,user,status);
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return desc;
    }

    public void setDescricao(String descricao) {
        this.desc = descricao;
    }

    public UserModel getUsuario() {
        return user;
    }

    public void setUsuario(UserModel usuario) {
        this.user = usuario;
    }

    public LocalDate getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDate dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", user=" + user.getNome() +
                ", dataDeCriacao=" + dataDeCriacao +
                ", status=" + status +
                '}';
    }


}
