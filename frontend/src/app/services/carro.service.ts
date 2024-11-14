import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Carro } from '../models/carro';
import { environment } from '../../environments/environment.development';
import { toRequest } from '../mapper/carroMapper';

@Injectable({
  providedIn: 'root'
})
export class CarroService {
  http = inject(HttpClient);

  API = environment.SERVIDOR + "/api/carro";

  constructor() { }

  findAll(): Observable<Carro[]> {
    return this.http.get<Carro[]>(this.API);
  }

  delete(id: number): Observable<string> {
    return this.http.delete<string>(this.API + "/" + id, { responseType: 'text' as 'json' });
  }

  save(carro: Carro): Observable<string> {
    const request = toRequest(carro);

    return this.http.post<string>(this.API, request, { responseType: 'text' as 'json' });
  }

  update(carro: Carro, id: number): Observable<string> {
    const request = toRequest(carro);

    return this.http.put<string>(this.API + "/" + id, request, { responseType: 'text' as 'json' });
  }

  findById(id: number): Observable<Carro> {
    return this.http.get<Carro>(this.API + "/" + id);
  }
}
