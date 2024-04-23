import { Component, Input } from '@angular/core';
import { Planeta } from '../../model/planeta';
import { PlanetaService } from '../../shared/planeta.service';

@Component({
  selector: 'app-planeta-list',
  templateUrl: './planeta-list.component.html',
  styleUrl: './planeta-list.component.css'
})
export class PlanetaListComponent {
  planetas: Planeta[] = [];

  constructor(
    private planetaService: PlanetaService, 
  )
  {}

  @Input()
   set id(id: number) {
    console.log("id", id)
    this.planetaService.listarPlanetas(id).subscribe(planeta => this.planetas = planeta)
   }

   actualizarIdPlaneta(newValue: number) {
    this.planetaService.setIdPlaneta(newValue);
  }
}
