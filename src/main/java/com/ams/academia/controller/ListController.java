package com.ams.academia.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Se necesita esta anotación para poder consumir la api
@CrossOrigin(origins = {})
public class ListController {

    //Definimos los datos simulando traerlos de una base de datos
    private List<Map<String, String>> elementos = Arrays.asList(
        Map.of("id", "1", "nombre", "David Hernandez", "descripcion", "Descripción del elemento 1"),
        Map.of("id", "2", "nombre", "Jorge Lopez", "descripcion", "Descripción del elemento 2"),
        Map.of("id", "3", "nombre", "Angel Torres", "descripcion", "Descripción del elemento 3")
    );

    //Regresa los elementos dentro del listado de elementos definido anteriormente
    @GetMapping("/api/elementos")
    public ResponseEntity<List<Map<String, String>>> getElementos() {
        try {
            return new ResponseEntity<>(elementos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}