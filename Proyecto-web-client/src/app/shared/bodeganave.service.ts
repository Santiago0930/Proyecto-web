import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BodegaNave } from '../model/bodega-nave';
import { environment } from '../environments/environment.development';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BodeganaveService {

  constructor(
    private http: HttpClient
  ) {
  }

  private headers = new HttpHeaders(
    { "Content-Type": "application/json" }
  )
  
  listarStocks(id:number): Observable<BodegaNave[]> {
    return this.http.get<BodegaNave[]>(`${environment.serverUrl}/bodeganave/list/${id}`)
  }

  obtenerStock(idNave:number, idProducto:number): Observable<BodegaNave>{
    return this.http.get<BodegaNave>(`${environment.serverUrl}/bodeganave/${idNave}/${idProducto}`)
  }

  modificarStock(stockNuevo: number, idNave:number, idProducto:number){
    return this.http.patch(`${environment.serverUrl}/bodeganave/modificar/${idNave}/${idProducto}`, stockNuevo , { headers: this.headers }) 
  }

}
