package com.petersen.examen.asj.Mapper;

import com.petersen.examen.asj.dominios.dtos.VendedorDTO;
import com.petersen.examen.asj.dominios.entidades.Vendedor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface iVendedorMapper {

    @Mappings({
            @Mapping(source = "codigoVendedor", target = "vendedorCodigo"),
            @Mapping(source = "nombreVendedor", target = "vendedorNombre"),
            @Mapping(source = "sueldoBasicoVendedor", target = "vendedorSueldoBasico"),
            @Mapping(source = "comisionVendedor", target = "vendedorComision"),
            @Mapping(source = "sueldoTotalVendedor", target = "vendedorSueldoTotal"),
    })
    VendedorDTO toVendedorDTO(Vendedor vendedor);
    List<VendedorDTO> toVendedores(List<Vendedor> vendedor);

    @InheritInverseConfiguration
    Vendedor toVendedor(VendedorDTO vendedorDTO);
}
