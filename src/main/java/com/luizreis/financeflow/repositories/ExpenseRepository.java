package com.luizreis.financeflow.repositories;

import com.luizreis.financeflow.dtos.expense.ExpenseCreatedDTO;
import com.luizreis.financeflow.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {


    @Query("SELECT new com.luizreis.financeflow.dtos.expense.ExpenseCreatedDTO(obj.id, obj.value, obj.expenseType.name, obj.description, obj.registeredAt) " +
            " FROM Expense obj " +
            " ORDER BY obj.id")
    List<ExpenseCreatedDTO> getAllExpenses();
}
