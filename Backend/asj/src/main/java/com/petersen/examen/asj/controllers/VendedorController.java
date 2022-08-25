package com.petersen.examen.asj.controllers;

import com.petersen.examen.asj.dominios.dtos.ProductoDTO;
import com.petersen.examen.asj.dominios.dtos.VendedorDTO;
import com.petersen.examen.asj.excepciones.EncontradoException;
import com.petersen.examen.asj.excepciones.ExitoException;
import com.petersen.examen.asj.excepciones.NoEncontradoException;
import com.petersen.examen.asj.services.iVendedorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendedor")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class VendedorController {

    @Autowired
    private final iVendedorService servicio;

    public VendedorController(iVendedorService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/datos")
    @ApiOperation("Muestra todos los vendedores cargados en la base de datos")
    public List<VendedorDTO> mostrarVendedores() {
        List <VendedorDTO> vendedoresRegistrados = servicio.mostrarVendedores();
        if(!vendedoresRegistrados.isEmpty()) {
            return vendedoresRegistrados;
        } else {
            throw new NoEncontradoException("No hay vendedores cargados en la base de datos.", "A-002", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/datos/{id}")
    @ApiOperation("Muestra un vendedor buscándolo por su ID")
    public Optional<VendedorDTO> mostrarVendedorPorId(@PathVariable Long id) {
        try {
            return servicio.mostrarVendedorPorID(id);
        } catch (NoEncontradoException e) {
            throw new NoEncontradoException("No hay un vendedor con el id indicado", "A-002", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/vendedores/{nombre}")
    @ApiOperation("Muestra un vendedor buscándolo por su nombre")
    public Optional<VendedorDTO> mostrarVendedorPorNombre(@PathVariable String nombre) {
        if (servicio.mostrarVendedorPorNombre(nombre).isPresent()) {
            return servicio.mostrarVendedorPorNombre(nombre);
        } else {
            throw new NoEncontradoException("No hay un vendedor con el nombre indicado", "A-002", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/datos")
    @ApiOperation("Registra un nuevo vendedor en la base de datos")
    public VendedorDTO nuevoVendedor(@RequestBody VendedorDTO vendedorDTO)  {
        Optional<VendedorDTO> vendedor = servicio.mostrarVendedorPorNombre(vendedorDTO.getVendedorNombre());
        if(vendedor.isPresent()) {
            throw new EncontradoException("El vendedor ya se encuentra registrado.", "A-001", HttpStatus.CONFLICT);
        } else {
            return servicio.registrarNuevoVendedor(vendedorDTO);
        }
    }

    @DeleteMapping("/vendedores/{id}")
    @ApiOperation("Elimina un vendedor buscándolo por su ID")
    public void eliminarVendedorPorId(@PathVariable Long id) {
        Optional<VendedorDTO> vendedorDTO = servicio.mostrarVendedorPorID(id);
        if(servicio.mostrarVendedorPorID(id).isPresent()) {
            servicio.eliminarVendedorPorId(id);
            throw new ExitoException("El vendedor [" + vendedorDTO.get().getVendedorNombre() + "] fue eliminado exitosamente", "A-003", HttpStatus.OK);
        } else {
            throw new NoEncontradoException("El vendedor [" + vendedorDTO.get().getVendedorNombre() + "] no se encuentra registrado.", "A-002", HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/eliminar")
    @ApiOperation("Elimina un vendedor buscándolo por su nombre")
    public void eliminarVendedorPorNombre(@RequestBody VendedorDTO vendedorDTO) {
        Optional<VendedorDTO> vendedor = servicio.mostrarVendedorPorNombre(vendedorDTO.getVendedorNombre());
        if(vendedor.isPresent()) {
            servicio.eliminarVendedorPorId(vendedor.get().getVendedorCodigo());
            throw new ExitoException("El vendedor [" + vendedor.get().getVendedorNombre() + "] fue eliminado exitosamente", "A-003", HttpStatus.OK);
        } else {
            throw new NoEncontradoException("El vendedor [" + vendedor.get().getVendedorNombre() + "] no se encuentra registrado.", "A-002", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar")
    @ApiOperation("Actualiza un vendedor buscándolo por su ID")
    public void actualizarVendedor(@PathVariable Long id, @RequestBody VendedorDTO vendedorDTO) {
        Optional<VendedorDTO> vendedor = servicio.mostrarVendedorPorNombre(vendedorDTO.getVendedorNombre());
        if(vendedor.isPresent()) {
            servicio.actualizarVendedor(id, vendedorDTO);
            throw new ExitoException("El vendedor fue actualizado exitosamente", "A-003", HttpStatus.OK);
        } else {
            throw new NoEncontradoException("El vendedor no se encuentra registrado.", "A-002", HttpStatus.NOT_FOUND);
        }
    }
}
