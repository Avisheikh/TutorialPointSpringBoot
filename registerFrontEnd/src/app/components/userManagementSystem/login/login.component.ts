import { Component, OnInit } from '@angular/core';
import {LoginUserService} from "../../../services/userManagementSystem/login-user.service";
import {Login} from "../../../common/login";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  loginUserDetail: FormGroup = new FormGroup(
    {
      email: new FormControl(''),
      password: new FormControl('')
    }
  );


  constructor(private loginService:LoginUserService) { }

  ngOnInit(): void {
  }

  onLogin()
  {

    let loginDetail = new Login();
    loginDetail.email = this.loginUserDetail.controls['email'].value;
    loginDetail.password = this.loginUserDetail.controls['password'].value;

    console.log(loginDetail.email);

    // login post
    this.loginService.login(loginDetail).subscribe(response =>
    {
      alert(response.responseMessage);
      console.log(response.responseMessage);
      console.log(response);
    },
      error => {console.log(error);}

    );

  }

}
