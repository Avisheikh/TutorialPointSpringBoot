import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CreateUserComponent} from "./components/userManagementSystem/create-user/create-user.component";
import {ListUserComponent} from "./components/userManagementSystem/list-user/list-user.component";
import {DetailUserComponent} from "./components/userManagementSystem/detail-user/detail-user.component";
import {LoginComponent} from "./components/userManagementSystem/login/login.component";
import {GetListUserComponent} from "./components/userManagementSystem/get-list-user/get-list-user.component";
import {GetDetailUserComponent} from "./components/userManagementSystem/get-detail-user/get-detail-user.component";



const routes: Routes =
  [
      {path: "create-temp-user", component:CreateUserComponent},
      {path: "list-temp-user", component:ListUserComponent},
      {path: "detail-temp-user/:id", component:DetailUserComponent},
      {path: "login", component:LoginComponent},
      {path: "list-user", component:GetListUserComponent},
      {path: "detail-user/:id", component:GetDetailUserComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
