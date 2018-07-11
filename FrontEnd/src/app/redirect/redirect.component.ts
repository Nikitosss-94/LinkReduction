import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StatService } from 'app/services/stat.service';  

//Компонент, связывающий производящий переход на внешнюю ссылку
@Component({
  selector: 'app-redirect',
  templateUrl: './redirect.component.html',
  styleUrls: ['./redirect.component.scss']
})
export class RedirectComponent {

  nativeWindow: any;
                              
  constructor(private route: ActivatedRoute, private router: Router, private service: StatService) {
    this.service.redirect(route.snapshot.params['id']).subscribe((link) => {
       window.location.href = link.url; 
    },(error) => {
      console.log(error);
    });  }
                   
}
