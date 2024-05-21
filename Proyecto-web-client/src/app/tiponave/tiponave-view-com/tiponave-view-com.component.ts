import { Component, Input } from '@angular/core';
import { TipoNave } from '../../model/tipo-nave';
import { Nave } from '../../model/nave';
import { TipoNaveService } from '../../shared/tipo-nave.service';
import { SistemaService } from '../../shared/sistema.service';
import { CargaService } from '../../shared/carga.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tiponave-view',
  templateUrl: './tiponave-view-com.component.html',
  styleUrls: ['./tiponave-view-com.component.css']
})
export class TiponaveViewComComponent {
  tiempo: number = 0;
  carga: number = 0;
  dinero:number = 0;
  idEstrella:number = 0;

  constructor(
    private tipoNaveService: TipoNaveService, 
    private sistemaService: SistemaService,
    private cargaService: CargaService,
    private router: Router,
  ) {
  }

  @Input()
  set id(id: number) {
    console.log("id", id);
    this.tipoNaveService.buscarTipoNave(id).subscribe(tiponave => this.tipoNave = tiponave);
    this.tipoNaveService.buscarNave(id).subscribe(nave => this.nave = nave);
    this.tipoNaveService.obtenerDinero(id).subscribe(din => this.dinero = din);
    this.sistemaService.obtenerTiempo().subscribe(time => this.tiempo = time );
    this.cargaService.getCarga().subscribe(cargas => this.carga = cargas);
  }

  obtenerIdEstrella() {
    this.tipoNaveService.getIdEstrella().subscribe(id => {
      this.idEstrella = id;
      this.router.navigate(["/planeta/list", this.idEstrella]);
    });
  }

  tipoNave: TipoNave = new TipoNave(0, "", 0.0, 0.0);
  nave: Nave = new Nave(0, 0, 0, 0, 0, 0);
}
