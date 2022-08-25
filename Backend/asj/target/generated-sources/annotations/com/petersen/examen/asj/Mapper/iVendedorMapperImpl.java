package com.petersen.examen.asj.Mapper;

import com.petersen.examen.asj.dominios.dtos.VendedorDTO;
import com.petersen.examen.asj.dominios.entidades.Vendedor;
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
public class iVendedorMapperImpl implements iVendedorMapper {

    @Override
    public VendedorDTO toVendedorDTO(Vendedor vendedor) {
        if ( vendedor == null ) {
            return null;
        }

        Long vendedorCodigo = null;
        String vendedorNombre = null;
        Double vendedorSueldoBasico = null;
        Double vendedorComision = null;
        Double vendedorSueldoTotal = null;

        vendedorCodigo = vendedor.getCodigoVendedor();
        vendedorNombre = vendedor.getNombreVendedor();
        vendedorSueldoBasico = vendedor.getSueldoBasicoVendedor();
        vendedorComision = vendedor.getComisionVendedor();
        vendedorSueldoTotal = vendedor.getSueldoTotalVendedor();

        VendedorDTO vendedorDTO = new VendedorDTO( vendedorCodigo, vendedorNombre, vendedorSueldoBasico, vendedorComision, vendedorSueldoTotal );

        return vendedorDTO;
    }

    @Override
    public List<VendedorDTO> toVendedores(List<Vendedor> vendedor) {
        if ( vendedor == null ) {
            return null;
        }

        List<VendedorDTO> list = new ArrayList<VendedorDTO>( vendedor.size() );
        for ( Vendedor vendedor1 : vendedor ) {
            list.add( toVendedorDTO( vendedor1 ) );
        }

        return list;
    }

    @Override
    public Vendedor toVendedor(VendedorDTO vendedorDTO) {
        if ( vendedorDTO == null ) {
            return null;
        }

        Vendedor vendedor = new Vendedor();

        vendedor.setCodigoVendedor( vendedorDTO.getVendedorCodigo() );
        vendedor.setNombreVendedor( vendedorDTO.getVendedorNombre() );
        if ( vendedorDTO.getVendedorSueldoBasico() != null ) {
            vendedor.setSueldoBasicoVendedor( vendedorDTO.getVendedorSueldoBasico() );
        }
        if ( vendedorDTO.getVendedorComision() != null ) {
            vendedor.setComisionVendedor( vendedorDTO.getVendedorComision() );
        }
        vendedor.setSueldoTotalVendedor( vendedorDTO.getVendedorSueldoTotal() );

        return vendedor;
    }
}
