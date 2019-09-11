import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { HotelModel } from 'src/app/shared/models/hotelModel';
import { Observable } from 'rxjs';
import { config } from '../../config';
import { CityModel } from '../models/cityModel';

@Injectable({
  providedIn: 'root'
})
export class HotelServiceService {

  constructor(private http: HttpClient) { }

  saveHotel(formData: FormData): Observable<HotelModel> {
    return this.http.post<HotelModel>(`${config.apiUrl}/hotel/new`, formData);
  }

  updateHotel(formData: FormData): Observable<HotelModel> {
    return this.http.put<HotelModel>(`${config.apiUrl}/hotel/update`, formData);
  }

  searchHotels(name: string, city: CityModel): Observable<HotelModel[]> {
    const params = new HttpParams()
      .set('name', name)
      .set('cityId', city.cityId.toString());
    return this.http.get<HotelModel[]>(`${config.apiUrl}/hotel/search`, { params });
  }

  deleteHotel(hotelId: number): Observable<any> {
    return this.http.delete(`${config.apiUrl}/hotel/delete/` + hotelId);
  }

  getOne(hotelId: number): Observable<HotelModel> {
    return this.http.get<HotelModel>(`${config.apiUrl}/hotel/` + hotelId);
  }

  getHotelsByCity(city: CityModel): Observable<HotelModel[]> {
    return this.http.get<HotelModel[]>(`${config.apiUrl}/hotel/city/` + city.cityId);
  }

}
