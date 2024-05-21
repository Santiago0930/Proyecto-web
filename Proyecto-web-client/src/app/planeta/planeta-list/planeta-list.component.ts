import { Component, Input } from '@angular/core';
import { Planeta } from '../../model/planeta';
import { PlanetaService } from '../../shared/planeta.service';
import { TipoNaveService } from '../../shared/tipo-nave.service';
import { TripulanteService } from '../../shared/tripulante.service';

@Component({
  selector: 'app-planeta-list',
  templateUrl: './planeta-list.component.html',
  styleUrl: './planeta-list.component.css'
})
export class PlanetaListComponent {
  planetas: Planeta[] = [];
  idTipoNave: number = 0;
  rol: String = '';

  constructor(
    private planetaService: PlanetaService,
    private naveService: TipoNaveService,
    private tripulanteService: TripulanteService,
  ) { }

  @Input()
  set id(id: number) {
    console.log("id", id)
    this.planetaService.listarPlanetas(id).subscribe(planeta => this.planetas = planeta)
    this.naveService.getIdTipoNave().subscribe(ID => this.idTipoNave = ID)
  }

  actualizarIdPlaneta(newValue: number) {
    this.planetaService.setIdPlaneta(newValue);
  }

  getRouterLink(): string[] {
    this.tripulanteService.getRol().subscribe(r => this.rol = r);
    if (this.rol == "CAPITAN") {
      return ['/estrella/list/cercanas', this.idTipoNave.toString()];
    }
    else
      return ['/tipoNave/view/com', this.idTipoNave.toString()];
  }
}
