import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ListUserService {

  private tempUserBaseURL = "http://localhost:8081/get_temp_user";
  private userBaseURL = "http://localhost:8081/list_user";

  constructor(private http:HttpClient) { }

  getTempUser()
  {
    return this.http.get<any>(this.tempUserBaseURL);
  }

  getUser()
  {
    return this.http.get<any>(this.userBaseURL);
  }
}
