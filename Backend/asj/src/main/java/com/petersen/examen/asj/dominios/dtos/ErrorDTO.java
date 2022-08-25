package com.petersen.examen.asj.dominios.dtos;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDTO {

    private String codigo;
    private String mensaje;

}
