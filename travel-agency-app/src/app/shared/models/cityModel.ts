import { StateModel } from './stateModel';

export class CityModel {
    cityId = 0;
    name: string;
    state: StateModel = new StateModel();
}
