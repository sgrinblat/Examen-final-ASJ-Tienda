package com.petersen.examen.asj.dominios.dtos;


public class VendedorDTO {

    private Long vendedorCodigo;
    private String vendedorNombre;
    private Double vendedorSueldoBasico;
    private Double vendedorComision;
    private Double vendedorSueldoTotal;


    public VendedorDTO(Long vendedorCodigo, String vendedorNombre, Double vendedorSueldoBasico, Double vendedorComision, Double vendedorSueldoTotal) {
        this.vendedorCodigo = vendedorCodigo;
        this.vendedorNombre = vendedorNombre;
        this.vendedorSueldoBasico = vendedorSueldoBasico;
        this.vendedorComision = vendedorComision;
        this.vendedorSueldoTotal = vendedorSueldoTotal;
    }

    public Long getVendedorCodigo() {
        return vendedorCodigo;
    }

    public void setVendedorCodigo(Long vendedorCodigo) {
        this.vendedorCodigo = vendedorCodigo;
    }

    public String getVendedorNombre() {
        return vendedorNombre;
    }

    public void setVendedorNombre(String vendedorNombre) {
        this.vendedorNombre = vendedorNombre;
    }

    public Double getVendedorSueldoBasico() {
        return vendedorSueldoBasico;
    }

    public void setVendedorSueldoBasico(Double vendedorSueldoBasico) {
        this.vendedorSueldoBasico = vendedorSueldoBasico;
    }

    public Double getVendedorComision() {
        return vendedorComision;
    }

    public void setVendedorComision(Double vendedorComision) {
        this.vendedorComision = vendedorComision;
    }

    public Double getVendedorSueldoTotal() {
        return vendedorSueldoTotal;
    }

    public void setVendedorSueldoTotal(Double vendedorSueldoTotal) {
        this.vendedorSueldoTotal = vendedorSueldoTotal;
    }
}
