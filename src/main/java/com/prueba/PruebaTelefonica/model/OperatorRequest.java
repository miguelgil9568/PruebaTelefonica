package com.prueba.PruebaTelefonica.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperatorRequest {
    private double valor1;
    private double valor2;

    @Pattern(regexp = "^[\\+\\-\\*\\/]+$", message = "El operador debe ser uno de los siguientes: +, -, *, /.")
    private String operador;
}

