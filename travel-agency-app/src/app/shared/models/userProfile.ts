import { ClientModel } from './clientModel';

export class UserProfile {
    username: string;
    password: string;
    roles: string;
    person: ClientModel = new ClientModel();
}
