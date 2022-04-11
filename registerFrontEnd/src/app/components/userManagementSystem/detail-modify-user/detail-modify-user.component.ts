import { Component, OnInit } from '@angular/core';
import {DetailUserService} from "../../../services/userManagementSystem/detail-user.service";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {UserResponse} from "../../../common/UserResponse";

@Component({
  selector: 'app-detail-modify-user',
  templateUrl: './detail-modify-user.component.html',
  styleUrls: ['./detail-modify-user.component.css']
})
export class DetailModifyUserComponent implements OnInit {

  userResponse: UserResponse = new UserResponse();

  constructor(private detailModifyUser: DetailUserService, private route:ActivatedRoute) { }

  ngOnInit(): void
  {

    this.route.paramMap.subscribe(
      (params:ParamMap) =>
      {
        this.detailModifyUser.detailModifyUser(Number(params.get('id'))).subscribe(
          response => {console.log(response); this.userResponse=response},
          error => {console.log(error)}
        );
      }

    );


  }

}
