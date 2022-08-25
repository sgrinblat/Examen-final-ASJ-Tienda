package com.petersen.examen.asj.controllers;

import com.petersen.examen.asj.dominios.dtos.FacturaDTO;
import com.petersen.examen.asj.excepciones.EncontradoException;
import com.petersen.examen.asj.excepciones.ExitoException;
import com.petersen.examen.asj.excepciones.NoEncontradoException;
import com.petersen.examen.asj.services.iFacturaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/factura")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class FacturaController {

    @Autowired
    private final iFacturaService servicio;

    public FacturaController(iFacturaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/datos")
    @ApiOperation("Muestra todas las ventas registradas en la base de datos")
    public List<FacturaDTO> mostrarFacturas() {
        List <FacturaDTO> facturasRegistradas = servicio.mostrarFacturas();
        if(!facturasRegistradas.isEmpty()) {
            return facturasRegistradas;
        } else {
            throw new NoEncontradoException("No hay facturas cargadas en la base de datos.", "A-002", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/datos/{id}")
    @ApiOperation("Muestra una venta registrada buscándolo por su ID")
    public Optional<FacturaDTO> mostrarFacturaPorID(@PathVariable Long id) {
        if (servicio.mostrarFacturaPorId(id).isPresent()) {
            return servicio.mostrarFacturaPorId(id);
        } else {
            throw new NoEncontradoException("No hay una venta registrada con el id indicado", "A-002", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/datos")
    @ApiOperation("Registra una venta nueva en la base de datos")
    public ResponseEntity altaVenta(@RequestBody FacturaDTO facturaDTO) {
        try {
            this.servicio.cargarNuevaVenta(facturaDTO);
            throw new ExitoException("La venta fue ingresada exitosamente", "A-003", HttpStatus.OK);
        } catch (EncontradoException e) {
            throw new EncontradoException("La venta con el ID ingresado ya se encuentra registrada.", "A-001", HttpStatus.CONFLICT);
        } catch (NoEncontradoException e) {
            throw new NoEncontradoException("No pudo encontrarse al vendedor o bien el producto ingresado.", "A-002", HttpStatus.NOT_FOUND);
        }

    }



}
