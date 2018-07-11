import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { StatService } from 'app/services/stat.service';
import { Allstat } from 'app/class/allstat';

// омпонент, св€зывающий представление о краткой статистике по ссылкам с сервером
@Component({
  selector: 'app-allstat',               
  templateUrl: './all-stat.component.html',
  styleUrls: ['./all-stat.component.scss']
})
export class AllStatComponent {
  private data: Allstat[];
  constructor(private route: Router, private service: StatService) {

    this.service.allstat().subscribe((allstat) => {
      this.data = allstat;
    },(error) => {
      console.log(error);
    });                                      
  }    

  link: String;          
 
  gotostat(id: number){       
     this.route.navigate(["stat/" + id]);
  }
       
}
