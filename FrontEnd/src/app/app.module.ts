import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {ClarityModule} from '@clr/angular';
import {AppComponent} from './app.component';
import { HttpModule } from '@angular/http';
import { AllStatComponent } from './all-stat/all-stat.component';
import { StatComponent } from './stat/stat.component';
import { ROUTING } from "./app.routing";
import { LinkshortComponent } from './linkshort/linkshort.component'; 
import { StatService } from "./services/stat.service";  
import { Stat } from "./class/stat"; 
import { Allstat } from "./class/allstat";
import { Newwindow } from "./class/newwindow";
import { RedirectComponent } from './redirect/redirect.component';
import { NotFoundComponent } from './not-found/not-found.component'; 
             

@NgModule({
    declarations: [
        AppComponent,
        AllStatComponent,
        StatComponent,
        LinkshortComponent,
        RedirectComponent,
        NotFoundComponent,
        ],
    imports: [
        BrowserAnimationsModule,
        BrowserModule,
        FormsModule, 
        HttpModule, 
        ClarityModule,
        ROUTING

    ],
    providers: [
        StatService, 
        Allstat,
        Stat,
        Newwindow
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
