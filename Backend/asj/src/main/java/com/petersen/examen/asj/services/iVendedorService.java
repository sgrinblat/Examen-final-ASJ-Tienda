package com.petersen.examen.asj.services;

import com.petersen.examen.asj.dominios.dtos.ProductoDTO;
import com.petersen.examen.asj.dominios.dtos.VendedorDTO;

import java.util.List;
import java.util.Optional;

public interface iVendedorService {

    List<VendedorDTO> mostrarVendedores();

    Optional<VendedorDTO> mostrarVendedorPorID(Long id);

    Optional<VendedorDTO> mostrarVendedorPorNombre(String nombre);

    VendedorDTO registrarNuevoVendedor(VendedorDTO vendedorDTO);

    public void eliminarVendedorPorId(Long id);

    VendedorDTO actualizarVendedor(Long id, VendedorDTO vendedorDTO);
}
