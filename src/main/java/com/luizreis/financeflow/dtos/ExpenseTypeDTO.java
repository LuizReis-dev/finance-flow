package com.luizreis.financeflow.dtos;

public class ExpenseTypeDTO {

    private Long id;
    private String name;

    public ExpenseTypeDTO(Long id, String name) {
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
