import { Component, Input } from '@angular/core';
import { TipoNave } from '../../model/tipo-nave';
import { Nave } from '../../model/nave';
import { TipoNaveService } from '../../shared/tipo-nave.service';
import { TiempoService } from '../../shared/tiempo.service';
import { CargaService } from '../../shared/carga.service';

@Component({
  selector: 'app-tiponave-view',
  templateUrl: './tiponave-view.component.html',
  styleUrls: ['./tiponave-view.component.css']
})
export class TiponaveViewComponent {
  tiempo: number = 0;
  carga: number = 0;
  dinero:number = 0;

  constructor(
    private tipoNaveService: TipoNaveService, 
    private tiempoService: TiempoService,
    private cargaService: CargaService,
  ) {
  }

  @Input()
  set id(id: number) {
    console.log("id", id);
    this.tipoNaveService.buscarTipoNave(id).subscribe(tiponave => this.tipoNave = tiponave);
    this.tipoNaveService.buscarNave(id).subscribe(nave => this.nave = nave);
    this.tipoNaveService.obtenerDinero(id).subscribe(din => this.dinero = din);
    this.tiempoService.getTiempo().subscribe(time => this.tiempo = time );
    this.cargaService.getCarga().subscribe(cargas => this.carga = cargas);
  }

  actualizarId(newValue: number) {
    this.tipoNaveService.setIdNave(newValue);
  }

  tipoNave: TipoNave = new TipoNave(0, "", 0.0, 0.0);
  nave: Nave = new Nave(0, 0, 0, 0, 0, 0);
}
