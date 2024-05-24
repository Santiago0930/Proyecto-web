import { Component, Input } from '@angular/core';
import { PlanetaXProducto } from '../../model/planeta-xproducto';
import { Producto } from '../../model/producto';
import { ProductoService} from '../../shared/producto.service';
import { PlanetaxproductoService } from '../../shared/planetaxproducto.service';
import { TipoNaveService } from '../../shared/tipo-nave.service';
import { BodegaNave } from '../../model/bodega-nave';
import { BodeganaveService } from '../../shared/bodeganave.service';

@Component({
  selector: 'app-planetax-producto-list',
  templateUrl: './planetax-producto-list.component.html',
  styleUrl: './planetax-producto-list.component.css'
})
export class PlanetaxProductoListComponent {

  PxP: PlanetaXProducto[] = []
  productos: Producto[] = []
  idNave: number = 0
  bodega: BodegaNave [] = [];
  precioVenta: number [] = []
  precioCompra: number [] = []
  idEstrella: number = 0

  constructor(
    private planetaXproductoService: PlanetaxproductoService, 
    private productoService: ProductoService, 
    private naveService: TipoNaveService,
    private bodegaService: BodeganaveService,
  ){
  }

  @Input()
   set id(id: number) {
    console.log("id", id)
    this.naveService.getIdNave().subscribe(id => {this.idNave = id; this.bodegaService.listarStocks(this.idNave).subscribe(Bodega => this.bodega = Bodega)})
    this.planetaXproductoService.listarPxP(id).subscribe(planeta => this.PxP = planeta)
    this.planetaXproductoService.precioUnitarioCompra(id).subscribe(precio => this.precioCompra = precio)
    this.planetaXproductoService.precioUnitarioVenta(id).subscribe(precio => this.precioVenta = precio)
    this.productoService.listarProductos().subscribe(producto => this.productos = producto)
    this.naveService.getIdEstrella().subscribe(ID => this.idEstrella = ID)
   }

}


