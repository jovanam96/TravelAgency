import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './auth/login/login.component';
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HotelComponent } from './hotel/hotel/hotel.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MainNavBarComponent } from './main-nav-bar/main-nav-bar.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { TokenInterceptor } from './auth/token.interceptor';
import { SearchOfferComponent } from './offer/search-offer/search-offer.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { AllHotelsComponent } from './hotel/all-hotels/all-hotels.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { OfferComponent } from './offer/offer/offer.component';
import { MatTableModule } from '@angular/material/table';
import { OfferItemsTableComponent } from './offer/offer/offer-items-table/offer-items-table.component';
import { OfferItemComponent } from './offer/offer/offer-item/offer-item.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { DatePipe } from '@angular/common';
import { AllReservationsComponent } from './reservation/all-reservations/all-reservations.component';
import { ClientComponent } from './reservation/reservation/client/client.component';
import { ReservationComponent } from './reservation/reservation/reservation.component';
import { OfferItemComponent1 } from './reservation/reservation/offer-item-1/offer-item-1.component';
import { OfferDetailsComponent } from './offer/offer-details/offer-details.component';
import { ReservationModel } from './shared/models/reservationModel';
import { RegistrationComponent } from './registration/registration.component';
import { ProfileComponent } from './profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    HotelComponent,
    MainNavBarComponent,
    AllHotelsComponent,
    SearchOfferComponent,
    OfferComponent,
    OfferItemsTableComponent,
    OfferItemComponent,
    AllReservationsComponent,
    ClientComponent,
    ReservationComponent,
    OfferItemComponent1,
    OfferDetailsComponent,
    RegistrationComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatGridListModule,
    MatCardModule,
    MatTableModule,
    MatDialogModule,
    MatPaginatorModule,
    MatSortModule,
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true},
    DatePipe,
    ReservationModel
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
