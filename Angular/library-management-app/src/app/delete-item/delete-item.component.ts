import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-delete-item',
  templateUrl: './delete-item.component.html',
  styleUrls: ['./delete-item.component.css']
})
export class DeleteItemComponent  {

  readonly ROOT_URL = 'http://localhost:9000';
  newPost: Observable<any>;
    book: any[];
  dvd: any[];
  message: string;

  private isbn_delete: number;

  constructor(private http: HttpClient) {
    this.http.get(this.ROOT_URL + '/getbooks')
      .subscribe((data: any[]) => {
        this.book = data;
      });

    this.http.get(this.ROOT_URL + '/getdvds')
      .subscribe((data: any[]) => {
        this.dvd = data;
      });
  }


  deleteItem() {
    let  book_dvd = {
      "isbn": this.isbn_delete
    };
    this.newPost = this.http.post(this.ROOT_URL + '/delete', book_dvd);
    this.newPost.subscribe((bata: any[]) => {
      this.message = Object.values(bata).toString();
      if (this.message === 'ItemDeleted') {
        console.log();
        setTimeout(() => {
          window.location.reload();
        }, 1000);
      }
    });
  }

  

}

  
