package com.petersen.examen.asj.repositorios;

import com.petersen.examen.asj.dominios.entidades.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iVendedorRepo extends JpaRepository <Vendedor, Long> {
    Optional<Vendedor> findByNombreVendedor(String nombre);
}
