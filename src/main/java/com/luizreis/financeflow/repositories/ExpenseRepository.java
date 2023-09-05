package com.luizreis.financeflow.repositories;

import com.luizreis.financeflow.dtos.expense.ExpenseCreatedDTO;
import com.luizreis.financeflow.dtos.summary.SumExpensePerExpenseTypeDTO;
import com.luizreis.financeflow.entities.Expense;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("SELECT new com.luizreis.financeflow.dtos.expense.ExpenseCreatedDTO(obj.id, obj.value, obj.expenseType.name, obj.description, obj.registeredAt) " +
            " FROM Expense obj " +
            "WHERE obj.registeredAt BETWEEN :minDate AND :maxDate " +
            "ORDER BY obj.id")
    List<ExpenseCreatedDTO> getAllExpenses(LocalDate minDate, LocalDate maxDate);

    @Query("SELECT new com.luizreis.financeflow.dtos.expense.ExpenseCreatedDTO(obj.id, obj.value, obj.expenseType.name, obj.description, obj.registeredAt) " +
            " FROM Expense obj " +
            " WHERE obj.expenseType.id = :id " +
            " AND obj.registeredAt BETWEEN :minDate AND :maxDate " +
            "ORDER BY obj.id ")
    List<ExpenseCreatedDTO> getAllExpensesByExpenseType(Long id, LocalDate minDate, LocalDate maxDate);

    @Query("SELECT new com.luizreis.financeflow.dtos.summary.SumExpensePerExpenseTypeDTO(SUM(obj.value), obj.expenseType.name)" +
            " FROM Expense obj " +
            " WHERE obj.registeredAt BETWEEN :minDate AND :maxDate " +
            "GROUP BY obj.expenseType.name")
    List<SumExpensePerExpenseTypeDTO> getSumGroupByExpenseType(LocalDate minDate, LocalDate maxDate);

    @Query("SELECT new com.luizreis.financeflow.dtos.summary.SumExpensePerExpenseTypeDTO(SUM(obj.value), 'total')" +
            " FROM Expense obj" +
            " WHERE obj.registeredAt BETWEEN :minDate AND :maxDate ")
    SumExpensePerExpenseTypeDTO getSum(LocalDate minDate, LocalDate maxDate);
}
