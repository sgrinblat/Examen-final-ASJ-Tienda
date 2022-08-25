package com.petersen.examen.asj.dominios.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @Column (name = "codigo_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoProducto;

    @Column (name = "nombre_producto", unique = true)
    private String nombreProducto;

    @Column (name = "precio_producto")
    private Double precioProducto;

    @Column (name = "categoria_producto")
    private String categoriaProducto;

//    @OneToMany(mappedBy = "producto")
//    private List<Factura> facturas;

    public Producto() {
    }

    public Producto(Long codigoProducto, String nombreProducto, Double precioProducto, String categoriaProducto, List<Factura> facturas) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.categoriaProducto = categoriaProducto;
    }

    public Long getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Long codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

}
