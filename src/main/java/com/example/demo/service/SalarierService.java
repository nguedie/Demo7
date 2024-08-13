package com.example.demo.service;

import com.example.demo.dtos.DeleteEmployerResponseDto;
import com.example.demo.dtos.GetEmployerResponseDto;
import com.example.demo.dtos.PostEmployerResponseDto;
import com.example.demo.dtos.UpdateEmployerResponseDto;
import com.example.demo.model.Salarier;

import java.util.List;

public interface SalarierService {
    GetEmployerResponseDto lire (long id);

    PostEmployerResponseDto creer(Salarier salarier);


    List<Salarier> lire();




    //List<Employer> sortEmployersBySalary(List<Employer> employers);



    UpdateEmployerResponseDto modifier(long id, Salarier salarier);

    DeleteEmployerResponseDto supprimer(long id);
}
