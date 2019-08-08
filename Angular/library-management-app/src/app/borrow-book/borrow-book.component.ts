import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import {Observable} from 'rxjs';


@Component({
  selector: 'app-borrow-book',
  templateUrl: './borrow-book.component.html',
  styleUrls: ['./borrow-book.component.css']
})
export class BorrowBookComponent  {

  readonly ROOT_URL = 'http://localhost:9000';
newPost: Observable<any>;
bookData: any[];
dvdData: any[];
message: string;
private isbn_borrow: number;
private reader_name: string;


constructor(private http: HttpClient) {
  this.http.get(this.ROOT_URL + '/getbooks')
    .subscribe((data: any[]) => {
      this.bookData = data;
    });

  this.http.get(this.ROOT_URL + '/getdvds')
    .subscribe((data: any[]) => {
      this.dvdData = data;
    });
}

borrowItem() {
  let data = {
    "isbn":this.isbn_borrow,
    "readerName":this.reader_name
  };
  this.newPost = this.http.post(this.ROOT_URL + '/borrow', data);
  this.newPost.subscribe((bata: any[]) => {
    this.message = Object.values(bata).toString();
    if (this.message === 'BorrowedItem') {
      console.log();
      setTimeout(() => {
        window.location.reload();
      }, 1000);
    }
  });
}

  addReader () {
    let data = {
      "readerName": this.reader_name
    };
    this.newPost = this.http.post(this.ROOT_URL + '/addreader', data);
    this.newPost.subscribe((bata: any[]) => {
      this.message = Object.values(bata).toString();
      if (this.message === 'AddReader') {
        console.log();
        setTimeout(() => {
          window.location.reload();
        }, 1000);
      }
    });
  }
}


 

