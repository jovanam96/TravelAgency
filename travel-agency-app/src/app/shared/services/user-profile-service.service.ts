import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { UserProfile } from '../models/userProfile';
import { config } from 'src/app/config';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserProfileServiceService {

  constructor(private http: HttpClient) { }

  register(userProfile: UserProfile): Observable<any> {
    return this.http.post(`${config.apiUrl}/userProfile/register`, userProfile);
  }

  confirmAccount(token: string): Observable<UserProfile> {
    const params = new HttpParams().set('token', token);
    return this.http.get<UserProfile>(`${config.apiUrl}/userProfile/confirm-account`, {params});
  }

  update(userProfile: UserProfile): Observable<UserProfile> {
    return this.http.put<UserProfile>(`${config.apiUrl}/userProfile/update`, userProfile);
  }

}
