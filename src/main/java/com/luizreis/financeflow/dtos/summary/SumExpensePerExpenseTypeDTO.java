package com.luizreis.financeflow.dtos.summary;

public class SumExpensePerExpenseTypeDTO {

    private Double value;
    private String expenseType;

    public SumExpensePerExpenseTypeDTO(Double value, String expenseType) {
        this.value = value;
        this.expenseType = expenseType;
    }

    public Double getValue() {
        return value;
    }

    public String getExpenseType() {
        return expenseType;
    }
}
