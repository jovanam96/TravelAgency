import { Component, OnInit } from '@angular/core';
import { CityModel } from '../shared/models/cityModel';
import { OfferModel } from '../shared/models/offerModel';
import { CityServiceService } from '../shared/services/city-service.service';
import { OfferServiceService } from '../shared/services/offer-service.service';
import { RoomTypeServiceService } from '../shared/services/room-type-service.service';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';
import { HotelModel } from '../shared/models/hotelModel';
import { HotelServiceService } from '../shared/services/hotel-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  cities: Array<CityModel> = new Array<CityModel>();
  hotel: HotelModel = new HotelModel();

  constructor(private cityService: CityServiceService, private roomTypeService: RoomTypeServiceService,
              private hotelService: HotelServiceService, private router: Router) { }

  ngOnInit() {
    this.getCities();
  }

  getHotels() {
    if (typeof this.hotel.city === 'undefined') {
      this.hotel.city = new CityModel();
    }
    this.router.navigate(['/all-hotels'], {queryParams: {cityId: this.hotel.city.cityId, name: this.hotel.name}});
  }

  getCities() {
    this.cityService.getAll().subscribe(
      res => {
        this.cities = res;
        this.cities.sort((a, b) => a.name.localeCompare(b.name));
      }
    );
  }

}


