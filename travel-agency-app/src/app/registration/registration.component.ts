import { Component, OnInit } from '@angular/core';
import { UserProfile } from '../shared/models/userProfile';
import { UserProfileServiceService } from '../shared/services/user-profile-service.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  userProfile: UserProfile = new UserProfile();

  constructor(private userProfileService: UserProfileServiceService) { }

  ngOnInit() {
  }

  register() {
    this.userProfileService.register(this.userProfile).subscribe(
      res => alert('Check your confirmation email at ' + this.userProfile.person.email),
      err => alert(err.error.message)
    );
  }

}
