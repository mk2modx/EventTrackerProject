import { Jobapp } from './../../models/jobapp';
import { Component, OnInit } from '@angular/core';
import { JobapplicationService } from 'src/app/services/jobapplication.service';

@Component({
  selector: 'app-job-application',
  templateUrl: './job-application.component.html',
  styleUrls: ['./job-application.component.css']
})
export class JobApplicationComponent implements OnInit {
jobs: Jobapp[] = [];
userId = 0;
appId = 0;
selectApp = false;
editJob: Jobapp = new Jobapp();
newJob: Jobapp = new Jobapp();


  constructor(private jobService: JobapplicationService) { }

  ngOnInit() {
    this.reloadList();
  }


  reloadList() {
    this.jobService.index().subscribe(
     lifeisGood => { this.jobs = lifeisGood; console.log(this.jobs); },

     whenThingsGoBad => { console.error('Observer got an error: ' + whenThingsGoBad); }
   );
   }

addApp(){
  this.jobService.create(this.newJob, this.userId).subscribe(
    data => {
      this.reloadList();
    },
    err => console.error('Observer got an error: ' + err)
  );
}
submitUpdate(){
  for (let i = 0; i < this.jobs.length; i++) {

    if(this.appId === this.jobs[i].id){
    this.editJob = this.jobs[i];
    }
  }
}

updateApp(){

  this.jobService.update(this.editJob, this.userId, this.appId).subscribe(
    data => {
      this.reloadList();

    },
    err => console.error('Observer got an error: ' + err)
  );
  }

deleteApp(id){
  this.jobService.destroy(id).subscribe(
    data => {
      this.reloadList();
    },
    err => console.error('Observer got an error: ' + err)
  );
}

} // end Component
