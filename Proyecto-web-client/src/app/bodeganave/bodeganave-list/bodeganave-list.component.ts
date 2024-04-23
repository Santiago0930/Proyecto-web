import { BodeganaveService } from './../../shared/bodeganave.service';
import { Component } from '@angular/core';
import { BodegaNave } from '../../model/bodega-nave';

@Component({
  selector: 'app-bodeganave-list',
  templateUrl: './bodeganave-list.component.html',
  styleUrl: './bodeganave-list.component.css'
})
export class BodeganaveListComponent {

  bodegas: BodegaNave[]= [];

  constructor(
    private bodegaNaveService: BodeganaveService,
  ){}

}
