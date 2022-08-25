import { Component, OnInit } from '@angular/core';
import { ConexionService } from '../../service/conexion.service';
import { Vendedor } from '../../vendedor';
import { Producto } from '../../producto';
import { Venta } from '../../venta';

@Component({
  selector: 'app-base-de-datos',
  templateUrl: './base-de-datos.component.html',
  styleUrls: ['./base-de-datos.component.css']
})
export class BaseDeDatosComponent implements OnInit {

  vendedores!: Vendedor[];
  productos!: Producto[];
  ventas!: Venta[];

  constructor(private conexion: ConexionService) { }

  ngOnInit(): void {
    this.obtenerVendedores();
    this.obtenerProductos();
    this.obtenerVentas();
  }

  private obtenerVendedores() {
    this.conexion.obtenerVendedoresRegistrados().subscribe(dato => {
      this.vendedores = dato;
    })
  }

  private obtenerProductos() {
    this.conexion.obtenerProductosCargados().subscribe(dato => {
      this.productos = dato;
    })
  }

  private obtenerVentas() {
    this.conexion.obtenerVentasRegistradas().subscribe(dato => {
      this.ventas = dato;
    })
  }

}
