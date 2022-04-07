import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CreateUserComponent} from "./components/userManagementSystem/create-user/create-user.component";
import {ListUserComponent} from "./components/userManagementSystem/list-user/list-user.component";
import {DetailUserComponent} from "./components/userManagementSystem/detail-user/detail-user.component";


const routes: Routes =
  [
      {path: "create-temp-user", component:CreateUserComponent},
      {path: "list-temp-user", component:ListUserComponent},
      {path: "detail-temp-user/:id", component:DetailUserComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
