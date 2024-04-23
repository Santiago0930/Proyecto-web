import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CargaService {

  private carga = new BehaviorSubject<number>(0);

  constructor(
    private http: HttpClient
  ) {
  }

  private headers = new HttpHeaders(
    { "Content-Type": "application/json" }
  )

  setCarga(value: number) {
    this.carga.next(value);
  }

  getCarga() {
    return this.carga.asObservable();
  }

}
