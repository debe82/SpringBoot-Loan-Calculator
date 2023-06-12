import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';

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
