package com.luizreis.financeflow.repositories;

import com.luizreis.financeflow.dtos.expense.ExpenseCreatedDTO;
import com.luizreis.financeflow.dtos.summary.SumExpensePerExpenseTypeDTO;
import com.luizreis.financeflow.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("SELECT new com.luizreis.financeflow.dtos.expense.ExpenseCreatedDTO(obj.id, obj.value, obj.expenseType.name, obj.description, obj.registeredAt) " +
            " FROM Expense obj " +
            " ORDER BY obj.id")
    List<ExpenseCreatedDTO> getAllExpenses();

    @Query("SELECT new com.luizreis.financeflow.dtos.expense.ExpenseCreatedDTO(obj.id, obj.value, obj.expenseType.name, obj.description, obj.registeredAt) " +
            " FROM Expense obj " +
            " WHERE obj.expenseType.id = :id " +
            "ORDER BY obj.id ")
    List<ExpenseCreatedDTO> getAllExpensesByExpenseType(Long id);

    @Query("SELECT new com.luizreis.financeflow.dtos.summary.SumExpensePerExpenseTypeDTO(SUM(obj.value), obj.expenseType.name)" +
            " FROM Expense obj " +
            " GROUP BY obj.expenseType.name")
    List<SumExpensePerExpenseTypeDTO> getSumGroupByExpenseType();

    @Query("SELECT new com.luizreis.financeflow.dtos.summary.SumExpensePerExpenseTypeDTO(SUM(obj.value), 'total')" +
            " FROM Expense obj")
    SumExpensePerExpenseTypeDTO getSum();
}
