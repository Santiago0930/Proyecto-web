import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Estrella } from '../model/estrella';
import { environment } from '../environments/environment.development';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EstrellaService {

  constructor(
    private http: HttpClient
  ) {
  }

  private headers = new HttpHeaders(
    { "Content-Type": "application/json" }
  )

  listarEstrellas(id:number): Observable<Estrella[]> {
    return this.http.get<Estrella[]>(`${environment.serverUrl}/api/estrella/list/cercanas/${id}`)
  }
}
