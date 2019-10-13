import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users: User[] = [];

  addNewUser: User = new User();

  constructor(private userService: UserService) { }

  reloadUsers() {
    this.userService.index().subscribe(
      lifeisGood => { this.users = lifeisGood; console.log(this.users); },

      whenThingsGoBad => { console.error('Observer got an error: ' + whenThingsGoBad); }
    );
  }

  ngOnInit() {
    this.reloadUsers();
  }
addUser() {
this.userService.create(this.addNewUser).subscribe(
    data => {
      this.reloadUsers();
    },
    err => console.error('Observer got an error: ' + err)
  );
  }
}
