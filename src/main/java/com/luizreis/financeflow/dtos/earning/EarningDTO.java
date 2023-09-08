package com.luizreis.financeflow.dtos.earning;

import com.luizreis.financeflow.entities.Earning;

import java.time.LocalDate;

public class EarningDTO {

    private Long id;
    private Double value;
    private String description;
    private LocalDate registeredAt;

    public EarningDTO(Long id, Double value, String description, LocalDate registeredAt) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.registeredAt = registeredAt;
    }

    public EarningDTO(Earning earning) {
        this.id = earning.getId();
        this.value = earning.getValue();
        this.description = earning.getDescription();
        this.registeredAt = earning.getRegisteredAt();
    }


    public Long getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getRegisteredAt() {
        return registeredAt;
    }
}
