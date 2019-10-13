import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Tech } from '../models/tech';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TechnologyService {
  private baseUrl = 'http://34.218.203.197:8080/JobTracker/';
  private url = this.baseUrl + 'api/technologies';

  constructor(private http: HttpClient) { }
  index() {
    return this.http.get<Tech[]>(this.url)
   .pipe(
     catchError((err: any) => {
       console.log(err);
       return throwError('Error in UserService.index()');
     })
     );
 }

} // end Service
