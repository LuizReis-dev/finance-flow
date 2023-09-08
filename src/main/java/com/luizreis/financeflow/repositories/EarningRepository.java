package com.luizreis.financeflow.repositories;

import com.luizreis.financeflow.entities.Earning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EarningRepository extends JpaRepository<Earning, Long> {
}
