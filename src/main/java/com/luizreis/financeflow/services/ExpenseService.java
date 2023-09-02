package com.luizreis.financeflow.services;

import com.luizreis.financeflow.dtos.expense.ExpenseDTO;
import com.luizreis.financeflow.entities.Expense;
import com.luizreis.financeflow.entities.ExpenseType;
import com.luizreis.financeflow.repositories.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ExpenseService {

    private ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public ExpenseDTO insert(ExpenseDTO dto){
        ExpenseType type = new ExpenseType();
        type.setId(dto.getExpenseTypeId());

        Expense expense = new Expense();
        expense.setValue(dto.getValue());
        expense.setDescription(dto.getText());
        expense.setRegisteredAt(dto.getRegisteredAt());
        expense.setOperationType(type);

        Expense insertedExpense = repository.save(expense);
        return new ExpenseDTO(insertedExpense.getId(), insertedExpense.getValue(), insertedExpense.getOperationType().getId(), expense.getDescription(), expense.getRegisteredAt());
    }
}
