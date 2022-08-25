package com.petersen.examen.asj.Mapper;

import com.petersen.examen.asj.dominios.dtos.FacturaDTO;
import com.petersen.examen.asj.dominios.entidades.Factura;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {iVendedorMapper.class, iProductoMapper.class})
public interface iFacturaMapper {

    FacturaDTO toFacturaDTO(FacturaDTO facturaDTO);

    @Mappings({
            @Mapping(source = "codigoFactura", target = "facturaCodigo"),
            @Mapping(source = "cantidadFactura", target = "facturaCantidad"),
            @Mapping(source = "totalFactura", target = "facturaTotal"),
            @Mapping(source = "vendedor", target = "facturaVendedor"),
            @Mapping(source = "producto", target = "facturaProducto"),
    })
    FacturaDTO toFacturaDTO(Factura factura);
    List<FacturaDTO> toFacturas(List<Factura> facturas);

    @InheritInverseConfiguration
    Factura toFactura(FacturaDTO facturaDTO);
}
