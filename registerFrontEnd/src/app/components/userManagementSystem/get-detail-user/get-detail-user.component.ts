import { Component, OnInit } from '@angular/core';
import {UserResponse} from "../../../common/UserResponse";
import {DetailUserService} from "../../../services/userManagementSystem/detail-user.service";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-get-detail-user',
  templateUrl: './get-detail-user.component.html',
  styleUrls: ['./get-detail-user.component.css']
})
export class GetDetailUserComponent implements OnInit {

  getUserDetail: UserResponse = new UserResponse();

  constructor(private route:ActivatedRoute, private detailService:DetailUserService) { }

  ngOnInit(): void {

    this.route.paramMap.subscribe(
      (params:ParamMap) =>
      {
        console.log(params.get('id'));
        let id = Number(params.get('id'));

        this.detailService.detailUser(id).subscribe
        (
          response =>
          {
            console.log(response);
            this.getUserDetail = response;
          },
          error =>
          {
            console.log(error);
          }
        );

      }
    );

  }

}
