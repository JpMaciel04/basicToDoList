package org.example.models;

public enum EnumStatus {
    PENDENTE(1),
    FAZENDO(2),
    FINALIZADO(3);

    private final int codigo;

    EnumStatus(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static EnumStatus fromCodigo(int codigo) {
        for (EnumStatus status : values()) {
            if (status.codigo == codigo) {
                return status;
            }
        }
        return null;
    }
}
