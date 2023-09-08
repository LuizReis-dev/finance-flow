package com.luizreis.financeflow.services;

import com.luizreis.financeflow.dtos.earning.EarningDTO;
import com.luizreis.financeflow.entities.Earning;
import com.luizreis.financeflow.repositories.EarningRepository;
import com.luizreis.financeflow.services.utils.Validate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

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

    @Transactional
    public List<EarningDTO> getAll(String minDate, String maxDate){
        LocalDate min = Validate.validateMinDate(minDate);
        LocalDate max = Validate.validateMaxDate(maxDate);
        return repository.getAllEarnings(min, max);
    }
}
