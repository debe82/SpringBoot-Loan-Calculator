import { Component } from '@angular/core';
import { HouseService } from './house.service';

export interface dataModel  {
    loanAmount: number,
    paybackTime: number,
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
    console.log("submit.data: ", data);
    //throw new Error('Method not implemented.');
    this.service.sendData(data).subscribe((data) => {
      console.log("subscribe.data: ", data);
    });
  }




}
