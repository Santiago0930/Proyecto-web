import { TipoNaveService } from './../../shared/tipo-nave.service';
import { Component, Input } from '@angular/core';
import { Producto } from '../../model/producto';
import { ProductoService } from '../../shared/producto.service';
import { Planeta } from '../../model/planeta';
import { PlanetaXProducto } from '../../model/planeta-xproducto';
import { BodegaNave } from '../../model/bodega-nave';
import { PlanetaService } from '../../shared/planeta.service';
import { PlanetaxproductoService } from '../../shared/planetaxproducto.service';
import { BodeganaveService } from '../../shared/bodeganave.service';
import { CargaService } from '../../shared/carga.service';
import { TripulanteService } from '../../shared/tripulante.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-producto-list',
  templateUrl: './producto-list.component.html',
  styleUrl: './producto-list.component.css'
})
export class ProductoListComponent {

  producto: Producto = new Producto(0, "", 0);
  idPlaneta: number = 0
  idNave: number = 0
  PxP: PlanetaXProducto = new PlanetaXProducto(0, 0, 0, 0)
  precioUnitarioCompra: number = 0
  precioUnitarioVenta: number = 0
  bodega: BodegaNave = new BodegaNave(0, 0)
  cantidad: number = 0
  tiempo: number = 0
  isVisible = false;
  campoDeshabilitado = false;
  precioFinalVenta: number = 0
  precioFinalCompra: number = 0
  cargaActual: number = 0
  planeta: Planeta = new Planeta(0, "")
  stockNuevoP: number = 0
  stockNuevoN: number = 0
  idProducto: number = 0
  dinero: number = 0
  vol: number = 0
  idEstrella: number = 0
  rol: String = ''
  cargaNave: number = 0

  constructor(
    private productoService: ProductoService,
    private planetaService: PlanetaService,
    private PxPService: PlanetaxproductoService,
    private bodegaService: BodeganaveService,
    private cargaService: CargaService,
    private naveService: TipoNaveService,
    private tripulanteService: TripulanteService,
    private router: Router,
  ) { }

  @Input()
  set id(id: number) {
    console.log("id", id)
    this.idProducto = id
    this.productoService.obtenerProducto(id).subscribe(productos => this.producto = productos)
    this.planetaService.getIdPlaneta().subscribe(idp => { this.idPlaneta = idp; this.planetaService.obtenerPlaneta(this.idPlaneta).subscribe(idp => this.planeta = idp); this.PxPService.obtenerPxP(this.idPlaneta, id).subscribe(pxp => this.PxP = pxp) })
    this.naveService.getIdNave().subscribe(id => { this.idNave = id; this.bodegaService.obtenerStock(this.idNave, id).subscribe(Stock => this.bodega = Stock); this.naveService.obtenerDinero(this.idNave).subscribe(Dinero => this.dinero = Dinero); this.naveService.obtenerCarga(this.idNave).subscribe(c => this.cargaNave = c)})
    this.cargaService.getCarga().subscribe(car => this.vol = car)
    this.naveService.getIdEstrella().subscribe(ide => this.idEstrella = ide)
    this.tripulanteService.getRol().subscribe(r => this.rol = r);
  }

  asignarPrecio(FO: number, FD: number, stock: number) {
    this.precioUnitarioVenta = Math.round(FD / stock + 1)
    this.precioUnitarioCompra = Math.round(FO / stock + 1)
  }

  actualizarCantidad(newValue: number) {
    this.cantidad = newValue
    this.campoDeshabilitado = true;
    this.precioFinalVenta = this.cantidad * this.precioUnitarioVenta
    this.precioFinalCompra = this.cantidad * this.precioUnitarioCompra
    this.isVisible = !this.isVisible;
  }

  actualizarDatosCompra(volumen: number) {
    this.stockNuevoP = this.PxP.stock - this.cantidad
    this.PxPService.modificarStock(this.stockNuevoP, this.idPlaneta, this.idProducto).subscribe(response => {
      console.log('Datos actualizados con éxito', response);
    },
      error => {
        console.error('Error al actualizar los datos', error);
      });
    this.stockNuevoN = this.bodega.stock + this.cantidad
    this.bodegaService.modificarStock(this.stockNuevoN, this.idNave, this.idProducto).subscribe(response => {
      console.log('Datos actualizados con éxito', response);
    },
      error => {
        console.error('Error al actualizar los datos', error);
      });
    this.dinero = this.dinero - this.precioFinalCompra
    this.naveService.modificarDinero(this.idNave, this.dinero).subscribe(response => {
      console.log('Datos actualizados con éxito', response);
    },
      error => {
        console.error('Error al actualizar los datos', error);
      });
    this.vol = this.vol + volumen * this.cantidad
    this.cargaService.setCarga(this.vol)

    if (this.rol == "CAPITAN") {
      if (this.dinero <= 0 || this.vol > this.cargaNave) {
        this.router.navigate(['/tipoNave/view', this.idNave.toString()]);
      }
      else {
        this.router.navigate(['/planeta/list', this.idEstrella]);
      }
    }
    else{
      if (this.dinero <= 0) {
        this.router.navigate(['/tipoNave/view/com', this.idNave.toString()]);
      }
      else {
        this.router.navigate(['/planeta/list', this.idEstrella]);
      }
    }
  }

  actualizarDatosVenta(volumen: number) {
    this.stockNuevoP = this.PxP.stock + this.cantidad
    this.PxPService.modificarStock(this.stockNuevoP, this.idPlaneta, this.idProducto).subscribe(response => {
      console.log('Datos actualizados con éxito', response);
    },
      error => {
        console.error('Error al actualizar los datos', error);
      });
    this.stockNuevoN = this.bodega.stock - this.cantidad
    this.bodegaService.modificarStock(this.stockNuevoN, this.idNave, this.idProducto).subscribe(response => {
      console.log('Datos actualizados con éxito', response);
    },
      error => {
        console.error('Error al actualizar los datos', error);
      });
    this.dinero = this.dinero + this.precioFinalVenta
    this.naveService.modificarDinero(this.idNave, this.dinero).subscribe(response => {
      console.log('Datos actualizados con éxito', response);
    },
      error => {
        console.error('Error al actualizar los datos', error);
      });

      if (this.rol == "CAPITAN") {
        if (this.dinero <= 0 || this.vol > this.cargaNave) {
          this.router.navigate(['/tipoNave/view', this.idNave.toString()]);
        }
        else {
          this.router.navigate(['/planeta/list', this.idEstrella]);
        }
      }
      else{
        if (this.dinero <= 0) {
          this.router.navigate(['/tipoNave/view/com', this.idNave.toString()]);
        }
        else {
          this.router.navigate(['/planeta/list', this.idEstrella]);
        }
      }
  }

}
