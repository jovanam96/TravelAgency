import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { config } from '../config';
import { Router } from '@angular/router';
import { UserProfile } from '../shared/models/userProfile';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly JWT_TOKEN = 'JWT_TOKEN';
  private loggedUser: string;

  constructor(private http: HttpClient, private router: Router) { }

  login(username: string, password: string) {
    const contentHeader = new HttpHeaders({ 'Content-Type': 'application/json' });
    this.http.post<any>(`${config.apiUrl}/login`, { username, password },
      { headers: contentHeader, observe: 'response' }).subscribe(
        (resp) => {
          this.storeToken(resp.headers.get('Authorization').slice(7));
          this.storeUserProfile(resp.body);
          this.router.navigate(['/home']);
        },
        (err) => alert('Wrong username or password!')
      );
  }

  isLoggedIn() {
    return !!this.getJwtToken();
  }

  doLoginUser(loggedUser: string, token: string) {
    this.loggedUser = loggedUser;
    this.storeToken(token);
  }

  storeToken(token: string) {
    localStorage.setItem(this.JWT_TOKEN, token);
  }

   getJwtToken(): string {
    return localStorage.getItem(this.JWT_TOKEN);
  }

  logOut() {
    localStorage.removeItem(this.JWT_TOKEN);
    localStorage.removeItem('userProfile');
    this.router.navigate(['/home']);
  }

  storeUserProfile(userProfile: UserProfile) {
    localStorage.setItem('userProfile', JSON.stringify(userProfile));
  }

}
