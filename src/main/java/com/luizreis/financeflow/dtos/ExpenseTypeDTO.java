package com.luizreis.financeflow.dtos;

import com.luizreis.financeflow.entities.ExpenseType;

public class ExpenseTypeDTO {

    private Long id;
    private String name;

    public ExpenseTypeDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ExpenseTypeDTO(ExpenseType entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
