import { Component, OnInit, ViewChild } from '@angular/core';
import { ReservationModel } from 'src/app/shared/models/reservationModel';
import { ReservationServiceService } from 'src/app/shared/services/reservation-service.service';
import { MatTableDataSource } from '@angular/material/table';
import { OfferServiceService } from 'src/app/shared/services/offer-service.service';
import { OfferModel } from 'src/app/shared/models/offerModel';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { Router } from '@angular/router';
import { UserProfile } from 'src/app/shared/models/userProfile';

@Component({
  selector: 'app-all-reservations',
  templateUrl: './all-reservations.component.html',
  styleUrls: ['./all-reservations.component.css']
})
export class AllReservationsComponent implements OnInit {

  reservations: Array<ReservationModel> = new Array<ReservationModel>();
  displayedColumns = ['client.lastName', 'offerItem.offer.city.name', 'offerItem.offer.hotel.name',
    'offerItem.offer.dateFrom', 'offerItem.offer.dateTo', 'roomType', 'totalPrice'];
  dataSource = new MatTableDataSource(this.reservations);
  selectedRow;
  loggedUser: UserProfile;

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor(private reservationService: ReservationServiceService, private offerService: OfferServiceService,
              private router: Router) { }

  ngOnInit() {
    this.loggedUser = JSON.parse(localStorage.getItem('userProfile'));
    this.getReservations();
    this.ngAfterViewInit();
  }

  // tslint:disable-next-line: use-lifecycle-interface
  ngAfterViewInit(): void {
    setTimeout(() => {
      this.dataSource.sortingDataAccessor = this.sortingDataAccessor;
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
      this.dataSource.data = this.reservations;
    });
  }


  getReservations() {
    if (this.loggedUser.roles === 'ADMIN') {
      this.reservationService.getAll().subscribe(
        res => {
          this.reservations = res;
          for (const reservation of this.reservations) {
            reservation.offerItem.offer = new OfferModel();
            this.offerService.getOne(reservation.offerItem.offerItemId.offerId).subscribe(
              res1 => {
                reservation.offerItem.offer = res1;
              }
            );
          }
          this.dataSource = new MatTableDataSource(this.reservations);
        }
      );
    } else {
      this.reservationService.getByClient(this.loggedUser.person.personId).subscribe(
        res => {
          this.reservations = res;
          for (const reservation of this.reservations) {
            reservation.offerItem.offer = new OfferModel();
            this.offerService.getOne(reservation.offerItem.offerItemId.offerId).subscribe(
              res1 => {
                reservation.offerItem.offer = res1;
              }
            );
          }
          this.dataSource = new MatTableDataSource(this.reservations);
        }
      );
    }
  }

  openReservation(reservation: ReservationModel) {
    this.router.navigate(['reservation/' + reservation.reservationId]);
  }

  sortingDataAccessor(item, property) {
    if (property.includes('.')) {
      return property.split('.')
        .reduce((object, key) => object[key] || '', item);
    }
    return item[property];
  }
}
