package com.petersen.examen.asj.services;

import com.petersen.examen.asj.dominios.dtos.ProductoDTO;
import com.petersen.examen.asj.dominios.entidades.Producto;
import com.petersen.examen.asj.excepciones.EncontradoException;
import com.petersen.examen.asj.excepciones.NoEncontradoException;

import java.util.List;
import java.util.Optional;

public interface iProductoService {

    List<ProductoDTO> mostrarProductos();

    Optional<ProductoDTO> mostrarProductoPorID(Long id);

    Optional<ProductoDTO> mostrarProductosPorNombre(String nombre);

    List<ProductoDTO> mostrarProductosPorCategoria(String categoria);

    ProductoDTO cargarNuevoProducto(ProductoDTO productoDTO) throws EncontradoException;

    public void eliminarProductoPorID(Long id) throws NoEncontradoException;

    ProductoDTO actualizarProducto(ProductoDTO productoDTO) throws NoEncontradoException;

}
