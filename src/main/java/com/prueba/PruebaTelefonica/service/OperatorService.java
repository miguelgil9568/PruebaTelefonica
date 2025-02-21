package com.prueba.PruebaTelefonica.service;

import com.prueba.PruebaTelefonica.model.OperatorRequest;
import com.prueba.PruebaTelefonica.model.OperatorResponse;
import com.prueba.PruebaTelefonica.util.FileUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class OperatorService {

    private static final String SUCCESS_CODE = "200";
    private static final String ERROR_CODE = "500";

    private static long idCounter = 1;

    public OperatorResponse procesarOperacion(OperatorRequest operacion, String datosAlfanumericos) {
        String resultadoOperacion = "Operación realizada con éxito: " + operacion.getValor1() + operacion.getOperador() + operacion.getValor2()  ;
        String mensaje = "La operación se procesó correctamente.";
        long identificador = idCounter++;
        double resultado;
        switch (operacion.getOperador()) {
            case "+":
                resultado = operacion.getValor1() + operacion.getValor2();
                break;
            case "-":
                resultado = operacion.getValor1() - operacion.getValor2();
                break;
            case "*":
                resultado = operacion.getValor1() * operacion.getValor2();
                break;
            case "/":
                resultado = operacion.getValor1() / operacion.getValor2();
                break;
            default:
                mensaje = "La operación no se procesó correctamente.";
                return new OperatorResponse(ERROR_CODE, mensaje, identificador, "Error en el operador");
        }

        FileUtil.guardarEnArchivo(identificador, resultadoOperacion, datosAlfanumericos);

        return new OperatorResponse(SUCCESS_CODE, mensaje, identificador, resultadoOperacion + " = " + resultado);
    }

    public OperatorResponse consultarOperacion(long id) {
        String operacionConsultada = FileUtil.obtenerOperacion(id);
        if(operacionConsultada == "Operación no encontrada"){
            return new OperatorResponse(ERROR_CODE, "Consulta sin éxito", id, operacionConsultada);
        }else{
            return new OperatorResponse(SUCCESS_CODE, "Consulta realizada con éxito", id, operacionConsultada);
        }

    }
}
