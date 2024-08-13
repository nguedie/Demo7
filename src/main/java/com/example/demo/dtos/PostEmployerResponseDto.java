package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


@Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor

    public class PostEmployerResponseDto {
        private  long id;
        private String Nom;
        private String Prenom;
        private String Sexe;
        private int Age;
    @DateTimeFormat(pattern = "HH:mm")
    @JsonProperty("heureArrive")
        private int heurArrive;
    @JsonProperty("heureDepart")
        private int heureDepart;
    @JsonProperty("EmailAddress")
        private String  EmailAddress;
        private double salaire;
    }


