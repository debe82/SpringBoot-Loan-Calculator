import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoanComponent } from './loan/loan.component';
import { LoanService } from './loan/loan.service';
import { HouseComponent } from './house/house.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HouseService } from './house/house.service';

@NgModule({
  declarations: [
    AppComponent,
    LoanComponent,
    HouseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    LoanService,
    HouseService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
