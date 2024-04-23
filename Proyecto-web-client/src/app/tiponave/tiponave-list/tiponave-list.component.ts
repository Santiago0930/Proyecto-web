import { Component } from '@angular/core';
import { TipoNave } from '../../model/tipo-nave';
import { TipoNaveService } from '../../shared/tipo-nave.service';
import { TiempoService } from '../../shared/tiempo.service';

@Component({
  selector: 'app-tiponave-list',
  templateUrl: './tiponave-list.component.html',
  styleUrl: './tiponave-list.component.css'
})
export class TiponaveListComponent {

  tiponaves: TipoNave[] = []
  tiempo: number = 0
  campoDeshabilitado: boolean = false;

  constructor(
    private tipoNaveService: TipoNaveService,
    private tiempoService: TiempoService
  ) { }

  ngOnInit(): void {
    this.tipoNaveService.listarTipoNaves().subscribe(tipoNaves => this.tiponaves = tipoNaves)
  }  

  actualizarTiempo(newValue: number) {
    this.tiempoService.setTiempo(newValue);
    this.campoDeshabilitado = true; 
  }
}
