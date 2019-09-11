import { Component, OnInit, Injectable } from '@angular/core';
import { CityServiceService } from 'src/app/shared/services/city-service.service';
import { CityModel } from 'src/app/shared/models/cityModel';
import { HotelModel } from 'src/app/shared/models/hotelModel';
import { HotelServiceService } from 'src/app/shared/services/hotel-service.service';
import { OfferModel } from 'src/app/shared/models/offerModel';
import { BehaviorSubject } from 'rxjs';
import { OfferItemModel } from 'src/app/shared/models/offerItemModel';
import { OfferServiceService } from 'src/app/shared/services/offer-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { isNgTemplate } from '@angular/compiler';

@Component({
  selector: 'app-offer',
  templateUrl: './offer.component.html',
  styleUrls: ['./offer.component.css']
})
export class OfferComponent implements OnInit {

  cities: Array<CityModel> = new Array<CityModel>();
  hotels: Array<HotelModel> = new Array<HotelModel>();
  selectedCity: CityModel = new CityModel();
  selectedHotel: HotelModel = new HotelModel();
  offer: OfferModel = new OfferModel();

  constructor(private cityService: CityServiceService, private hotelService: HotelServiceService,
              private offerService: OfferServiceService, private courentRout: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.getCities();
    const offerId = this.courentRout.snapshot.paramMap.get('offerId');
    if (offerId != null) {
      this.offerService.getOne(+offerId).subscribe(
        res => {
          this.offer = res;
          this.selectedCity = this.offer.city;
          this.selectedHotel = this.offer.hotel;
        },
        err => {
          alert(err.error.message);
          this.router.navigate(['/all-offers']);
        }
      );
    } else {
      this.selectedCity = new CityModel();
      this.selectedHotel = new HotelModel();
    }
  }

  getCities() {
    this.cityService.getAll().subscribe(
      res => this.cities = res
    );
  }

  getHotels() {
    this.hotelService.getHotelsByCity(this.selectedCity).subscribe(
      res => this.hotels = res
    );
  }

  updateItems($event) {
    this.offer.items = $event;
  }

  saveOrUpdateOffer() {
    this.offer.city = this.selectedCity;
    this.offer.hotel = this.selectedHotel;
    if (typeof this.offer.offerId === 'undefined') {
      this.offerService.saveOffer(this.offer).subscribe(
        res => {
          alert('Offer has been successfuly saved!');
          this.offer = new OfferModel();
          this.selectedCity = new CityModel();
          this.selectedHotel = new HotelModel();
        },
        err => alert(err.error.message)
      );
    } else {

      this.offerService.updateOffer(this.offer).subscribe(
        res => {
          alert('Offer has been successfully updated!');
          this.router.navigate(['/all-offers']);
        },
        err => alert(err.message)
      );
    }
  }
}
