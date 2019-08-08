import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-return-book',
  templateUrl: './return-book.component.html',
  styleUrls: ['./return-book.component.css']
})
export class ReturnBookComponent{

  readonly ROOT_URL = 'http://localhost:9000';
  newPost: Observable<any>;
  bookData: any[];
  dvdData: any[];
  message: string;
  message_dublicate: boolean;
  private isbn_return: number;

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

  returnItem() {
    let data = {
      "isbn": this.isbn_return,
    };
    this.newPost = this.http.post(this.ROOT_URL + '/return', data);
    this.newPost.subscribe((bata: any[]) => {
      this.message = Object.values(bata).toString();
      if (this.message === '0.0') {
        // setTimeout(() => {
        //   window.location.reload();
        // }, 1000);
      }
      if (Number(this.message) >= Number('0.0')) {
        this.message_dublicate = true;
      }
    });
  }

  refereshPage() {
    window.location.reload();
  }

}
