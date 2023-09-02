package com.luizreis.financeflow.dtos;

public class OperationTypeDTO {

    private Long id;
    private String name;

    public OperationTypeDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
