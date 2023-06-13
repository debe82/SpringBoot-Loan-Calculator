import { HttpClient, HttpHeaders } from "@angular/common/http";
import { dataModel } from "./house.component";
import { Injectable } from "@angular/core";


const BASE_URL  = "http://localhost:8080/api";

@Injectable({
  providedIn: 'root'
})
export class HouseService {

  constructor(private http:HttpClient) {}

  sendData(data: dataModel) {
    console.log("sendData.data: ", data);
    let houseUrl = BASE_URL + '/house';
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.http.post<dataModel>(houseUrl, data, httpOptions);
  }

  getPayBackType() {
    return [1 ,2, 3, 4, 6, 12];
  }

}