package com.luizreis.financeflow.controllers;

import com.luizreis.financeflow.dtos.earning.EarningDTO;
import com.luizreis.financeflow.services.EarningService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/earning")
public class EarningController {

    private EarningService service;

    public EarningController(EarningService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EarningDTO> insert(@RequestBody EarningDTO dto){
        return ResponseEntity.ok().body(service.insert(dto));
    }

}

