import { Injectable } from '@angular/core';
import { OfferModel } from '../models/offerModel';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { config } from 'src/app/config';
import { CityModel } from '../models/cityModel';
import { RoomTypeModel } from '../models/roomTypeModel';
import { HotelModel } from '../models/hotelModel';
import { DatePipe } from '@angular/common';
import { OfferComponent } from 'src/app/offer/offer/offer.component';

@Injectable({
  providedIn: 'root'
})
export class OfferServiceService {

  constructor(private http: HttpClient, private datePipe: DatePipe) { }

  public saveOffer(offer: OfferModel): Observable<OfferModel> {
    return this.http.post<OfferModel>(`${config.apiUrl}/offer/new`, offer);
  }

  public updateOffer(offer: OfferModel): Observable<OfferModel> {
    return this.http.put<OfferModel>(`${config.apiUrl}/offer/update`, offer);
  }

  public getAll(): Observable<OfferModel[]> {
    return this.http.get<OfferModel[]>(`${config.apiUrl}/offer/all`);
  }

  public getByHotel(hotelId: number): Observable<OfferModel[]> {
    return this.http.get<OfferModel[]>(`${config.apiUrl}/offer/hotel/` + hotelId);
  }

  public searchOffers(city: CityModel, dateFrom: Date, dateTo: Date): Observable<OfferModel[]> {
    let params = new HttpParams()
      .set('cityId', city.cityId.toString())
      .set('dateFrom', this.datePipe.transform(dateFrom, 'yyyy-MM-dd'))
      .set('dateTo', this.datePipe.transform(dateTo, 'yyyy-MM-dd'));
    if (typeof dateFrom === 'undefined' || dateFrom == null) {
      params = params.delete('dateFrom');
    }
    if (typeof dateTo === 'undefined' || dateTo == null) {
      params = params.delete('dateTo');
    }
    return this.http.get<OfferModel[]>(`${config.apiUrl}/offer/search`, { params });
  }

  public getOne(offerId: number): Observable<OfferModel> {
    return this.http.get<OfferModel>(`${config.apiUrl}/offer/all/` + offerId);
  }

}
