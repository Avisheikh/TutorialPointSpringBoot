import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CreateUserComponent} from "./components/userManagementSystem/create-user/create-user.component";

const routes: Routes =
  [
      {path: "create_user", component:CreateUserComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
