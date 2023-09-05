package com.luizreis.financeflow.services;

import com.luizreis.financeflow.dtos.expense.ExpenseCreatedDTO;
import com.luizreis.financeflow.dtos.expense.ExpenseDTO;
import com.luizreis.financeflow.dtos.summary.SumExpensePerExpenseTypeDTO;
import com.luizreis.financeflow.entities.Expense;
import com.luizreis.financeflow.entities.ExpenseType;
import com.luizreis.financeflow.repositories.ExpenseRepository;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

@Service
public class ExpenseService {

    private final LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

    private ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public ExpenseDTO insert(ExpenseDTO dto){
        ExpenseType type = new ExpenseType();
        type.setId(dto.getExpenseTypeId());

        Expense expense = new Expense();
        expense.setValue(dto.getValue());
        expense.setDescription(dto.getDescription());
        expense.setRegisteredAt(dto.getRegisteredAt());
        expense.setOperationType(type);

        Expense insertedExpense = repository.save(expense);
        return new ExpenseDTO(insertedExpense.getId(), insertedExpense.getValue(), insertedExpense.getOperationType().getId(), expense.getDescription(), expense.getRegisteredAt());
    }

    public List<ExpenseCreatedDTO> getAll(String minDate, String maxDate){
        LocalDate min = validateMinDate(minDate);
        LocalDate max = validateMaxDate(maxDate);

        return repository.getAllExpenses(min, max);
    }

    public List<ExpenseCreatedDTO> getAllByExpenseType(Long id, String minDate, String maxDate) {
        LocalDate min = validateMinDate(minDate);
        LocalDate max = validateMaxDate(maxDate);

        return repository.getAllExpensesByExpenseType(id, min, max);
    }

    public List<SumExpensePerExpenseTypeDTO> getSumGroupByExpenseType(String minDate, String maxDate) {
        LocalDate min = validateMinDate(minDate);
        LocalDate max = validateMaxDate(maxDate);

        List<SumExpensePerExpenseTypeDTO> list = repository.getSumGroupByExpenseType(min, max);
        SumExpensePerExpenseTypeDTO total = repository.getSum(min, max);
        list.add(total);
        return list;
    }

    private LocalDate validateMaxDate(String maxDate) {
        LocalDate max;
        try{
            max = LocalDate.parse(maxDate);
        }catch(DateTimeParseException e){
            max = today;
        }
        return max;
    }

    private LocalDate validateMinDate(String minDate){
        LocalDate min;
        try{
            min = LocalDate.parse(minDate);
        }catch(DateTimeParseException e){
            min = today.minusMonths(1L);
        }
        return min;
    }
}
