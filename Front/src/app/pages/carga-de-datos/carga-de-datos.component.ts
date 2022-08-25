import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ConexionService } from 'src/app/service/conexion.service';
import { Producto } from '../../producto';
import { Vendedor } from '../../vendedor';
import { Venta } from '../../venta';

@Component({
  selector: 'app-carga-de-datos',
  templateUrl: './carga-de-datos.component.html',
  styleUrls: ['./carga-de-datos.component.css']
})
export class CargaDeDatosComponent implements OnInit {

  contactForm!: FormGroup;
  contactFormProducto! : FormGroup;
  contactFormVenta! : FormGroup;

  producto: Producto = new Producto();
  vendedor: Vendedor = new Vendedor();
  venta: Venta = new Venta();

  constructor(private readonly fb: FormBuilder, private router: Router, private conexion : ConexionService) {
    this.contactForm = fb.group({
      formularioVendedorNombre: ['', [Validators.required, Validators.minLength(3)]],
      formularioVendedorSueldoBasico: ['', [Validators.required, Validators.minLength(5)]],
    })

    this.contactFormProducto = fb.group({
      formularioProductoNombre: ['', [Validators.required, Validators.minLength(3)]],
      formularioProductoPrecio: ['', [Validators.required, Validators.minLength(2)]],
      formularioProductoCategoria: ['', [Validators.required, Validators.minLength(3)]],
    })

    this.contactFormVenta = fb.group({
      formularioVentaCantidad: ['', [Validators.required, Validators.minLength(1)]],
      formularioVentaTotal: ['', [Validators.required, Validators.minLength(2)]],
      formularioVentaProducto: ['', [Validators.required, Validators.minLength(1)]],
      formularioVentaVendedor: ['', [Validators.required, Validators.minLength(1)]],
    })
  }

  ngOnInit() {
  }

  onSubmitVendedor() {
    this.almacenarDatosVendedor();
    this.limpiarFormularioVendedor();
  }

  onSubmitProducto() {
    this.almacenarDatosProducto();
    this.limpiarFormularioProducto();
  }

  onSubmitVenta() {
    this.almacenarDatosVenta();
    this.limpiarFormularioVenta();
  }

  // métodos del formulario de nuevo vendedor
  almacenarDatosVendedor() {
    this.vendedor.vendedorNombre = this.contactForm.value.formularioVendedorNombre;
    this.vendedor.vendedorSueldoBasico = this.contactForm.value.formularioVendedorSueldoBasico;
    this.vendedor.vendedorComision = 0;
    this.vendedor.vendedorSueldoTotal = this.contactForm.value.formularioVendedorSueldoBasico;

    this.conexion.registrarVendedor(this.vendedor).subscribe(dato => {
      console.log(dato);
    }, error => console.log(error));
  }

  limpiarFormularioVendedor() {
    this.vendedor.vendedorNombre = " ";
    this.vendedor.vendedorSueldoBasico = 0;

    this.contactForm.reset();
  }


  // métodos del formulario de nuevo producto
  almacenarDatosProducto() {
    this.producto.productoNombre = this.contactFormProducto.value.formularioProductoNombre;
    this.producto.productoPrecio = this.contactFormProducto.value.formularioProductoPrecio;
    this.producto.productoCategoria = this.contactFormProducto.value.formularioProductoCategoria;

    this.conexion.registrarProducto(this.producto).subscribe(dato => {
      console.log(dato);
    }, error => console.log(error));
  }

  limpiarFormularioProducto() {
    this.producto.productoNombre = " ";
    this.producto.productoPrecio = 0;
    this.producto.productoCategoria = " ";

    this.contactFormProducto.reset();
  }


  // métodos del formulario de nueva venta
  almacenarDatosVenta() {
    this.venta.facturaCantidad = this.contactFormVenta.value.formularioVentaCantidad;
    this.venta.facturaTotal = this.contactFormVenta.value.formularioVentaTotal;
    this.venta.facturaProducto = this.contactFormVenta.value.formularioVentaProducto;
    this.venta.facturaVendedor = this.contactFormVenta.value.formularioVentaVendedor;

    this.conexion.registrarVenta(this.venta).subscribe(dato => {
      console.log(dato);
    }, error => console.log(error));
  }

  limpiarFormularioVenta() {
    this.venta.facturaCantidad = 0;
    this.venta.facturaTotal = 0;

    this.contactFormVenta.reset();
  }

}
