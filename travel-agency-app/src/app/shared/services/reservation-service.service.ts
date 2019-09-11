import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ReservationModel } from '../models/reservationModel';
import { config } from 'src/app/config';

@Injectable({
  providedIn: 'root'
})
export class ReservationServiceService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<ReservationModel[]> {
    return this.http.get<ReservationModel[]>(`${config.apiUrl}/reservation/all`);
  }

  getOne(reservationId: number): Observable<ReservationModel> {
    return this.http.get<ReservationModel>(`${config.apiUrl}/reservation/all/` + reservationId);
  }

  deleteReservation(reservationId: number): Observable<any> {
    return this.http.delete(`${config.apiUrl}/reservation/all/` + reservationId);
  }

  saveReservation(reservation: ReservationModel): Observable<ReservationModel> {
    return this.http.post<ReservationModel>(`${config.apiUrl}/reservation/new`, reservation);
  }

  getByClient(personId: number): Observable<ReservationModel[]> {
    return this.http.get<ReservationModel[]>(`${config.apiUrl}/reservation/all/client/` + personId);
  }

}
