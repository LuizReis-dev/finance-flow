package com.luizreis.financeflow.dtos.expense;

import java.time.Instant;
import java.util.Date;

public class ExpenseCreatedDTO {

    private Long id;
    private Double value;
    private String expenseType;
    private String description;
    private Date registeredAt;

    public ExpenseCreatedDTO(Long id, Double value, String expenseType, String description, Date registeredAt) {
        this.id = id;
        this.value = value;
        this.expenseType = expenseType;
        this.description = description;
        this.registeredAt = registeredAt;
    }

    public Long getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public String getDescription() {
        return description;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }
}
