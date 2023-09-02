package com.luizreis.financeflow.services;

import com.luizreis.financeflow.dtos.ExpenseTypeDTO;
import com.luizreis.financeflow.entities.ExpenseType;
import com.luizreis.financeflow.repositories.ExpenseTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Service
public class ExpenseTypeService {

    private Logger logger = Logger.getLogger(ExpenseType.class.getName());

    private ExpenseTypeRepository repository;

    public ExpenseTypeService(ExpenseTypeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public com.luizreis.financeflow.dtos.ExpenseTypeDTO insert(final ExpenseTypeDTO dto){
        ExpenseType expenseType = new ExpenseType();
        expenseType.setName(dto.getName());
        expenseType.setStatus(1);
        ExpenseType insertedExpenseType = repository.save(expenseType);

        return new ExpenseTypeDTO(insertedExpenseType.getId(), insertedExpenseType.getName());
    }

}
