import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SaveUser} from "../../common/SaveUser";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SaveUserService {

  private baseURL = "http://localhost:8081/approve_user";

  constructor(private  http:HttpClient) { }

  saveUser(request:SaveUser): Observable<any>
  {
    console.log(request.id);
    return this.http.post(this.baseURL, request);
  }

}
