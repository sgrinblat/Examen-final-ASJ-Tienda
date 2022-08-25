package com.petersen.examen.asj.controllers;

import com.petersen.examen.asj.dominios.dtos.ProductoDTO;
import com.petersen.examen.asj.dominios.entidades.Producto;
import com.petersen.examen.asj.excepciones.EncontradoException;
import com.petersen.examen.asj.excepciones.ExitoException;
import com.petersen.examen.asj.excepciones.NoEncontradoException;
import com.petersen.examen.asj.services.iProductoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ProductoController {

    @Autowired
    private final iProductoService servicio;

    public ProductoController(iProductoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/datos")
    @ApiOperation("Muestra todos los productos cargados en la base de datos")
    public List<ProductoDTO> mostrarProductos() {
        List <ProductoDTO> productosCargados = servicio.mostrarProductos();
        if(!productosCargados.isEmpty()) {
            return productosCargados;
        } else {
            throw new NoEncontradoException("No hay productos cargados en la base de datos.", "A-002", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/datos/{id}")
    @ApiOperation("Muestra un producto buscándolo por su ID")
    public Optional<ProductoDTO> mostrarProductoPorID(@PathVariable Long id) {
        if (servicio.mostrarProductoPorID(id).isPresent()) {
            return servicio.mostrarProductoPorID(id);
        } else {
            throw new NoEncontradoException("No hay un producto con el id indicado", "A-002", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/productos/{nombre}")
    @ApiOperation("Muestra un producto buscándolo por su nombre")
    public Optional<ProductoDTO> mostrarProductoPorNombre(@PathVariable String nombre) {
        if (servicio.mostrarProductosPorNombre(nombre).isPresent()) {
            return servicio.mostrarProductosPorNombre(nombre);
        } else {
            throw new NoEncontradoException("No hay un producto con el nombre indicado", "A-002", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/categoria/{categoria}")
    @ApiOperation("Muestra un producto buscándolo por su categoria")
    public List<ProductoDTO> mostrarProductoPorCategoria(@PathVariable String categoria) {
        if (!servicio.mostrarProductosPorCategoria(categoria).isEmpty()) {
            return servicio.mostrarProductosPorCategoria(categoria);
        } else {
            throw new NoEncontradoException("No hay productos registrados con la categoria indicada", "A-002", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/datos")
    @ApiOperation("Registra un producto nuevo en la base de datos")
    public ProductoDTO nuevoProducto(@RequestBody ProductoDTO productoDTO) {
        Optional<ProductoDTO> producto = servicio.mostrarProductosPorNombre(productoDTO.getProductoNombre());
        if(producto.isPresent()) {
            throw new EncontradoException("El producto ya se encuentra registrado.", "A-001", HttpStatus.CONFLICT);
        } else {
            return servicio.cargarNuevoProducto(productoDTO);
        }
    }

    @DeleteMapping("/productos/{id}")
    @ApiOperation("Elimina un producto buscándolo por su id")
    public void eliminarProductoPorId(@PathVariable Long id) {
        Optional<ProductoDTO> producto = servicio.mostrarProductoPorID(id);
        if(producto.isPresent()) {
            servicio.eliminarProductoPorID(id);
            throw new ExitoException("El producto fue eliminado exitosamente", "A-003", HttpStatus.OK);
        } else {
            throw new NoEncontradoException("El producto no se encuentra registrado.", "A-002", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar")
    @ApiOperation("Elimina un producto buscándolo por su nombre")
    public void eliminarProductoPorNombre(@RequestBody ProductoDTO productoDTO) {
        Optional<ProductoDTO> producto = servicio.mostrarProductosPorNombre(productoDTO.getProductoNombre());
        if(producto.isPresent()) {
            servicio.eliminarProductoPorID(producto.get().getProductoCodigo());
            throw new ExitoException("El producto fue eliminado exitosamente", "A-003", HttpStatus.OK);
        } else {
            throw new NoEncontradoException("El producto no se encuentra registrado.", "A-002", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar")
    @ApiOperation("Actualiza un producto buscándolo por su id")
    public void actualizarProducto(@RequestBody ProductoDTO productoDTO) {
        Optional<ProductoDTO> producto = servicio.mostrarProductoPorID(productoDTO.getProductoCodigo());
        if(producto.isPresent()) {
            servicio.actualizarProducto(productoDTO);
            throw new ExitoException("El producto fue actualizado exitosamente", "A-003", HttpStatus.OK);
        } else {
            throw new NoEncontradoException("El producto no se encuentra registrado.", "A-002", HttpStatus.NOT_FOUND);
        }
    }


}
