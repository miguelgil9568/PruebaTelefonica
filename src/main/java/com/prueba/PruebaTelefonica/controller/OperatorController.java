package com.prueba.PruebaTelefonica.controller;


import com.prueba.PruebaTelefonica.model.OperatorRequest;
import com.prueba.PruebaTelefonica.model.OperatorResponse;
import com.prueba.PruebaTelefonica.service.OperatorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


@Controller
@RestController
@RequestMapping(value = "/api")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @PostMapping("/procesar")
    public ResponseEntity<OperatorResponse> procesarOperacion(@RequestBody @Valid OperatorRequest operatorRequest, @RequestParam @Valid @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "El dato debe ser alfanumérico sin caracteres especiales ni espacios.") String mensaje) {
        return ResponseEntity.ok(operatorService.procesarOperacion(operatorRequest, mensaje));
    }

    @GetMapping("/consultar/{idOperacion}")
    public ResponseEntity<OperatorResponse> consultarOperacion(@PathVariable int idOperacion) {
        return ResponseEntity.ok(operatorService.consultarOperacion(idOperacion));
    }

}
