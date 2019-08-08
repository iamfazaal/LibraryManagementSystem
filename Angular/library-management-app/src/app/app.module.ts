import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { ReactiveFormsModule } from "@angular/forms";

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { GenerateReportComponent } from './generate-report/generate-report.component';
import { AppRoutingModule } from './app-routing.module';
import { AddBookComponent } from './add-book/add-book.component';
import { AddDVDComponent } from './add-dvd/add-dvd.component';
import { BorrowBookComponent } from './borrow-book/borrow-book.component';
import { ReturnBookComponent } from './return-book/return-book.component';
import { DiplayBookComponent } from './diplay-book/diplay-book.component';
import { DiplayDvdComponent } from './diplay-dvd/diplay-dvd.component';
import { DeleteItemComponent } from './delete-item/delete-item.component';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    GenerateReportComponent,
    AddDVDComponent,
    AddBookComponent,
    AddDVDComponent,
    BorrowBookComponent,
    ReturnBookComponent,
    DiplayBookComponent,
    DiplayDvdComponent,
    DeleteItemComponent,


  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule,


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
