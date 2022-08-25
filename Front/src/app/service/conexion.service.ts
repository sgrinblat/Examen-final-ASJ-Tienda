import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Producto } from '../producto';
import { Vendedor } from '../vendedor';
import { Venta } from '../venta';

@Injectable({
  providedIn: 'root'
})
export class ConexionService {

  // Esta URL obtiene los datos del formulario y de los usuarios de la base de datos
  private baseURLFactura = "http://localhost:8080/factura/datos"
  private baseURLProducto = "http://localhost:8080/producto/datos"
  private baseURLVendedor = "http://localhost:8080/vendedor/datos"

  constructor(private httpClient: HttpClient) { }



  // este método nos sirve para obtener a las personas que mandaron el formulario
  obtenerProductosCargados():Observable<Producto[]> {
    return this.httpClient.get<Producto[]>(`${this.baseURLProducto}`);
  }

  // método para mostrar vendedores registrados
  obtenerVendedoresRegistrados():Observable<Vendedor[]> {
    return this.httpClient.get<Vendedor[]>(`${this.baseURLVendedor}`);
  }

  // método para mostrar ventas registradas
  obtenerVentasRegistradas():Observable<Venta[]> {
    return this.httpClient.get<Venta[]>(`${this.baseURLFactura}`);
  }

  // este método nos sirve para registrar un vendedor en la base de datos
  registrarVendedor(vendedor: Vendedor) : Observable<Object> {
    return this.httpClient.post(`${this.baseURLVendedor}`, vendedor);
  }

  // este método nos sirve para registrar un producto en la base de datos
  registrarProducto(producto: Producto) : Observable<Object> {
    return this.httpClient.post(`${this.baseURLProducto}`, producto);
  }

  // este método nos sirve para registrar un producto en la base de datos
  registrarVenta(venta: Venta) : Observable<Object> {
    return this.httpClient.post(`${this.baseURLFactura}`, venta);
  }


  // -------------------------------------------


}
