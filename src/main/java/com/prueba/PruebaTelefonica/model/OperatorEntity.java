package com.prueba.PruebaTelefonica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperatorEntity {
    private Integer idprivate;
    private String operacion;
    private String cadenaTexto;
    private String resultadoOperacion;
}
