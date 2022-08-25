package com.petersen.examen.asj.dominios.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.petersen.examen.asj.dominios.entidades.Producto;
import com.petersen.examen.asj.dominios.entidades.Vendedor;

public class FacturaDTO {

    private Long facturaCodigo;
    private Long facturaCantidad;
    private Double facturaTotal;
    private ProductoDTO facturaProducto;
    private VendedorDTO facturaVendedor;


    public FacturaDTO(Long facturaCodigo, Long facturaCantidad, Double facturaTotal, ProductoDTO facturaProducto, VendedorDTO facturaVendedor) {
        this.facturaCodigo = facturaCodigo;
        this.facturaCantidad = facturaCantidad;
        this.facturaTotal = facturaTotal;
        this.facturaProducto = facturaProducto;
        this.facturaVendedor = facturaVendedor;
    }


    public Long getFacturaCodigo() {
        return facturaCodigo;
    }

    public void setFacturaCodigo(Long facturaCodigo) {
        this.facturaCodigo = facturaCodigo;
    }

    public Long getFacturaCantidad() {
        return facturaCantidad;
    }

    public void setFacturaCantidad(Long facturaCantidad) {
        this.facturaCantidad = facturaCantidad;
    }

    public Double getFacturaTotal() {
        return facturaTotal;
    }

    public void setFacturaTotal(Double facturaTotal) {
        this.facturaTotal = facturaTotal;
    }

    public ProductoDTO getFacturaProducto() {
        return facturaProducto;
    }

    public void setFacturaProducto(ProductoDTO facturaProducto) {
        this.facturaProducto = facturaProducto;
    }

    public VendedorDTO getFacturaVendedor() {
        return facturaVendedor;
    }

    public void setFacturaVendedor(VendedorDTO facturaVendedor) {
        this.facturaVendedor = facturaVendedor;
    }
}
