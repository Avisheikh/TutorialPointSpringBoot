import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ListUserService} from "../../../services/userManagementSystem/list-user.service";
import {GetTempUserList} from "../../../common/GetTempUserList";
import {Observable} from "rxjs";

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {

  tempUser: GetTempUserList[];

  @Output()
  rowClick = new EventEmitter();

  constructor(private listTempUser:ListUserService) { }

  ngOnInit(): void
  {
    console.log()
    this.listTempUser.getTempUser().subscribe(
      response =>
      {
        console.log(this.tempUser);
        this.tempUser=response.listTempUser;
        console.log(this.tempUser);
      }
    );
  }
}
