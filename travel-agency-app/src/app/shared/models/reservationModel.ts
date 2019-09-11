import { ClientModel } from './clientModel';
import { OfferItemModel } from './offerItemModel';
import { Injectable } from '@angular/core';

@Injectable()
export class ReservationModel {
    reservationId: number;
    creationDate: Date = new Date();
    client: ClientModel = new ClientModel();
    offerItem: OfferItemModel = new OfferItemModel();

}

