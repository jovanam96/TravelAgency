import { Component, OnInit, Input, Output, EventEmitter, OnChanges } from '@angular/core';
import { CityModel } from '../../shared/models/cityModel';
import { CityServiceService } from '../../shared/services/city-service.service';
import { RoomTypeServiceService } from '../../shared/services/room-type-service.service';
import { OfferModel } from 'src/app/shared/models/offerModel';
import { OfferServiceService } from 'src/app/shared/services/offer-service.service';
import { Router, NavigationExtras } from '@angular/router';
import { DatePipe } from '@angular/common';
import * as moment from 'moment';


@Component({
  selector: 'app-search-offer',
  templateUrl: './search-offer.component.html',
  styleUrls: ['./search-offer.component.css'],
})
export class SearchOfferComponent implements OnInit {

  cities: Array<CityModel> = this.getCities();
  offers: Array<OfferModel> = new Array<OfferModel>();
  @Input() offer: OfferModel = new OfferModel();
  @Output() searchOffersEvent = new EventEmitter();
  minDateFrom = new Date();

ngOnInit() {
  }

constructor(private cityService: CityServiceService, private roomTypeService: RoomTypeServiceService,
            private offerService: OfferServiceService, private router: Router, private datePipe: DatePipe) { }

getOffers() {
    this.offerService.searchOffers(this.offer.city, this.offer.dateFrom, this.offer.dateTo).subscribe(
      res => this.offers = res,
      err => alert('An error has occured')
    );
  }

getCities(): Array<CityModel> {
    this.cityService.getAll().subscribe(
      res => {
        this.cities = res;
        this.cities.sort((a, b) => a.name.localeCompare(b.name));
      }
    );
    return this.cities;
  }

searchOffers() {
    this.searchOffersEvent.emit(this.offer);
    this.router.navigate(['/all-offers/' + this.offer.city.cityId
                         + '/' + this.datePipe.transform(this.offer.dateFrom)
                         + '/' + this.datePipe.transform(this.offer.dateTo)]);
  }

  minDateTo() {
    if (typeof this.offer.dateFrom === 'undefined') {
      return new Date();
    } else {
      return this.offer.dateFrom;
    }
  }

  readonly() {
    if (typeof this.offer.dateFrom === 'undefined' || this.offer.dateFrom == null) {
      return true;
    } else {
      return false;
    }
  }
}
