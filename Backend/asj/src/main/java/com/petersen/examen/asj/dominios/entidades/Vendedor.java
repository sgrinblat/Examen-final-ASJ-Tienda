package com.petersen.examen.asj.dominios.entidades;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vendedor")
public class Vendedor {

    @Id
    @Column(name = "codigo_vendedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoVendedor;

    @Column (name = "nombre_vendedor", unique = true)
    private String nombreVendedor;

    @Column (name = "sueldobasico_vendedor")
    private double sueldoBasicoVendedor;

    @Column (name = "comision_vendedor")
    private double comisionVendedor;

    @Column (name = "sueldototal_vendedor")
    private Double sueldoTotalVendedor;

    public Vendedor() {
    }

    public Vendedor(Long codigoVendedor, String nombreVendedor, double sueldoBasicoVendedor, double comisionVendedor, Double sueldoTotalVendedor) {
        this.codigoVendedor = codigoVendedor;
        this.nombreVendedor = nombreVendedor;
        this.sueldoBasicoVendedor = sueldoBasicoVendedor;
        this.comisionVendedor = comisionVendedor;
        this.sueldoTotalVendedor = sueldoTotalVendedor;
    }

    public Long getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(Long codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public double getSueldoBasicoVendedor() {
        return sueldoBasicoVendedor;
    }

    public void setSueldoBasicoVendedor(double sueldoBasicoVendedor) {
        this.sueldoBasicoVendedor = sueldoBasicoVendedor;
    }

    public double getComisionVendedor() {
        return comisionVendedor;
    }

    public void setComisionVendedor(double comisionVendedor) {
        this.comisionVendedor = comisionVendedor;
    }

    public Double getSueldoTotalVendedor() {
        return sueldoTotalVendedor;
    }

    public void setSueldoTotalVendedor(Double sueldoTotalVendedor) {
        this.sueldoTotalVendedor = sueldoTotalVendedor;
    }
}
