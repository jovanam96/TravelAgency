import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { UserProfile } from '../shared/models/userProfile';

@Component({
  selector: 'app-main-nav-bar',
  templateUrl: './main-nav-bar.component.html',
  styleUrls: ['./main-nav-bar.component.css']
})
export class MainNavBarComponent implements OnInit {

  isLoggedIn: boolean;
  loggedUser: UserProfile;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.loggedUser = JSON.parse(localStorage.getItem('userProfile'));
    this.isLoggedIn = this.authService.isLoggedIn();
  }

  logOut() {
    this.isLoggedIn = false;
    this.authService.logOut();
  }

}
