import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './auth/auth.guard';
import { AllHotelsComponent } from './hotel/all-hotels/all-hotels.component';
import { HotelComponent } from './hotel/hotel/hotel.component';
import { SearchOfferComponent } from './offer/search-offer/search-offer.component';
import { OfferComponent } from './offer/offer/offer.component';
import { OfferItemComponent } from './offer/offer/offer-item/offer-item.component';
import { AllReservationsComponent } from './reservation/all-reservations/all-reservations.component';
import { ReservationComponent } from './reservation/reservation/reservation.component';
import { OfferDetailsComponent } from './offer/offer-details/offer-details.component';
import { RegistrationComponent } from './registration/registration.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'login/:token',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegistrationComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'hotel',
    component: HotelComponent
  },
  {
    path: 'hotel/:hotelId',
    component: HotelComponent
  },
  {
    path: 'all-hotels',
    component: AllHotelsComponent
  },
  {
    path: 'all-hotels/:cityId/:name',
    component: AllHotelsComponent
  },
  {
    path: 'offer',
    component: OfferComponent
  },
  {
    path: 'offer/:offerId',
    component: OfferComponent
  },
  {
    path: 'search-offer',
    component: SearchOfferComponent
  },
  {
    path: 'offer-item',
    component: OfferItemComponent
  },
  {
    path: 'offer-details/:hotelId',
    component: OfferDetailsComponent
  },
  {
    path: 'all-reservations',
    component: AllReservationsComponent
  },
  {
    path: 'reservation',
    component: ReservationComponent
  },
  {
    path: 'reservation/:reservationId',
    component: ReservationComponent
  },
  {
    path: 'profile',
    component: ProfileComponent
  },
  {
    path: '',
    component: HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {enableTracing: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
