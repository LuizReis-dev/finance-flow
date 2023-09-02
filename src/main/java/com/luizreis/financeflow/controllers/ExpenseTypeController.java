package com.luizreis.financeflow.controllers;

import com.luizreis.financeflow.dtos.ExpenseTypeDTO;
import com.luizreis.financeflow.services.ExpenseTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense-type")
public class ExpenseTypeController {

    private ExpenseTypeService service;

    public ExpenseTypeController(ExpenseTypeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ExpenseTypeDTO> insert(@RequestBody ExpenseTypeDTO dto) {
        ExpenseTypeDTO returnDto = service.insert(dto);
        return ResponseEntity.ok().body(returnDto);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseTypeDTO>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }
}
