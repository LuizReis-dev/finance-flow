package com.luizreis.financeflow.controllers;

import com.luizreis.financeflow.dtos.ExpenseTypeDTO;
import com.luizreis.financeflow.services.ExpenseTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expense-type")
public class ExpenseTypeController {

    private ExpenseTypeService service;

    public ExpenseTypeController(ExpenseTypeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<com.luizreis.financeflow.dtos.ExpenseTypeDTO> insert(@RequestBody ExpenseTypeDTO dto) {
        ExpenseTypeDTO returnDto = service.insert(dto);
        return ResponseEntity.ok().body(returnDto);
    }
}
