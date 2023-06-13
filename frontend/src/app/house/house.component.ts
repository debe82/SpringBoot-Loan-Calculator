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
  showData: any;
  payBackType: number[] = [];
  selectedType: string = "";

  constructor(private service: HouseService) {
    this.payBackType = service.getPayBackType();
  };

  onSelected(freq: string) {
    this.selectedType = freq;
  }
  
  submit(data: dataModel) {
    console.log("submit.data: ", data);
    data.frequency = parseInt (this.selectedType);
    //throw new Error('Method not implemented.');
    this.service.sendData(data).subscribe((data) => {
      console.log("submit.data: ", data);
      this.showData = data;
    });
  }




}
