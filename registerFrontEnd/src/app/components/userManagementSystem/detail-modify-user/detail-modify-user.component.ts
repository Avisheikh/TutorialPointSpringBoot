import { Component, OnInit } from '@angular/core';
import {DetailUserService} from "../../../services/userManagementSystem/detail-user.service";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {UserResponse} from "../../../common/UserResponse";
import {User} from "../../../common/User";
import {SaveUserService} from "../../../services/userManagementSystem/save-user.service";

@Component({
  selector: 'app-detail-modify-user',
  templateUrl: './detail-modify-user.component.html',
  styleUrls: ['./detail-modify-user.component.css']
})
export class DetailModifyUserComponent implements OnInit {

  userResponse: UserResponse = new UserResponse();
  getUser: User = new UserResponse();

  constructor(private detailModifyUser: DetailUserService, private saveModifyUser: SaveUserService, private route:ActivatedRoute) { }

  ngOnInit(): void
  {

    this.route.paramMap.subscribe(
      (params:ParamMap) =>
      {
        this.detailModifyUser.detailModifyUser(Number(params.get('id'))).subscribe(
          response => {console.log(response.user); this.userResponse=response; this.getUser = response.user},
          error => {console.log(error)}
        );
      }

    );
  }

  onSubmit()
  {
    console.log("dfsd");

    this.saveModifyUser.saveModifyUser(this.userResponse.id).subscribe
    (
      response =>
      {
        console.log(response);
        alert(response.responseMessage);
      },
      error =>
      {
        console.log(error);
        alert(error.responseMessage);
      }
    );

  }

}
