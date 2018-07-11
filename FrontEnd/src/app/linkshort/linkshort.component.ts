import { Component } from '@angular/core'; 
import { Router } from '@angular/router';
import { StatService } from 'app/services/stat.service';
import { Newwindow } from 'app/class/newwindow'; 
import { NewStat } from 'app/class/new-stat';

// омпонент, св€зывающий представление, где реализуетс€ ввод сокращ€емой ссылки и вывод данных о сокращенных ссылках в текущей сессии с сервером
@Component({
  selector: 'app-linkshort',
  templateUrl: './linkshort.component.html',
  styleUrls: ['./linkshort.component.scss']})
export class LinkshortComponent {
   
    constructor(private route : Router, private service: StatService, private win: Newwindow) {
      this.nativeWindow = win.getNativeWindow();                 
    }          
                                           
    link: String;
    note: String;
    id: Number;   
    nativeWindow: any;
    
    data: NewStat[] = [];

    onProcess() {
        this.service.reduct(this.link).subscribe((id) => {
          this.id = id.id;
          this.data.push({"shortLink": "http://shortlink.ru/" + id.id, "link": this.link, "note": this.note});          console.log(this.data);  
        },(error) => {
          console.log(error);
        });
    }

    goto() {       
         var newWindow = this.nativeWindow.open([this.id]);
    }
}
