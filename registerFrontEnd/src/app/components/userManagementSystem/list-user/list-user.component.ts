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

  constructor(private listTempUser:ListUserService) { }

  ngOnInit(): void {
    this.listTempUser.getTempUser().subscribe(
      response => {
        this.tempUser=response.listTempUser;
      }, error => {alert(error.error)}
    );
  }
}
