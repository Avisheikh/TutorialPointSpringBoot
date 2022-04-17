import { Component, OnInit } from '@angular/core';
import {UserResponse} from "../../../common/UserResponse";
import {DetailUserService} from "../../../services/userManagementSystem/detail-user.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {FormControl, FormGroup, Validator, Validators} from "@angular/forms";
import {CreateUser} from "../../../common/create-user";

@Component({
  selector: 'app-get-detail-user',
  templateUrl: './get-detail-user.component.html',
  styleUrls: ['./get-detail-user.component.css']
})
export class GetDetailUserComponent implements OnInit {

  getUserDetail: UserResponse = new UserResponse();

  updateUser: FormGroup = new FormGroup
  (
    {
      userName: new FormControl(''),
      email: new FormControl(''),
      password: new FormControl(''),
      phoneNumber: new FormControl(''),
      pan: new FormControl('')
    }
  );

  constructor(private route:ActivatedRoute, private detailService:DetailUserService, private router:Router) { }

  ngOnInit(): void {

    this.route.paramMap.subscribe(
      (params:ParamMap) => {
        let id = Number(params.get('id'));
        this.detailService.detailUser(id).subscribe (
          response => {
            console.log(response);
            this.getUserDetail = response;
          }, error => {
            alert(error);
          });
      });
  }

  onModify()
  {

    //create user object
    let user = new CreateUser();

    // populate value
    user.userName = this.updateUser.controls['userName'].value;
    user.pan = this.updateUser.controls['pan'].value;
    user.phoneNumber = this.updateUser.controls['phoneNumber'].value;
    user.pan = this.updateUser.controls['pan'].value;
    user.email = this.updateUser.controls['email'].value;

    // send input data to backend
    let id = this.getUserDetail.id;

    console.log(user)

    this.detailService.modifyUser(id,user).subscribe
    (
      response =>
      {
        console.log(response);
        alert(response.responseMessage);
      },
      error =>
      {
        console.log(error);
      }
    );

    this.router.navigate(['list-modify-user']);
  }

}
