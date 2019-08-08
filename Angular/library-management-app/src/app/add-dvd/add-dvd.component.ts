import { Component } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-add-dvd',
  templateUrl: './add-dvd.component.html',
  styleUrls: ['./add-dvd.component.css']
})
export class AddDVDComponent  {

  readonly ROOT_URL = 'http://localhost:9000';
  newPost: Observable<any>;
  message: string;

  isbndvd: number;
  titledvd: string;
  dvdsector: string;
  dvdpublisherDate: string;
  dvdlanguages: string;
  dvdsubtitles: string;
  dvdproducer: string;
  dvdactors: string;

  constructor(private http: HttpClient) { }
  AddDVD() {
    console.log(this.isbndvd, "Sucess");
    let dvd = {
      "isbn": this.isbndvd,
      "title": this.titledvd,
      "sector": this.dvdsector,
      "publicationDate": this.dvdpublisherDate,
      "borrowedDate":'',
      "reader":'',
      "avail_languages": this.dvdlanguages,
      "avail_subtitiles": this.dvdsubtitles,
      "producer": this.dvdproducer,
      "actor": this.dvdactors
    };
    this.newPost = this.http.post(this.ROOT_URL + '/adddvds', dvd);
    this.newPost.subscribe((bata: any[]) => {
      this.message = Object.values(bata).toString();
      if (this.message === 'AddDvd') {
        console.log();
        setTimeout(() => {
          window.location.reload();
        }, 1000);
      }
    });
  }
 
}
