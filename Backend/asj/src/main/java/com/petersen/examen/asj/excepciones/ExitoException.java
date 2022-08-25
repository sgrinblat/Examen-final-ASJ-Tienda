package com.petersen.examen.asj.excepciones;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ExitoException extends RuntimeException {

    private String codigo;
    private HttpStatus status;

    public ExitoException(String message, String codigo, HttpStatus status) {
        super(message);
        this.codigo = codigo;
        this.status = status;
    }
}
