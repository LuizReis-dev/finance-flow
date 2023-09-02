package com.luizreis.financeflow.services;

import com.luizreis.financeflow.dtos.OperationTypeDTO;
import com.luizreis.financeflow.entities.OperationType;
import com.luizreis.financeflow.repositories.OperationTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Service
public class OperationTypeService {

    private Logger logger = Logger.getLogger(OperationType.class.getName());

    private OperationTypeRepository repository;

    public OperationTypeService(OperationTypeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public OperationTypeDTO insert(final OperationTypeDTO dto){
        OperationType operationType = new OperationType();
        operationType.setName(dto.getName());
        operationType.setStatus(1);
        OperationType insertedOperationType = repository.save(operationType);

        return new OperationTypeDTO(insertedOperationType.getId(), insertedOperationType.getName());
    }

}
