import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-generate-report',
  templateUrl: './generate-report.component.html',
  styleUrls: ['./generate-report.component.css']
})
export class GenerateReportComponent {

  readonly ROOT_URL = 'http://localhost:9000';
  reportdata: any[];

  constructor(private http: HttpClient) {

    this.http.get(this.ROOT_URL + '/getreport')
      .subscribe((data: any[]) => {
        this.reportdata = data;
      })
  }
}
