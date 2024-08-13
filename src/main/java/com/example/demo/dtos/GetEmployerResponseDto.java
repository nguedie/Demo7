package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployerResponseDto {
    private  long id;
    private String Nom;
    private String Prenom;
    private String Sexe;
    private int Age;
    @DateTimeFormat(pattern = "HH:mm")
    @JsonProperty("heureArrive")
    private LocalTime heurArrive;

    @DateTimeFormat(pattern = "HH:mm")
    @JsonProperty("heureDepart")

    private LocalTime heureDepart;

    @JsonProperty("EmailAddress")
    private String  EmailAddress;
    private double salaire;
}
