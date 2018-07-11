import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';  
import { StatService } from 'app/services/stat.service';
import { Stat } from 'app/class/stat';
import { Newwindow } from 'app/class/newwindow';  

// омпонент, св€зывающий представление о статистике по конкретной ссылке с сервером
@Component({
  selector: 'app-stat',
  templateUrl: './stat.component.html',
  styleUrls: ['./stat.component.scss']
})
export class StatComponent {
  private stat: Stat[];
  link: String;
  params : Number;              
  shortLink: String; 

  nativeWindow: any;
                                  
  constructor(private route: ActivatedRoute, private service: StatService,
       private win: Newwindow) {
     this.nativeWindow = win.getNativeWindow();
     this.params = route.snapshot.params['id'];  
     this.service.stat(this.params).subscribe((stat) => {
       this.stat = stat.statistics;
       this.link = stat.realUrl;                                                                  
       this.shortLink = "http://shortlink.ru/" + this.params;
     },(error) => {
       console.log(error);
     });          
  }
}
