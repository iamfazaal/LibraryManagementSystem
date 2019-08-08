import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-diplay-dvd',
  templateUrl: './diplay-dvd.component.html',
  styleUrls: ['./diplay-dvd.component.css']
})
export class DiplayDvdComponent {

  readonly ROOT_URL = 'http://localhost:9000';
  dvds: any[];

  constructor(private http: HttpClient) {
    this.http.get(this.ROOT_URL + '/getdvds')
      .subscribe((data: any[]) => {
        this.dvds = data;
      });
  }
}
