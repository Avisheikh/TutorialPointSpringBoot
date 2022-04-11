import { Component, OnInit } from '@angular/core';
import {ListUserService} from "../../../services/userManagementSystem/list-user.service";
import {UserResponse} from "../../../common/UserResponse";

@Component({
  selector: 'app-get-list-user',
  templateUrl: './get-list-user.component.html',
  styleUrls: ['./get-list-user.component.css']
})
export class GetListUserComponent implements OnInit {

  userList: UserResponse[];

  constructor(private listUserService:ListUserService) { }

  ngOnInit(): void
  {
    this.listUserService.getUser().subscribe
    (
      response =>
      {
        this.userList = response.getAllUser;
        console.log(this.userList);
      },
      error =>
      {
        console.log(error);
      }
    );
  }

}
