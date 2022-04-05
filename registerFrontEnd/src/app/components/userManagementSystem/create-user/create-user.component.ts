import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {CreateUserService} from "../../../services/userManagementSystem/create-user.service";
import {CreateUser} from "../../../common/create-user";

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  private submitted:boolean = false ;

  //check if it works on onSubmit button
  createUser: FormGroup = new FormGroup
  ({
          userName: new FormControl(''),
          pan: new FormControl(''),
          email: new FormControl(''),
          password: new FormControl(''),
          phoneNumber: new FormControl('')
    }
  );

  constructor(private createUserService:CreateUserService) { }

  ngOnInit(): void {
  }

  onSubmit()
  {
    console.log(this.submitted)

    // create user object
    let user = new CreateUser();

    // populate value
    user.userName = this.createUser.controls['userName'].value;
    user.pan = this.createUser.controls['pan'].value;
    user.email = this.createUser.controls['email'].value;
    user.password = this.createUser.controls['password'].value;
    user.phoneNumber = this.createUser.controls['phoneNumber'].value;

    // send input data to backend
    this.createUserService.userCreate(user).subscribe
    (
      response => {alert(`success`), console.log(response)},
      error => {alert(`failed`), console.log(error)}
    );

  }

}
