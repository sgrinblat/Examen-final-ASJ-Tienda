package com.petersen.examen.asj.excepciones;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class EncontradoException extends RuntimeException {

    private String codigo;
    private HttpStatus status;

    public EncontradoException(String message, String codigo, HttpStatus status) {
        super(message);
        this.codigo = codigo;
        this.status = status;
    }
}
