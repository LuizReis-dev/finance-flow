package com.luizreis.financeflow.controllers;

import com.luizreis.financeflow.dtos.OperationTypeDTO;
import com.luizreis.financeflow.services.OperationTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/operation-type")
public class OperationTypeController {

    private OperationTypeService service;

    public OperationTypeController(OperationTypeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OperationTypeDTO> insert(@RequestBody OperationTypeDTO dto) {
        OperationTypeDTO returnDto = service.insert(dto);
        return ResponseEntity.ok().body(returnDto);
    }
}
