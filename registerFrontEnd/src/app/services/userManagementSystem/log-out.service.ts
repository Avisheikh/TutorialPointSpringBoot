import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LogOutService {

  baseUrl="http://localhost:8081/log-out"

  constructor( private http:HttpClient) { }

  logout()
  {
    return this.http.get(this.baseUrl);
  }
}
