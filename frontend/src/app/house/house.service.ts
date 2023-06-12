import { HttpHeaders } from "@angular/common/http";

const BASE_URL  = "http://localhost:8080/api";

export class HouseService {
  sendData(amount: number, duration: number, type: string, frequency: number) {
    let data = 
      {
        loanAmount: amount,
        paybackTime: duration,
        interest: type,
        frequency: frequency
      };
    let houseUrl = BASE_URL + '/houseloans';
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
      return //this.http.post(houseUrl, data, httpOptions)
  }

}