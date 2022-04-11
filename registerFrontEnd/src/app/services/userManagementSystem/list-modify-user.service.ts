import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ListModifyUserService {

  private baseUrl = "http://localhost:8081/list_modify_user";

  constructor(private http:HttpClient) { }

  getModifyUser()
  {
    return this.http.get<any>(this.baseUrl);
  }

}
