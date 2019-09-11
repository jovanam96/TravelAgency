import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserProfile } from '../shared/models/userProfile';
import { UserProfileServiceService } from '../shared/services/user-profile-service.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  userProfile: UserProfile = new UserProfile();

  constructor(private userProfileService: UserProfileServiceService) { }

  ngOnInit() {
    this.userProfile = JSON.parse(localStorage.getItem('userProfile'));
  }

  updateProfile() {
    this.userProfileService.update(this.userProfile).subscribe(
      res => {
        this.userProfile = res;
        localStorage.removeItem('userProfile');
        localStorage.setItem('userProfile', JSON.stringify(this.userProfile));
        alert('An error occured while updating profile');
      }
    );
  }

}
