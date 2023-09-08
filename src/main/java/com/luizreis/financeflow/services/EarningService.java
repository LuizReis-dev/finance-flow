package com.luizreis.financeflow.services;

import com.luizreis.financeflow.dtos.earning.EarningDTO;
import com.luizreis.financeflow.entities.Earning;
import com.luizreis.financeflow.repositories.EarningRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EarningService {

    private EarningRepository repository;

    public EarningService(EarningRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public EarningDTO insert(EarningDTO dto){
        Earning earning = new Earning();
        earning.setDescription(dto.getDescription());
        earning.setValue(dto.getValue());
        earning.setRegisteredAt(dto.getRegisteredAt());

        earning = repository.save(earning);

        return new EarningDTO(earning);
    }
}
