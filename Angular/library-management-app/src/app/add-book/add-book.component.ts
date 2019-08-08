import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent {

  readonly ROOT_URL = 'http://localhost:9000';
  newPost: Observable<any>;
  message: string;

  private isbnbook: number;
  private titlebook: string;
  private booksector: string;
  private bookpublisherDate: string;
  private bookauthor: string;
  private bookpublishername: string;
  private pages: number;

  constructor(private http: HttpClient) {
  }

  AddBook() {
    console.log(this.isbnbook, this.pages);
    let book = {
      "isbn": this.isbnbook,
      "title": this.titlebook,
      "sector": this.booksector,
      "publicationDate": this.bookpublisherDate,
      "borrowedDate": '',
      "reader": '',
      "author": this.bookauthor,
      "publisher": this.bookpublishername,
      "totalnoPages": this.pages
    };
    this.newPost=this.http.post(this.ROOT_URL + '/addbook', book);
    this.newPost.subscribe((bata: any[]) => {
      this.message = Object.values(bata).toString();
      if (this.message === 'AddBook') {
        console.log();
        setTimeout(() => {
          window.location.reload();
        }, 1000);
      }
    });
  }



}
