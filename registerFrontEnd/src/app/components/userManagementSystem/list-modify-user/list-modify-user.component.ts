import { Component, OnInit } from '@angular/core';
import {ListModifyUserService} from "../../../services/userManagementSystem/list-modify-user.service";
import {UserResponse} from "../../../common/UserResponse";

@Component({
  selector: 'app-list-modify-user',
  templateUrl: './list-modify-user.component.html',
  styleUrls: ['./list-modify-user.component.css']
})
export class ListModifyUserComponent implements OnInit {

  userResponse: UserResponse[];

  constructor(private modifyService:ListModifyUserService) { }

  ngOnInit(): void {

    this.modifyService.getModifyUser().subscribe(
      response =>
      {
        console.log(response.listModifyUser);
        this.userResponse=response.listModifyUser;

        console.log(this.userResponse)

      },
      error =>
      {
        console.log(error);
      }
    );

  }

}
