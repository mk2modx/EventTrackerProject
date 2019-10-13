import { Jobapp } from './../models/jobapp';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class JobapplicationService {
  private baseUrl = 'http://34.218.203.197:8080/JobTracker/';
  private url = this.baseUrl + 'api/applications';


  constructor(private http: HttpClient ) { }


  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  index() {
    return this.http.get<Jobapp[]>(this.url)
   .pipe(
     catchError((err: any) => {
       console.log(err);
       return throwError('Error in TodoService.index()');
     })
     );
 }
 create(jobapp: Jobapp, id) {
  return this.http.post<Jobapp>(this.url + '/' + id, jobapp)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Error in JobapplicationService.index()');
        }
      ));

  }

update(jobapp: Jobapp, userId, appId) {

 return this.http.put<Jobapp>(this.baseUrl + 'api/' + userId + '/applications/' + appId, jobapp);
}

}// end Service
