import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tripulante } from '../model/tripulante';
import { Nave } from '../model/nave';
import { environment } from '../environments/environment.development';
import { Observable, BehaviorSubject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TripulanteService {

  private rol = new BehaviorSubject<String>('');

  constructor(
    private http: HttpClient
  ) {
  }

  private headers = new HttpHeaders(
    { "Content-Type": "application/json" }
  )

  obtenerNaveTripulante(Usuario:String): Observable<number> {
    return this.http.get<number>(`${environment.serverUrl}/tripulante/obtenerNave/${Usuario}`)
  }

  setRol(value: String) {
    this.rol.next(value);
  }

  getRol() {
    return this.rol.asObservable();
  }
}