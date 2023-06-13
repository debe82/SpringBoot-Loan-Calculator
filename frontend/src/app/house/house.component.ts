import { Component } from '@angular/core';
import { HouseService } from './house.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';


export interface dataModel  {
    loanAmount: number,
    paybackTime: number,
    interest: number,
    frequency: number,
    interestType: string
}

@Component({
  selector: 'house',
  templateUrl: './house.component.html',
})


export class HouseComponent {
  title = "Post data";

  constructor(private service: HouseService) {};
  
  submit(data: dataModel) {
    //console.log(data);
    //throw new Error('Method not implemented.');
    this.service.sendData(data).subscribe();
  }




}
