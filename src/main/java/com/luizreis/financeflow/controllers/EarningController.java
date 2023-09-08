package com.luizreis.financeflow.controllers;

import com.luizreis.financeflow.dtos.earning.EarningDTO;
import com.luizreis.financeflow.services.EarningService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<EarningDTO>> getAll(
            @RequestParam(name = "minDate", defaultValue = "") String minDate,
            @RequestParam(name = "maxDate", defaultValue = "") String maxDate){

        return ResponseEntity.ok().body(service.getAll(minDate, maxDate));
    }

}

