package com.biojj.helpregistration.domain.enums;

import lombok.Getter;

@Getter
public enum Priority {
    BAIXA(0,"BAIXA"), MEDIA(1,"MÉDIA"), ALTA(2,"ALTA");

    private final Integer code;
    private final String description;

    Priority(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public  static Priority toEnum(Integer cod){
        if(cod == null) {
            return null;
        }
        for(Priority x : Priority.values()){
            if(cod.equals(x.getCode())){
                return x;
            }
        }
        throw new IllegalAccessError("Prioridade Invalida");
    }
}