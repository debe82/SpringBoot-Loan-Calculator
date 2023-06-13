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
  
  interestType: string[] = [];
  selectedIntType: string = "fixed";
  
  paybackType: number[] = [];
  selectedPbType: string = "1";


  constructor(private service: HouseService) {
    this.paybackType = service.getPayBackType();
    this.interestType = service.getInterestType();
  };

  onPbSelected(freq: string) {
    this.selectedPbType = freq;
  }

  onItSelected(type: string) {
    this.selectedIntType = type;
  }
  
  submit(data: dataModel) {
    console.log("submit.data: ", data);
    data.frequency = parseInt (this.selectedPbType);
    data.interestType = this.selectedIntType;
    //throw new Error('Method not implemented.');
    this.service.sendData(data).subscribe((data) => {
      console.log("submit.data: ", data);
      this.showData = data;
    });
  }




}
