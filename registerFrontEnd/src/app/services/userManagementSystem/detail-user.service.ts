import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {TempUserResponse} from "../../common/TempUserResponse";
import {UserResponse} from "../../common/UserResponse";

@Injectable({
  providedIn: 'root'
})
export class DetailUserService {

  private baseTempUserURL = "http://localhost:8081/get_temp_user/";
  private baseUserURL = "http://localhost:8081/get_user/";

  constructor(private http:HttpClient) { }

  detailTempUser(userId:number)
  {
    return this.http.get<TempUserResponse>(this.baseTempUserURL + userId);
  }

  detailUser(userId:number)
  {
    return this.http.get<any>(this.baseUserURL + userId);
  }
}
