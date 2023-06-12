import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HouseComponent } from './house/house.component';
import { Routes, RouterModule  } from '@angular/router';
import { AppComponent } from './app.component';
import { LoanComponent } from './loan/loan.component';

const routes: Routes = [
  { path: 'Loan', component: LoanComponent },
  { path: 'House', component: HouseComponent }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})

export class AppRoutingModule { }
