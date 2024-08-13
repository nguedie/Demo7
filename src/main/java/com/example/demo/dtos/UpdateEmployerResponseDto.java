package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class UpdateEmployerResponseDto {
    private  long id;
    private String Nom;
    private String Prenom;
    private String Sexe;
    private int Age;
    private int heurArrive;
    private int heureDepart;
    private String  EmailAddress;
    private double salaire;
}

