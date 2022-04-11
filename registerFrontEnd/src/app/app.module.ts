import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateUserComponent } from './components/userManagementSystem/create-user/create-user.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { ListUserComponent } from './components/userManagementSystem/list-user/list-user.component';
import { DetailUserComponent } from './components/userManagementSystem/detail-user/detail-user.component';
import { LoginComponent } from './components/userManagementSystem/login/login.component';
import { GetListUserComponent } from './components/userManagementSystem/get-list-user/get-list-user.component';
import { GetDetailUserComponent } from './components/userManagementSystem/get-detail-user/get-detail-user.component';



@NgModule({
  declarations: [
    AppComponent,
    CreateUserComponent,
    ListUserComponent,
    DetailUserComponent,
    LoginComponent,
    GetListUserComponent,
    GetDetailUserComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
