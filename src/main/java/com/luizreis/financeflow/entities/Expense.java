package com.luizreis.financeflow.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double value;
    @ManyToOne
    @JoinColumn(name = "operation_type_id")
    private ExpenseType expenseType;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "registered_at")
    private Instant registeredAt;

    public Expense() {
    }

    public Expense(Long id, Double value, ExpenseType expenseType, String description, Instant registeredAt) {
        this.id = id;
        this.value = value;
        this.expenseType = expenseType;
        this.description = description;
        this.registeredAt = registeredAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public ExpenseType getOperationType() {
        return expenseType;
    }

    public void setOperationType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Instant registeredAt) {
        this.registeredAt = registeredAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense that = (Expense) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
