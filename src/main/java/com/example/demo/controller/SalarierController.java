package com.example.demo.controller;

import com.example.demo.dtos.DeleteEmployerResponseDto;
import com.example.demo.dtos.GetEmployerResponseDto;
import com.example.demo.dtos.PostEmployerResponseDto;
import com.example.demo.dtos.UpdateEmployerResponseDto;
import com.example.demo.model.Salarier;
import com.example.demo.service.SalarierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
   @RequestMapping("/Salarier")
   @RequiredArgsConstructor
   class SalarierController {


    private final SalarierService salarierService;

    @GetMapping("/test/getEmployerById/{id}")
    public GetEmployerResponseDto lire(@PathVariable long id) {
        GetEmployerResponseDto employe = salarierService.lire(id);
        return employe;
    }

    @PostMapping("/test/create")
    public PostEmployerResponseDto create(@RequestBody Salarier salarier) {
        return salarierService.creer(salarier);
    }

    @DeleteMapping("/test/delete/{id}")
    public DeleteEmployerResponseDto delete(@PathVariable long id) {

        return salarierService.supprimer(id);
    }

    @PutMapping("/update/{id}")
    public UpdateEmployerResponseDto update(@PathVariable long id, @RequestBody Salarier salarier) {
        return salarierService.modifier(id, salarier);


    }
}
