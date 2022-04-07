import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateUserComponent } from './components/userManagementSystem/create-user/create-user.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { ListUserComponent } from './components/userManagementSystem/list-user/list-user.component';
import { DetailUserComponent } from './components/userManagementSystem/detail-user/detail-user.component';


@NgModule({
  declarations: [
    AppComponent,
    CreateUserComponent,
    ListUserComponent,
    DetailUserComponent
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
