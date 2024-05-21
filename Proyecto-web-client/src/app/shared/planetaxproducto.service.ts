import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { PlanetaXProducto } from '../model/planeta-xproducto';
import { environment } from '../environments/environment.development';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlanetaxproductoService {

  constructor(
    private http: HttpClient
  ) {
  }

  private headers = new HttpHeaders(
    { "Content-Type": "application/json" }
  )

  listarPxP(id:number): Observable<PlanetaXProducto[]> {
    return this.http.get<PlanetaXProducto[]>(`${environment.serverUrl}/PxP/list/${id}`)
  }

  precioUnitarioVenta(id:number): Observable<number[]> {
    return this.http.get<number[]>(`${environment.serverUrl}/PxP/listpreciov/${id}`)
  }

  precioUnitarioCompra(id:number): Observable<number[]> {
    return this.http.get<number[]>(`${environment.serverUrl}/PxP/listprecioc/${id}`)
  }

  obtenerPxP(idPlaneta:number, idProducto:number): Observable<PlanetaXProducto>{
    return this.http.get<PlanetaXProducto>(`${environment.serverUrl}/PxP/${idPlaneta}/${idProducto}`)
  }

  modificarStock(stockNuevo: number, idPlaneta: number, idProducto: number){
    const url = `${environment.serverUrl}/PxP/modificar/${idPlaneta}/${idProducto}`;
    return this.http.patch(url, stockNuevo, { headers: this.headers });
  }
}