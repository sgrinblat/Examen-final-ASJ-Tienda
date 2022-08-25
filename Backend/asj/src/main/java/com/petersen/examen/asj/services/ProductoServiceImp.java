package com.petersen.examen.asj.services;

import com.petersen.examen.asj.Mapper.iProductoMapper;
import com.petersen.examen.asj.dominios.dtos.ProductoDTO;
import com.petersen.examen.asj.dominios.entidades.Producto;
import com.petersen.examen.asj.excepciones.NoEncontradoException;
import com.petersen.examen.asj.repositorios.iProductoRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImp implements iProductoService {

    private Logger logger = LoggerFactory.getLogger(ProductoServiceImp.class);

    @Autowired
    private iProductoRepo iProductoRepo;

    @Autowired
    private iProductoMapper mapper;

    @Override
    public List<ProductoDTO> mostrarProductos() {
        List<Producto> productos = (List<Producto>) iProductoRepo.findAll();
        return mapper.toProductos(productos);
    }

    @Override
    public Optional<ProductoDTO> mostrarProductoPorID(Long id) throws NoEncontradoException {
        return iProductoRepo.findById(id).map(producto -> mapper.toProductoDTO(producto));
    }

    @Override
    public Optional<ProductoDTO> mostrarProductosPorNombre(String nombre) {
        return iProductoRepo.findByNombreProducto(nombre).map(producto -> mapper.toProductoDTO(producto));
    }

    @Override
    public List<ProductoDTO> mostrarProductosPorCategoria(String categoria) {
        List<Producto> productos = (List<Producto>) iProductoRepo.findByCategoriaProducto(categoria);
        return mapper.toProductos(productos);
    }

    @Override
    public ProductoDTO cargarNuevoProducto(ProductoDTO productoDTO) {
        Producto producto = mapper.toProducto(productoDTO);
        return mapper.toProductoDTO(iProductoRepo.save(producto));
    }

    @Override
    public void eliminarProductoPorID(Long id) {
        iProductoRepo.deleteById(id);
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoDTO productoDTO) {
        Producto producto = mapper.toProducto(productoDTO);
        return mapper.toProductoDTO(iProductoRepo.save(producto));
    }
}
