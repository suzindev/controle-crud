import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Acessorio } from '../models/acessorio';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class AcessorioService {
  http = inject(HttpClient);

  API = environment.SERVIDOR + "/api/acessorio";

  constructor() { }

  findAll(): Observable<Acessorio[]> {
    return this.http.get<Acessorio[]>(this.API);
  }

  delete(id: number): Observable<string> {
    return this.http.delete<string>(this.API + "/" + id, { responseType: 'text' as 'json' });
  }

  save(acessorio: Acessorio): Observable<string> {
    return this.http.post<string>(this.API, acessorio, { responseType: 'text' as 'json' });
  }

  update(acessorio: Acessorio, id: number): Observable<string> {
    return this.http.put<string>(this.API + "/" + id, acessorio, { responseType: 'text' as 'json' });
  }

  findById(id: number): Observable<Acessorio> {
    return this.http.get<Acessorio>(this.API + "/" + id);
  }
}
