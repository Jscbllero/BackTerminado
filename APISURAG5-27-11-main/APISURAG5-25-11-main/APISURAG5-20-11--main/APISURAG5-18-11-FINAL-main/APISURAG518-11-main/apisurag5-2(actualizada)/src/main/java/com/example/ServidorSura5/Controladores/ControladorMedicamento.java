package com.example.ServidorSura5.Controladores;

import com.example.ServidorSura5.MODELOS.Medicamento;
import com.example.ServidorSura5.Servicios.ServiciosMedicamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medicamento")
public class ControladorMedicamento {

    @Autowired
    ServiciosMedicamentos serviciosMedicamentos;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Medicamento datos){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(serviciosMedicamentos.guardarMedicamento(datos));

        }catch( Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<?> obtener(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(serviciosMedicamentos.buscarMedicamentos());

        }catch( Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
