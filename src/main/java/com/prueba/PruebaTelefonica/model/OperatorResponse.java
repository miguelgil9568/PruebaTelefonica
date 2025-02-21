package com.prueba.PruebaTelefonica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperatorResponse {

        private String codigoRespuesta;
        private String mensaje;
        private long idOperacion;
        private String resultadoOperacion;

}
