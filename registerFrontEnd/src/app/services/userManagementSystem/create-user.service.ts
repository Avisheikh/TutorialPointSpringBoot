import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CreateUserComponent} from "../../components/userManagementSystem/create-user/create-user.component";
import {Observable} from "rxjs";
import {CreateUser} from "../../common/create-user";

@Injectable({
  providedIn: 'root'
})
export class CreateUserService {

  private baseURL = "http://localhost:8081/create_user"

  constructor(private http:HttpClient) { }

  userCreate(create: CreateUser): Observable<any>
  {
    console.log(create);
    return this.http.post(this.baseURL,create);
  }
}
