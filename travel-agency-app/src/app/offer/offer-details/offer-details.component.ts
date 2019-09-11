import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OfferModel } from 'src/app/shared/models/offerModel';
import { OfferServiceService } from 'src/app/shared/services/offer-service.service';
import { ReservationModel } from 'src/app/shared/models/reservationModel';
import * as moment from 'moment';
import { UserProfile } from 'src/app/shared/models/userProfile';
import { AuthService } from 'src/app/auth/auth.service';
import { HotelModel } from 'src/app/shared/models/hotelModel';
import { HotelServiceService } from 'src/app/shared/services/hotel-service.service';
import { makeRe } from 'minimatch';

@Component({
  selector: 'app-offer-details',
  templateUrl: './offer-details.component.html',
  styleUrls: ['./offer-details.component.css']
})
export class OfferDetailsComponent implements OnInit {

  // offer: OfferModel = new OfferModel();
  hotel: HotelModel = new HotelModel();
  offers: Array<OfferModel> = new Array<OfferModel>();
  // reservation: ReservationModel = new ReservationModel();

  constructor(private courentRout: ActivatedRoute, private offerService: OfferServiceService,
              private router: Router, private reservation: ReservationModel, private authService: AuthService,
              private hotelService: HotelServiceService) { }

  ngOnInit() {
    const hotelId = this.courentRout.snapshot.paramMap.get('hotelId');
    this.hotelService.getOne(+hotelId).subscribe(
      res => this.hotel = res
    );
    this.offerService.getByHotel(+hotelId).subscribe(
      res => this.offers = res
    );
  }

  selectItem($event) {
    this.reservation.offerItem = $event;
    this.makeReservation();
  }

  makeReservation() {
    if (!this.authService.isLoggedIn()) {
      alert('You have to be logged in!');
    } else {
      const userProfile: UserProfile = JSON.parse(localStorage.getItem('userProfile'));
      this.reservation.client = userProfile.person;
      this.router.navigate(['/reservation']);
    }
  }
}


