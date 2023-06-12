import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoanComponent } from './loan/loan.component';
import { LoanService } from './loan/loan.service';
import { HouseComponent } from './house/house.component';

@NgModule({
  declarations: [
    AppComponent,
    LoanComponent,
    HouseComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [
    LoanService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
