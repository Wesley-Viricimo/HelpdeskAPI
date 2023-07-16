package org.example.domain.enums;

public enum Status {

    //Enumerador com tipos de status das ordens de serviço
    ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");

    private Integer codigo;
    private String descricao;

    private Status(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Status toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(Status status : Status.values()) {
            if(cod.equals(status.getCodigo())) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status Inválido!");
    }

}
