import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ListUserService {

  private baseURL = "http://localhost:8081/get_temp_user";

  constructor(private http:HttpClient) { }

  getTempUser()
  {
    return this.http.get<any>(this.baseURL);
  }
}
