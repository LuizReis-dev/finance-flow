package com.luizreis.financeflow.repositories;

import com.luizreis.financeflow.dtos.earning.EarningDTO;
import com.luizreis.financeflow.dtos.expense.ExpenseCreatedDTO;
import com.luizreis.financeflow.entities.Earning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EarningRepository extends JpaRepository<Earning, Long> {

    @Query("SELECT new com.luizreis.financeflow.dtos.earning.EarningDTO(obj.id, obj.value, obj.description, obj.registeredAt) " +
            " FROM Earning obj " +
            "WHERE obj.registeredAt BETWEEN :minDate AND :maxDate " +
            "ORDER BY obj.id")
    List<EarningDTO> getAllEarnings(LocalDate minDate, LocalDate maxDate);
}
