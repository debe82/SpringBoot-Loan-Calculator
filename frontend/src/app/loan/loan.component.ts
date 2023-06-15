import { Component } from '@angular/core';
import { LoanService } from './loan.service';

//`

@Component({
  selector: 'loan',
  template: `
    <h1>{{title}}</h1>
    <div *ngFor = "let loan of loans">
      <a routerLink="/{{loan}}">
        <button>{{loan}}</button>
      </a>
    </div>  
    <br><br>
    `
            
})
export class LoanComponent {
  title = "Loans Calculator"

  loans: string[] = [];
  constructor(service: LoanService) {
    this.loans = service.getLoans();
  }
  
}
