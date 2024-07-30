package com.biojj.helpregistration.domain.enums;

import lombok.Getter;

@Getter
public enum Status {
    ABERTO(0,"ABERTO"), ANDAMENTO(1,"ANDAMENTO"), ENCERRADO(2,"ENCERRADO");

    private final Integer code;
    private final String description;

    Status(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public  static Status toEnum(Integer cod){
        if(cod == null) {
            return null;
        }
        for(Status x : Status.values()){
            if(cod.equals(x.getCode())){
                return x;
            }
        }
        throw new IllegalAccessError("Status Invalido");
    }
}
