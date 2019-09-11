import { CityModel } from './cityModel';
import { HotelModel } from './hotelModel';
import { OfferItemModel } from './offerItemModel';

export class OfferModel {
    offerId: number;
    dateFrom: Date;
    dateTo: Date;
    city: CityModel = new CityModel();
    hotel: HotelModel = new HotelModel();
    items: Array<OfferItemModel> = new Array<OfferItemModel>();
}
