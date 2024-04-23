import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Planeta } from '../model/planeta';
import { environment } from '../environments/environment.development';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlanetaService {

  private idPlaneta = new BehaviorSubject<number>(0);

  constructor(
    private http: HttpClient
  ) {
  }

  private headers = new HttpHeaders(
    { "Content-Type": "application/json" }
  )

  listarPlanetas(id:number): Observable<Planeta[]> {
    return this.http.get<Planeta[]>(`${environment.serverUrl}/api/planeta/list/${id}`)
  }

  obtenerPlaneta(id: number): Observable<Planeta> {
    return this.http.get<Planeta>(`${environment.serverUrl}/api/planeta/${id}`)
  }

  setIdPlaneta(value: number) {
    this.idPlaneta.next(value);
  }

  getIdPlaneta() {
    return this.idPlaneta.asObservable();
  }
}


