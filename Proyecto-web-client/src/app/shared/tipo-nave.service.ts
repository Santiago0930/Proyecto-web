import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TipoNave } from '../model/tipo-nave';
import { Nave } from '../model/nave';
import { environment } from '../environments/environment.development';
import { Observable, BehaviorSubject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TipoNaveService {

  private idNave = new BehaviorSubject<number>(0);

  constructor(
    private http: HttpClient
  ) {
  }

  private headers = new HttpHeaders(
    { "Content-Type": "application/json" }
  )

  listarTipoNaves(): Observable<TipoNave[]> {
    return this.http.get<TipoNave[]>(`${environment.serverUrl}/api/tipoNave/list`)
  }

  buscarTipoNave(id: number): Observable<TipoNave> {
    return this.http.get<TipoNave>(`${environment.serverUrl}/api/tipoNave/${id}`)
  }

  buscarNave(id: number): Observable<Nave> {
    return this.http.get<Nave>(`${environment.serverUrl}/api/nave/${id}`)
  }

  obtenerDinero(id: number): Observable<number>{
    return this.http.get<number>(`${environment.serverUrl}/api/nave/dinero/${id}`)
  }

  modificarDinero(id:number,dineroNuevo: number){
    return this.http.patch(`${environment.serverUrl}/api/nave/modificar/${id}`, dineroNuevo, { headers: this.headers })
  }

  actualizarTiempo(id:number,tiempoNuevo: number){
    return this.http.patch(`${environment.serverUrl}/api/nave/actualizar/${id}`, tiempoNuevo, { headers: this.headers })
  }

  actualizarX(id:number,x: number){
    return this.http.patch(`${environment.serverUrl}/api/nave/actualizarx/${id}`, x, { headers: this.headers })
  }

  actualizarY(id:number,y: number){
    return this.http.patch(`${environment.serverUrl}/api/nave/actualizary/${id}`, y, { headers: this.headers })
  }

  actualizarZ(id:number,z: number){
    return this.http.patch(`${environment.serverUrl}/api/nave/actualizarz/${id}`, z, { headers: this.headers })
  }

  setIdNave(value: number) {
    this.idNave.next(value);
  }

  getIdNave() {
    return this.idNave.asObservable();
  }

}
