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
  private idTipoNave = new BehaviorSubject<number>(0);
  private idEstrella = new BehaviorSubject<number>(0);

  constructor(
    private http: HttpClient
  ) {
  }

  private headers = new HttpHeaders(
    { "Content-Type": "application/json" }
  )

  listarTipoNaves(): Observable<TipoNave[]> {
    return this.http.get<TipoNave[]>(`${environment.serverUrl}/tipoNave/list`)
  }

  obtenerCarga(id: number): Observable<number> {
    return this.http.get<number>(`${environment.serverUrl}/tipoNave/carga/${id}`)
  }

  buscarTipoNave(id: number): Observable<TipoNave> {
    return this.http.get<TipoNave>(`${environment.serverUrl}/tipoNave/${id}`)
  }

  obtenerIdTipoNave(id: number): Observable<number>{
    return this.http.get<number>(`${environment.serverUrl}/nave/obtenerTipo/${id}`)
  }

  buscarNave(id: number): Observable<Nave> {
    return this.http.get<Nave>(`${environment.serverUrl}/nave/${id}`)
  }

  obtenerDinero(id: number): Observable<number>{
    return this.http.get<number>(`${environment.serverUrl}/nave/dinero/${id}`)
  }

  modificarDinero(id:number,dineroNuevo: number){
    return this.http.patch(`${environment.serverUrl}/nave/modificar/${id}`, dineroNuevo, { headers: this.headers })
  }

  actualizarTiempo(id:number,tiempoNuevo: number){
    return this.http.patch(`${environment.serverUrl}/nave/actualizar/${id}`, tiempoNuevo, { headers: this.headers })
  }

  actualizarX(id:number,x: number){
    return this.http.patch(`${environment.serverUrl}/nave/actualizarx/${id}`, x, { headers: this.headers })
  }

  actualizarY(id:number,y: number){
    return this.http.patch(`${environment.serverUrl}/nave/actualizary/${id}`, y, { headers: this.headers })
  }

  actualizarZ(id:number,z: number){
    return this.http.patch(`${environment.serverUrl}/nave/actualizarz/${id}`, z, { headers: this.headers })
  }

  setIdNave(value: number) {
    this.idNave.next(value);
  }

  getIdNave() {
    return this.idNave.asObservable();
  }

  setIdEstrella(value: number) {
    this.idEstrella.next(value);
  }

  getIdEstrella() {
    return this.idEstrella.asObservable();
  }

  setIdTipoNave(value: number) {
    this.idTipoNave.next(value);
  }

  getIdTipoNave() {
    return this.idTipoNave.asObservable();
  }

}
