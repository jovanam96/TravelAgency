import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RoomTypeModel } from '../models/roomTypeModel';
import { config } from 'src/app/config';

@Injectable({
  providedIn: 'root'
})
export class RoomTypeServiceService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<RoomTypeModel[]> {
    return this.http.get<RoomTypeModel[]>(`${config.apiUrl}/roomType/all`);
  }

  getOne(roomTypeId: number): Observable<RoomTypeModel> {
    return this.http.get<RoomTypeModel>(`${config.apiUrl}/roomType/all/` + roomTypeId);
  }
}
