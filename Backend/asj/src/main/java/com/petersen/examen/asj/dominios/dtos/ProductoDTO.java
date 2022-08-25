package com.petersen.examen.asj.dominios.dtos;


public class ProductoDTO {

    private Long productoCodigo;
    private String productoNombre;
    private Double productoPrecio;
    private String productoCategoria;

    public ProductoDTO(Long productoCodigo, String productoNombre, Double productoPrecio, String productoCategoria) {
        this.productoCodigo = productoCodigo;
        this.productoNombre = productoNombre;
        this.productoPrecio = productoPrecio;
        this.productoCategoria = productoCategoria;
    }

    public Long getProductoCodigo() {
        return productoCodigo;
    }

    public void setProductoCodigo(Long productoCodigo) {
        this.productoCodigo = productoCodigo;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public Double getProductoPrecio() {
        return productoPrecio;
    }

    public void setProductoPrecio(Double productoPrecio) {
        this.productoPrecio = productoPrecio;
    }

    public String getProductoCategoria() {
        return productoCategoria;
    }

    public void setProductoCategoria(String productoCategoria) {
        this.productoCategoria = productoCategoria;
    }
}
