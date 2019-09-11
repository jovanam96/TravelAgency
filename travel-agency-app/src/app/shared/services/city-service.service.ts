import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CityModel } from '../models/cityModel';
import { config } from 'src/app/config';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CityServiceService {

  constructor(private http: HttpClient) { }

  public getAll(): Observable<CityModel[]> {
    return this.http.get<CityModel[]>(`${config.apiUrl}/city/all`);
  }
}
