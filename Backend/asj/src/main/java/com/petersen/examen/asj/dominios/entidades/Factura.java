package com.petersen.examen.asj.dominios.entidades;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @Column(name = "codigo_factura")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoFactura;

    @Column (name = "cantidad_factura")
    private Double cantidadFactura;

    @Column (name = "total_factura")
    private Double totalFactura;

    @ManyToOne
    @JoinColumn(name = "vendedor_codigo_vendedor")
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "producto_codigo_producto")
    private Producto producto;

    public Factura() {
    }

    public Factura(Long codigoFactura, Double cantidadFactura, Double totalFactura, Vendedor vendedor, Producto producto) {
        this.codigoFactura = codigoFactura;
        this.cantidadFactura = cantidadFactura;
        this.totalFactura = totalFactura;
        this.vendedor = vendedor;
        this.producto = producto;
    }

    public Long getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(Long codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Double getCantidadFactura() {
        return cantidadFactura;
    }

    public void setCantidadFactura(Double cantidadFactura) {
        this.cantidadFactura = cantidadFactura;
    }

    public Double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(Double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
