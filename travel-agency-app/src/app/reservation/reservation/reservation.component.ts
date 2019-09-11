import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservationModel } from 'src/app/shared/models/reservationModel';
import { ReservationServiceService } from 'src/app/shared/services/reservation-service.service';
import { OfferModel } from 'src/app/shared/models/offerModel';
import { OfferServiceService } from 'src/app/shared/services/offer-service.service';
import { UserProfile } from 'src/app/shared/models/userProfile';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {

  // reservation: ReservationModel = new ReservationModel();
  loggedUser: UserProfile;

  constructor(private courentRout: ActivatedRoute, private reservationService: ReservationServiceService,
              private offerService: OfferServiceService, private router: Router, private reservation: ReservationModel) { }

  ngOnInit() {
    this.loggedUser = JSON.parse(localStorage.getItem('userProfile'));
    const reservationId = this.courentRout.snapshot.paramMap.get('reservationId');
    if (reservationId != null) {
      this.reservationService.getOne(+reservationId).subscribe(
        res => {
          this.reservation = res;
          this.reservation.offerItem.offer = new OfferModel();
          this.offerService.getOne(this.reservation.offerItem.offerItemId.offerId).subscribe(
            res1 => {
              this.reservation.offerItem.offer = res1;
            }
          );
        },
        err => {
          alert(err.error.message);
          this.router.navigate(['/all-reservations']);
        }
      );
    } else {
      this.reservation.offerItem.offer = new OfferModel();
      this.offerService.getOne(this.reservation.offerItem.offerItemId.offerId).subscribe(
        res1 => {
          this.reservation.offerItem.offer = res1;
        }
      );
    }

  }

  deleteReservation() {
    this.reservationService.deleteReservation(this.reservation.reservationId).subscribe(
      res => {
        if (confirm('Are you sure you want to cancel reservation?')) {
          this.router.navigate(['/all-reservations']);
        }
      }
    );
  }

  makeReservation() {
    this.reservationService.saveReservation(this.reservation).subscribe(
      res => {
        alert('Thanks for making reservation!');
        this.router.navigate(['/home']);
      },
      err => alert('An error has occured')
    );
  }

}
