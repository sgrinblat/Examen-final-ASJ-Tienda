package com.petersen.examen.asj.services;


import com.petersen.examen.asj.dominios.dtos.FacturaDTO;
import com.petersen.examen.asj.dominios.dtos.ProductoDTO;
import com.petersen.examen.asj.dominios.entidades.Factura;
import com.petersen.examen.asj.excepciones.EncontradoException;
import com.petersen.examen.asj.excepciones.NoEncontradoException;


import java.util.List;
import java.util.Optional;

public interface iFacturaService {

    List<FacturaDTO> mostrarFacturas();

    Optional<FacturaDTO> mostrarFacturaPorId(Long id);

    FacturaDTO cargarNuevaVenta(FacturaDTO facturaDTO) throws EncontradoException, NoEncontradoException;
}
