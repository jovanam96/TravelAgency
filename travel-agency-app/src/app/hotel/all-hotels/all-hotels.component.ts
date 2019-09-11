import { Component, OnInit } from '@angular/core';
import { HotelModel } from 'src/app/shared/models/hotelModel';
import { HotelServiceService } from 'src/app/shared/services/hotel-service.service';
import { CityModel } from 'src/app/shared/models/cityModel';
import { CityServiceService } from 'src/app/shared/services/city-service.service';
import { Router, ActivatedRoute } from '@angular/router';
import { UserProfile } from 'src/app/shared/models/userProfile';

@Component({
  selector: 'app-all-hotels',
  templateUrl: './all-hotels.component.html',
  styleUrls: ['./all-hotels.component.css']
})
export class AllHotelsComponent implements OnInit {

  hotels: Array<HotelModel> = new Array<HotelModel>();
  hotel: HotelModel = new HotelModel();
  cities: Array<CityModel> = new Array<CityModel>();
  loggedUser: UserProfile;

  constructor(private hotelService: HotelServiceService, private cityService: CityServiceService,
              private router: Router, private courentRoute: ActivatedRoute) { }

  ngOnInit() {
    this.loggedUser = JSON.parse(localStorage.getItem('userProfile'));
    const cityId = this.courentRoute.snapshot.queryParamMap.get('cityId');
    if (cityId != null) {
      this.hotel.city.cityId = +cityId;
    }
    const name = this.courentRoute.snapshot.queryParamMap.get('name');
    if (name != null) {
      this.hotel.name = name;
    }
    this.getCities();
    this.getHotels();
  }

  getHotels() {
    if (typeof this.hotel.city.cityId === 'undefined') {
      this.hotel.city = new CityModel();
    }
    this.hotelService.searchHotels(this.hotel.name, this.hotel.city).subscribe(
      res => this.hotels = res
    );
  }

  deleteHotel(hotelId: number) {
    this.hotelService.deleteHotel(hotelId).subscribe(
      res => alert('Hotel successfully deleted!'),
      err => alert('An error has occured!')
    );
    this.getHotels();
  }

  openForUpdate(hotelId: number) {
    this.router.navigate(['hotel/' + hotelId]);
  }

  getCities() {
    this.cityService.getAll().subscribe(
      res => {
        this.cities = res;
        this.cities.sort((a, b) => a.name.localeCompare(b.name));
      }
    );
  }

  openForDetails(hotelId: number) {
    this.router.navigate(['offer-details/' + hotelId]);
  }

}
