package com.petersen.examen.asj.Mapper;

import com.petersen.examen.asj.dominios.dtos.FacturaDTO;
import com.petersen.examen.asj.dominios.dtos.ProductoDTO;
import com.petersen.examen.asj.dominios.dtos.VendedorDTO;
import com.petersen.examen.asj.dominios.entidades.Factura;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-25T03:14:15-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
@Component
public class iFacturaMapperImpl implements iFacturaMapper {

    @Autowired
    private iVendedorMapper iVendedorMapper;
    @Autowired
    private iProductoMapper iProductoMapper;

    @Override
    public FacturaDTO toFacturaDTO(FacturaDTO facturaDTO) {
        if ( facturaDTO == null ) {
            return null;
        }

        Long facturaCodigo = null;
        Long facturaCantidad = null;
        Double facturaTotal = null;
        ProductoDTO facturaProducto = null;
        VendedorDTO facturaVendedor = null;

        facturaCodigo = facturaDTO.getFacturaCodigo();
        facturaCantidad = facturaDTO.getFacturaCantidad();
        facturaTotal = facturaDTO.getFacturaTotal();
        facturaProducto = facturaDTO.getFacturaProducto();
        facturaVendedor = facturaDTO.getFacturaVendedor();

        FacturaDTO facturaDTO1 = new FacturaDTO( facturaCodigo, facturaCantidad, facturaTotal, facturaProducto, facturaVendedor );

        return facturaDTO1;
    }

    @Override
    public FacturaDTO toFacturaDTO(Factura factura) {
        if ( factura == null ) {
            return null;
        }

        Long facturaCodigo = null;
        Long facturaCantidad = null;
        Double facturaTotal = null;
        VendedorDTO facturaVendedor = null;
        ProductoDTO facturaProducto = null;

        facturaCodigo = factura.getCodigoFactura();
        if ( factura.getCantidadFactura() != null ) {
            facturaCantidad = factura.getCantidadFactura().longValue();
        }
        facturaTotal = factura.getTotalFactura();
        facturaVendedor = iVendedorMapper.toVendedorDTO( factura.getVendedor() );
        facturaProducto = iProductoMapper.toProductoDTO( factura.getProducto() );

        FacturaDTO facturaDTO = new FacturaDTO( facturaCodigo, facturaCantidad, facturaTotal, facturaProducto, facturaVendedor );

        return facturaDTO;
    }

    @Override
    public List<FacturaDTO> toFacturas(List<Factura> facturas) {
        if ( facturas == null ) {
            return null;
        }

        List<FacturaDTO> list = new ArrayList<FacturaDTO>( facturas.size() );
        for ( Factura factura : facturas ) {
            list.add( toFacturaDTO( factura ) );
        }

        return list;
    }

    @Override
    public Factura toFactura(FacturaDTO facturaDTO) {
        if ( facturaDTO == null ) {
            return null;
        }

        Factura factura = new Factura();

        factura.setCodigoFactura( facturaDTO.getFacturaCodigo() );
        if ( facturaDTO.getFacturaCantidad() != null ) {
            factura.setCantidadFactura( facturaDTO.getFacturaCantidad().doubleValue() );
        }
        factura.setTotalFactura( facturaDTO.getFacturaTotal() );
        factura.setVendedor( iVendedorMapper.toVendedor( facturaDTO.getFacturaVendedor() ) );
        factura.setProducto( iProductoMapper.toProducto( facturaDTO.getFacturaProducto() ) );

        return factura;
    }
}
