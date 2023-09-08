package com.luizreis.financeflow.services;

import com.luizreis.financeflow.dtos.expense.ExpenseCreatedDTO;
import com.luizreis.financeflow.dtos.expense.ExpenseDTO;
import com.luizreis.financeflow.dtos.summary.SumExpensePerExpenseTypeDTO;
import com.luizreis.financeflow.entities.Expense;
import com.luizreis.financeflow.entities.ExpenseType;
import com.luizreis.financeflow.repositories.ExpenseRepository;
import com.luizreis.financeflow.services.exceptions.ResourceNotFoundException;
import com.luizreis.financeflow.services.utils.Validate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

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
        expense.setDescription(dto.getDescription());
        expense.setRegisteredAt(dto.getRegisteredAt());
        expense.setOperationType(type);

        Expense insertedExpense = repository.save(expense);
        return new ExpenseDTO(insertedExpense.getId(), insertedExpense.getValue(), insertedExpense.getOperationType().getId(), expense.getDescription(), expense.getRegisteredAt());
    }

    public List<ExpenseCreatedDTO> getAll(String minDate, String maxDate){
        LocalDate min = Validate.validateMinDate(minDate);
        LocalDate max = Validate.validateMaxDate(maxDate);

        return repository.getAllExpenses(min, max);
    }

    public List<ExpenseCreatedDTO> getAllByExpenseType(Long id, String minDate, String maxDate) {
        LocalDate min = Validate.validateMinDate(minDate);
        LocalDate max = Validate.validateMaxDate(maxDate);

        return repository.getAllExpensesByExpenseType(id, min, max);
    }

    public List<SumExpensePerExpenseTypeDTO> getSumGroupByExpenseType(String minDate, String maxDate) {
        LocalDate min = Validate.validateMinDate(minDate);
        LocalDate max = Validate.validateMaxDate(maxDate);

        List<SumExpensePerExpenseTypeDTO> list = repository.getSumGroupByExpenseType(min, max);
        SumExpensePerExpenseTypeDTO total = repository.getSum(min, max);
        list.add(total);
        return list;
    }

    @Transactional
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Expense not found!");
        }
        repository.deleteById(id);
    }


}
