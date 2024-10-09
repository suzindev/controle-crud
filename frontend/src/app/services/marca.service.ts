import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Marca } from '../models/marca';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MarcaService {
  http = inject(HttpClient);

  API = "http://localhost:8080/api/marca";

  constructor() { }

  findAll(): Observable<Marca[]> {
    return this.http.get<Marca[]>(this.API);
  }

  delete(id: number): Observable<string> {
    return this.http.delete<string>(this.API + "/" + id, { responseType: 'text' as 'json' });
  }

  save(marca: Marca): Observable<string> {
    return this.http.post<string>(this.API, marca, { responseType: 'text' as 'json' });
  }

  update(marca: Marca, id: number): Observable<string> {
    return this.http.put<string>(this.API + "/" + id, marca, { responseType: 'text' as 'json' });
  }

  findById(id: number): Observable<Marca> {
    return this.http.get<Marca>(this.API + "/" + id);
  }
}
