package com.luizreis.financeflow.repositories;

import com.luizreis.financeflow.entities.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Long> {
}
