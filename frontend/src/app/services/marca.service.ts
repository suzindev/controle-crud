import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Marca } from '../models/marca';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';
import { toRequest } from '../mapper/marcaMapper';

@Injectable({
  providedIn: 'root'
})
export class MarcaService {
  http = inject(HttpClient);

  API = environment.SERVIDOR + "/api/marca";

  constructor() { }

  findAll(): Observable<Marca[]> {
    return this.http.get<Marca[]>(this.API);
  }

  delete(id: number): Observable<string> {
    return this.http.delete<string>(this.API + "/" + id, { responseType: 'text' as 'json' });
  }

  save(marca: Marca): Observable<string> {
    const request = toRequest(marca);

    return this.http.post<string>(this.API, request, { responseType: 'text' as 'json' });
  }

  update(marca: Marca, id: number): Observable<string> {
    const request = toRequest(marca);

    return this.http.put<string>(this.API + "/" + id, request, { responseType: 'text' as 'json' });
  }

  findById(id: number): Observable<Marca> {
    return this.http.get<Marca>(this.API + "/" + id);
  }
}
