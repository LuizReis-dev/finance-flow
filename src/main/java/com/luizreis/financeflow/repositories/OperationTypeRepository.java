package com.luizreis.financeflow.repositories;

import com.luizreis.financeflow.entities.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTypeRepository extends JpaRepository<OperationType, Long> {
}
