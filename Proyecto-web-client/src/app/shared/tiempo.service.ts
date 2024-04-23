import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TiempoService {

  private tiempo = new BehaviorSubject<number>(0);

  constructor(
    private http: HttpClient
  ) {
  }

  private headers = new HttpHeaders(
    { "Content-Type": "application/json" }
  )

  setTiempo(value: number) {
    this.tiempo.next(value);
  }

  getTiempo() {
    return this.tiempo.asObservable();
  }

}
