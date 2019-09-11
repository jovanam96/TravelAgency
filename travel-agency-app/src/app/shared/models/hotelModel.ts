import { CityModel } from './cityModel';

export class HotelModel {
    hotelId: number;
    name = '';
    adress: string;
    phoneNumber: string;
    email: string;
    description: string;
    city: CityModel = new CityModel();
    fileName: string;
    image: any;
}
