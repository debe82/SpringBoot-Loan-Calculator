import { Component } from '@angular/core';
import { LoanService } from './loan.service';

//`

@Component({
  selector: 'loan',
  template: `
    <h1>{{title}}</h1>
    <li *ngFor = "let loan of loans">
      <a routerLink="/{{loan}}">{{loan}}</a>
    </li>  
    `
            
})
export class LoanComponent {
  title = "Loans Calculator"

  loans: string[] = [];
  constructor(service: LoanService) {
    this.loans = service.getLoans();
  }
  
}
