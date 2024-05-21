import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Producto } from '../model/producto';
import { environment } from '../environments/environment.development';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  constructor(
    private http: HttpClient
  ) {
  }

  private headers = new HttpHeaders(
    { "Content-Type": "application/json" }
  )

  listarProductos(): Observable<Producto[]> {
    return this.http.get<Producto[]>(`${environment.serverUrl}/producto/list`)
  }

  obtenerProducto(id: number): Observable<Producto> {
    return this.http.get<Producto>(`${environment.serverUrl}/producto/${id}`)
  }
}
