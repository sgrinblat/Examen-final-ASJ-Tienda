package com.petersen.examen.asj.repositorios;

import com.petersen.examen.asj.dominios.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface iProductoRepo extends JpaRepository <Producto, Long> {

    Optional<Producto> findByNombreProducto(String nombre);

    List<Producto> findByCategoriaProducto(String categoria);

}
