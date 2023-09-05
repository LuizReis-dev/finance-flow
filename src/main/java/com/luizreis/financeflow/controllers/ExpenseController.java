package com.luizreis.financeflow.controllers;

import com.luizreis.financeflow.dtos.expense.ExpenseCreatedDTO;
import com.luizreis.financeflow.dtos.expense.ExpenseDTO;
import com.luizreis.financeflow.dtos.summary.SumExpensePerExpenseTypeDTO;
import com.luizreis.financeflow.services.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    private ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ExpenseDTO> insert(@RequestBody ExpenseDTO dto) {
        ExpenseDTO returnDto = service.insert(dto);
        return ResponseEntity.ok().body(returnDto);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseCreatedDTO>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping(value = "/expense-type/{id}")
    public ResponseEntity<List<ExpenseCreatedDTO>> getAllByExpenseType(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getAllByExpenseType(id));
    }

    @GetMapping("/summary")
    public ResponseEntity<List<SumExpensePerExpenseTypeDTO>> getSumGroupByExpenseType(){
        return ResponseEntity.ok().body(service.getSumGroupByExpenseType());
    }
}
