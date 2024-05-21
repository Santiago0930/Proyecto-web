import { Component, Input } from '@angular/core';
import { Estrella } from '../../model/estrella';
import { EstrellaService } from '../../shared/estrella.service';
import { TipoNaveService } from '../../shared/tipo-nave.service';
import { Nave } from '../../model/nave';
import { TripulanteService } from '../../shared/tripulante.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-estrella-list',
  templateUrl: './estrella-list.component.html',
  styleUrls: ['./estrella-list.component.css'] // Corregido a styleUrls
})
export class EstrellaListComponent {

  estrellas: Estrella[] = [];
  idNave: number = 0
  nave: Nave = new Nave(0, 0, 0, 0, 0, 0)
  distancia: number = 0
  rol: String = ''
  idTipoNave: number = 0

  constructor(
    private estrellaService: EstrellaService,
    private naveService: TipoNaveService,
    private tripulanteService: TripulanteService,
    private router: Router
  ) { }

  @Input()
  set id(id: number) {
    console.log("id", id)
    this.estrellaService.listarEstrellas(id).subscribe(Estre => this.estrellas = Estre)
    this.naveService.getIdNave().subscribe(ID => this.idNave = ID)
    this.naveService.getIdTipoNave().subscribe(Idn => this.idTipoNave = Idn)
    this.naveService.buscarNave(this.idNave).subscribe(Nave => this.nave = Nave)
    this.tripulanteService.getRol().subscribe(r => this.rol = r);
  }

  getRouterLink(estrella: any) {
    console.log("ROL: ", this.rol)
    if (this.rol == "CAPITAN") {
      if (estrella.estado) {
        this.router.navigate(['/planeta/list', estrella.id]);
      } else {
        this.router.navigate(['/tipoNave/view', this.idNave.toString()]);
      }
    }
    else if (this.rol == "PILOTO"){
      this.router.navigate(['/tipoNave/view', this.idNave.toString()]);
    }
    else{
      this.router.navigate(['/default/path']);
    }
  }

  actualizarTiempoYcoordenadas(estrella: Estrella) {
    this.naveService.setIdEstrella(estrella.id);
    console.log("Id estrella:", estrella.id);
    this.distancia = Math.sqrt((this.nave.x - estrella.x) ** 2 + (this.nave.y - estrella.y) ** 2 + (this.nave.z - estrella.z) ** 2)
    this.nave.tiempo = this.nave.tiempo + this.distancia;

    this.naveService.actualizarTiempo(this.idNave, this.nave.tiempo).subscribe(response => {
      console.log('Datos actualizados con éxito', response);
    },
      error => {
        console.error('Error al actualizar los datos', error);
      });
    this.naveService.actualizarX(this.idNave, estrella.x).subscribe(response => {
      console.log('Datos actualizados con éxito', response);
    },
      error => {
        console.error('Error al actualizar los datos', error);
      });
    this.naveService.actualizarY(this.idNave, estrella.y).subscribe(response => {
      console.log('Datos actualizados con éxito', response);
    },
      error => {
        console.error('Error al actualizar los datos', error);
      });
    this.naveService.actualizarZ(this.idNave, estrella.z).subscribe(response => {
      console.log('Datos actualizados con éxito', response);
    },
      error => {
        console.error('Error al actualizar los datos', error);
      });
      this.getRouterLink(estrella);
  }
}
