package com.example.ServidorSura5.Controladores;

import com.example.ServidorSura5.MODELOS.Medico;
import com.example.ServidorSura5.MODELOS.Paciente;
import com.example.ServidorSura5.Servicios.ServiciosMedico;
import com.example.ServidorSura5.Servicios.ServiciosPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Medico")
public class ControladorMedico {

    @Autowired
    ServiciosMedico serviciosMedico;
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Medico datos){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(serviciosMedico.guardarMedico(datos));

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
                    .body(serviciosMedico.buscarMedicos());

        }catch( Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}

