import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { User } from '../models/user';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { Jobapp } from '../models/jobapp';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://34.218.203.197:8080/JobTracker/';
  private url = this.baseUrl + 'api/users';



  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };


  constructor(private http: HttpClient) { }

  create(user: User) {

    return this.http.post<User>(this.url + '/' + 'create', user)
        .pipe(
          catchError((err: any) => {
            console.log(err);
            return throwError('Error in PokeService.index()');
          }
        ));

  }

  index() {
    return this.http.get<User[]>(this.url)
   .pipe(
     catchError((err: any) => {
       console.log(err);
       return throwError('Error in UserService.index()');
     })
     );
 }

 destroy(userid, appid){
  return this.http.delete<Jobapp>(this.baseUrl + 'api/' + userid + '/applications/' + appid);

}


} // end Service


