import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Login} from "../../common/login";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginUserService {

  private baseURL = "http://localhost:8081/login"

  constructor(private http:HttpClient) { }

  login(loginDetails:Login): Observable<any>
  {
    console.log("service " + loginDetails.email);

    return this.http.post(this.baseURL,loginDetails);
  }

}
