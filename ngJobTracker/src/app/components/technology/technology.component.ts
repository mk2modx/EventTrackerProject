import { TechnologyService } from './../../services/technology.service';
import { Component, OnInit } from '@angular/core';
import { Tech } from 'src/app/models/tech';

@Component({
  selector: 'app-technology',
  templateUrl: './technology.component.html',
  styleUrls: ['./technology.component.css']
})
export class TechnologyComponent implements OnInit {

techs: Tech[] = [];

  constructor(private techService: TechnologyService) { }

  ngOnInit() {
    this.reloadTechonologies();
  }

reloadTechonologies(){
  this.techService.index().subscribe(
    lifeisGood => { this.techs = lifeisGood; console.log(this.techs); },

    whenThingsGoBad => { console.error('Observer got an error: ' + whenThingsGoBad); }
  );
}

}
