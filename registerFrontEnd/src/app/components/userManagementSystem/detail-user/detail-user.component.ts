import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {DetailUserService} from "../../../services/userManagementSystem/detail-user.service";
import {TempUserResponse} from "../../../common/TempUserResponse";
import {SaveUserService} from "../../../services/userManagementSystem/save-user.service";
import {SaveUser} from "../../../common/SaveUser";

@Component({
  selector: 'app-detail-user',
  templateUrl: './detail-user.component.html',
  styleUrls: ['./detail-user.component.css']
})
export class DetailUserComponent implements OnInit {

  private id:string | null;
  tempUserResponse: TempUserResponse = new TempUserResponse();

  // read about this properly
  constructor(private route:ActivatedRoute, private detailService:DetailUserService, private saveService:SaveUserService, private router:Router) { }

  ngOnInit(): void {

      this.route.paramMap.subscribe( (params: ParamMap) =>
        {
          console.log(params.get('id'));
          let id = Number(params.get('id'));
          this.detailService.detailTempUser(id).subscribe( response =>
            {
              console.log(response);
              this.tempUserResponse = response;
              this.tempUserResponse.userName = response.userName.toUpperCase();
            },
            error =>
            {
              console.log(error);
            }
          );
        }
      );
  }

  saveUser() {

    let saveUser = new SaveUser();

    saveUser.id = this.tempUserResponse.id;

    this.saveService.saveUser(saveUser).subscribe(response =>
    {
      console.log(response);
      alert(response.responseMessage);
      this.router.navigate(['create-temp-user']);
    },
      error =>
      {
        console.log(error.error);
        alert(error.error);
      }

    );

  }

}
