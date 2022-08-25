package com.petersen.examen.asj.excepciones;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class NoEncontradoException extends RuntimeException{

    private String codigo;
    private HttpStatus status;

    public NoEncontradoException(String message, String codigo, HttpStatus status) {
        super(message);
        this.codigo = codigo;
        this.status = status;
    }
}
