package com.petersen.examen.asj.services;


import com.petersen.examen.asj.Mapper.iProductoMapper;
import com.petersen.examen.asj.Mapper.iVendedorMapper;
import com.petersen.examen.asj.dominios.dtos.VendedorDTO;
import com.petersen.examen.asj.dominios.entidades.Producto;
import com.petersen.examen.asj.dominios.entidades.Vendedor;
import com.petersen.examen.asj.repositorios.iProductoRepo;
import com.petersen.examen.asj.repositorios.iVendedorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorServiceImp implements iVendedorService {

    @Autowired
    private iVendedorRepo iVendedorRepo;

    @Autowired
    private iVendedorMapper mapper;

    @Override
    public List<VendedorDTO> mostrarVendedores() {
        List<Vendedor> vendedores = (List<Vendedor>) iVendedorRepo.findAll();
        return mapper.toVendedores(vendedores);
    }

    @Override
    public Optional<VendedorDTO> mostrarVendedorPorID(Long id) {
        return iVendedorRepo.findById(id).map(vendedor -> mapper.toVendedorDTO(vendedor));
    }

    @Override
    public Optional<VendedorDTO> mostrarVendedorPorNombre(String nombre) {
        return iVendedorRepo.findByNombreVendedor(nombre).map(vendedor -> mapper.toVendedorDTO(vendedor));
    }

    @Override
    public VendedorDTO registrarNuevoVendedor(VendedorDTO vendedorDTO) {
        Vendedor vendedor = mapper.toVendedor(vendedorDTO);
        return mapper.toVendedorDTO(iVendedorRepo.save(vendedor));
    }

    @Override
    public void eliminarVendedorPorId(Long id) {
        iVendedorRepo.deleteById(id);
    }

    @Override
    public VendedorDTO actualizarVendedor(Long id, VendedorDTO vendedorDTO) {
        Vendedor vendedor = mapper.toVendedor(vendedorDTO);
        return mapper.toVendedorDTO(iVendedorRepo.save(vendedor));
    }
}
