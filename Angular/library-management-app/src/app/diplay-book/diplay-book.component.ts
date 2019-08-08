import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Component({
  selector: 'app-diplay-book',
  templateUrl: './diplay-book.component.html',
  styleUrls: ['./diplay-book.component.css']
})
export class DiplayBookComponent {

  readonly URL = 'http://localhost:9000';
  book: any[];

  constructor(private dataService: HttpClient) {

    this.dataService.get(this.URL + '/getbooks')
      .subscribe((data: any[]) => {
        this.book = data;
      })

  }
}
