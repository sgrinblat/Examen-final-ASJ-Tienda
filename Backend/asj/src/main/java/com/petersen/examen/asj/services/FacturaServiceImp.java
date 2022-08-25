package com.petersen.examen.asj.services;

import com.petersen.examen.asj.Mapper.iFacturaMapper;
import com.petersen.examen.asj.dominios.dtos.FacturaDTO;
import com.petersen.examen.asj.dominios.dtos.ProductoDTO;
import com.petersen.examen.asj.dominios.dtos.VendedorDTO;
import com.petersen.examen.asj.dominios.entidades.Factura;
import com.petersen.examen.asj.excepciones.EncontradoException;
import com.petersen.examen.asj.excepciones.NoEncontradoException;
import com.petersen.examen.asj.repositorios.iFacturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImp implements iFacturaService{

    @Autowired
    private iFacturaRepo iFacturaRepo;

    @Autowired
    private iVendedorService iVendedorService;

    @Autowired
    private iProductoService iProductoService;

    @Autowired
    private iFacturaMapper mapper;

    @Override
    public List<FacturaDTO> mostrarFacturas() {
        List<Factura> facturas = (List<Factura>) iFacturaRepo.findAll();
        return mapper.toFacturas(facturas);
    }

    public Optional <FacturaDTO> mostrarFacturaPorId(Long id) {
        if (!iFacturaRepo.findById(id).map(factura -> mapper.toFacturaDTO(factura)).isPresent()) {
            throw new NoEncontradoException("No hay una factura con el id indicado", "A-002", HttpStatus.NOT_FOUND);
        } else return iFacturaRepo.findById(id).map(factura -> mapper.toFacturaDTO(factura));
    }

    @Override
    public FacturaDTO cargarNuevaVenta(FacturaDTO facturaDTO) throws EncontradoException, NoEncontradoException {
        if (facturaDTO != null) {
            if (facturaDTO.getFacturaCodigo() != null) {
                if (this.iFacturaRepo.findById(facturaDTO.getFacturaCodigo()).isPresent()) {
                    throw new EncontradoException("Ya existe una venta con el id [" + facturaDTO.getFacturaCodigo() + "]", "A-001", HttpStatus.CONFLICT);
                }
            }
        }

        //Registramos el total de la venta en la Factura, al obtener el precio registrado del producto en la base de datos
        Optional<ProductoDTO> productoOptional = this.iProductoService.mostrarProductoPorID(facturaDTO.getFacturaProducto().getProductoCodigo());
        if(!productoOptional.isPresent()){
            throw new NoEncontradoException("El producto buscado no existe.", "A-002", HttpStatus.NOT_FOUND);
        }
        ProductoDTO productoB = productoOptional.get();
        // Buscamos el precio por unidad del producto y lo multiplicamos por la cantidad que fue ingresada en la factura
        facturaDTO.setFacturaTotal(productoB.getProductoPrecio() * facturaDTO.getFacturaCantidad());

        //Persistimos la venta en la tabla factura
        Factura resultado = mapper.toFactura(facturaDTO);
        mapper.toFacturaDTO(iFacturaRepo.save(resultado));

        //Actualizamos las comisiones y el sueldo del vendedor, basado en sus ventas previas
        Optional<VendedorDTO> vendedorOptional = this.iVendedorService.mostrarVendedorPorID(facturaDTO.getFacturaVendedor().getVendedorCodigo());
        if(!vendedorOptional.isPresent()){
            throw new NoEncontradoException("El vendedor buscado no existe.", "A-002", HttpStatus.NOT_FOUND);
        }

        // Obtenemos el valor de comisión actualizada al buscar las ventas realizadas por el vendedor
        Double comisionVentaActualizada = this.porcentajeComision(facturaDTO);

        VendedorDTO vendedorB = vendedorOptional.get();
        // Registramos la comisión que le corresponde, y luego sumamos su sueldo con el valor obtenido de la comisión y el total de sus ventas
        vendedorB.setVendedorComision(comisionVentaActualizada);
        vendedorB.setVendedorSueldoTotal(vendedorB.getVendedorSueldoBasico() + vendedorB.getVendedorComision());

        //Persisto cambios en el vendedor
        this.iVendedorService.actualizarVendedor(vendedorB.getVendedorCodigo(), vendedorB);

        //Devuelvo venta
        return facturaDTO;
    }

    // Método que nos actualiza la comisión del vendedor basado en sus ventas previas
    private Double porcentajeComision(FacturaDTO facturaDTO) {
        List<Factura> ventasVendedor = (List<Factura>) this.iFacturaRepo.buscarVentasPorIdVendedor(facturaDTO.getFacturaVendedor().getVendedorCodigo());

        Double primeraEscalaComision = 0.05;
        Double SegundaEscalaComision = 0.1;
        Double totalVentas = 0.0;

        // Recorremos con un forEach la cantidad de ventas hechas por el vendedor
        for (Factura v : ventasVendedor) {
            totalVentas += v.getTotalFactura();
        }

        return (ventasVendedor.size() < 3 ? totalVentas * primeraEscalaComision : totalVentas * SegundaEscalaComision);
    }

}
