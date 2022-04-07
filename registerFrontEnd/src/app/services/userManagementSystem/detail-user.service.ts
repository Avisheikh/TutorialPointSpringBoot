import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {TempUserResponse} from "../../common/TempUserResponse";

@Injectable({
  providedIn: 'root'
})
export class DetailUserService {

  private baseURL = "http://localhost:8081/get_temp_user/";

  constructor(private http:HttpClient) { }

  detailTempUser(userId:number)
  {
    return this.http.get<TempUserResponse>(this.baseURL + userId);
  }
}
