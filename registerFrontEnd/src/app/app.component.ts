import { Component } from '@angular/core';
import {LogOutService} from "./services/userManagementSystem/log-out.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'registerFrontEnd';

  constructor(private logOut:LogOutService,private router:Router) { }

  ngOnInit(): void {
  }

  onLogOut()
  {
    this.logOut.logout().subscribe
    (
      response=>
      {
        console.log(response);
        alert("User has been log out.");
        this.router.navigate(['login']);

      },
      error =>
      {
        console.log(error);
      }
    );
  }
}
