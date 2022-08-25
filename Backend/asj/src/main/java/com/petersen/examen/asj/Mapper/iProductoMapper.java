package com.petersen.examen.asj.Mapper;

import com.petersen.examen.asj.dominios.dtos.ProductoDTO;
import com.petersen.examen.asj.dominios.entidades.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface iProductoMapper {
    @Mappings({
            @Mapping(source = "codigoProducto", target = "productoCodigo"),
            @Mapping(source = "nombreProducto", target = "productoNombre"),
            @Mapping(source = "precioProducto", target = "productoPrecio"),
            @Mapping(source = "categoriaProducto", target = "productoCategoria"),
    })
    ProductoDTO toProductoDTO(Producto producto);
    List<ProductoDTO> toProductos(List<Producto> producto);

    @InheritInverseConfiguration
    Producto toProducto(ProductoDTO productoDTO);
}
