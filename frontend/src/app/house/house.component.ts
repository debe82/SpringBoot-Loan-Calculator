import { Component } from '@angular/core';
import { HouseService } from './house.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'house',
  template: `
    <form >
      <input type="text" placeholder="enter loan amount" />
      <br><br>
      <input type="text" placeholder="enter duration" />
      <br><br>
      <input type="text" placeholder="enter type" />
      <br><br>
      <input type="text" placeholder="enter frequency" />
      <br><br>
      <button>Send info</button>
    <form>  
    `
})
export class HouseComponent {
  BASE_URL  = "http://localhost:8080/api";

  data = 
  {
    loanAmount: 100000,
    paybackTime: 10,
    interest: 10,
    frequency: 1
  };
  
  houseUrl = this.BASE_URL + '/houseloans';
  
  httpOptions = {
    headers: new HttpHeaders({
    'Content-Type':  'application/json'
    })
  };
  constructor(private http: HttpClient) {
    this.http.post(this.houseUrl, this.data, this.httpOptions);  
  }

}
