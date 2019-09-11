import { RoomTypeModel } from './roomTypeModel';
import { OfferModel } from './offerModel';
import { OfferItemId } from './offerItemId';

export class OfferItemModel {
    offer: OfferModel = new OfferModel();
    offerItemId: OfferItemId = new OfferItemId();
    roomType: RoomTypeModel = new RoomTypeModel();
    price: number;
    capacity: number;
}
