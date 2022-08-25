import { Producto } from './producto';
import { Vendedor } from './vendedor';

export class Venta {
  facturaCodigo!: number;
  facturaCantidad!: number;
  facturaTotal!: number;

  facturaProducto!: Producto[];
  facturaVendedor!: Vendedor[];
}
