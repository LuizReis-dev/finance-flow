package com.luizreis.financeflow.dtos.expense;

import java.time.Instant;

public class ExpenseDTO {

    private Long id;
    private Double value;
    private Long expenseTypeId;
    private String description;
    private Instant registeredAt;

    public ExpenseDTO(Long id, Double value, Long expenseTypeId, String description, Instant registeredAt) {
        this.id = id;
        this.value = value;
        this.expenseTypeId = expenseTypeId;
        this.description = description;
        this.registeredAt = registeredAt;
    }

    public Double getValue() {
        return value;
    }

    public Long getExpenseTypeId() {
        return expenseTypeId;
    }

    public String getDescription() {
        return description;
    }

    public Instant getRegisteredAt() {
        return registeredAt;
    }
}
