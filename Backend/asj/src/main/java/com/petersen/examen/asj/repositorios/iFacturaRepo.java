package com.petersen.examen.asj.repositorios;

import com.petersen.examen.asj.dominios.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iFacturaRepo extends JpaRepository <Factura, Long> {

    @Query("select v from Factura v join fetch v.vendedor w where w.id = ?1")
    List<Factura> buscarVentasPorIdVendedor(Long id);
}
