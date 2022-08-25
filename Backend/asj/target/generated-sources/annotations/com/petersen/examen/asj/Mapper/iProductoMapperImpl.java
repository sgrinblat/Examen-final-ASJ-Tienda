package com.petersen.examen.asj.Mapper;

import com.petersen.examen.asj.dominios.dtos.ProductoDTO;
import com.petersen.examen.asj.dominios.entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-25T03:14:15-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
@Component
public class iProductoMapperImpl implements iProductoMapper {

    @Override
    public ProductoDTO toProductoDTO(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        Long productoCodigo = null;
        String productoNombre = null;
        Double productoPrecio = null;
        String productoCategoria = null;

        productoCodigo = producto.getCodigoProducto();
        productoNombre = producto.getNombreProducto();
        productoPrecio = producto.getPrecioProducto();
        productoCategoria = producto.getCategoriaProducto();

        ProductoDTO productoDTO = new ProductoDTO( productoCodigo, productoNombre, productoPrecio, productoCategoria );

        return productoDTO;
    }

    @Override
    public List<ProductoDTO> toProductos(List<Producto> producto) {
        if ( producto == null ) {
            return null;
        }

        List<ProductoDTO> list = new ArrayList<ProductoDTO>( producto.size() );
        for ( Producto producto1 : producto ) {
            list.add( toProductoDTO( producto1 ) );
        }

        return list;
    }

    @Override
    public Producto toProducto(ProductoDTO productoDTO) {
        if ( productoDTO == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setCodigoProducto( productoDTO.getProductoCodigo() );
        producto.setNombreProducto( productoDTO.getProductoNombre() );
        producto.setPrecioProducto( productoDTO.getProductoPrecio() );
        producto.setCategoriaProducto( productoDTO.getProductoCategoria() );

        return producto;
    }
}
