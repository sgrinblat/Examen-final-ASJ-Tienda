package com.petersen.examen.asj.controllers;

import com.petersen.examen.asj.dominios.dtos.ErrorDTO;
import com.petersen.examen.asj.excepciones.EncontradoException;
import com.petersen.examen.asj.excepciones.ExitoException;
import com.petersen.examen.asj.excepciones.NoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = EncontradoException.class)
    public ResponseEntity<ErrorDTO> encontradoException(EncontradoException ex){
        ErrorDTO error = ErrorDTO.builder().codigo(ex.getCodigo()).mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }

    @ExceptionHandler(value = NoEncontradoException.class)
    public ResponseEntity<ErrorDTO> NoEncontradoException(NoEncontradoException ex){
        ErrorDTO error = ErrorDTO.builder().codigo(ex.getCodigo()).mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }

    @ExceptionHandler(value = ExitoException.class)
    public ResponseEntity<ErrorDTO> ExitoException(ExitoException ex){
        ErrorDTO error = ErrorDTO.builder().codigo(ex.getCodigo()).mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }

}
