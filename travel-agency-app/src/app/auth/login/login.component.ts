import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from '../auth.service';
import { UserProfileServiceService } from 'src/app/shared/services/user-profile-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router, private authService: AuthService,
              private courentRout: ActivatedRoute, private userProfileService: UserProfileServiceService) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    });
    // const token = this.courentRout.snapshot.paramMap.get('token');
    let token;
    this.courentRout.queryParams.subscribe(
      params => token = params.token
    );
    this.userProfileService.confirmAccount(token).subscribe(
      res => console.log(res)
    );
  }

  get f() { return this.form.controls; }

  login() {
    if (this.form.valid) {
      this.authService.login(this.f.username.value, this.f.password.value);
    }
  }

}
