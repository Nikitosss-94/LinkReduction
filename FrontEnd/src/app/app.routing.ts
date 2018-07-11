import { ModuleWithProviders } from '@angular/core/src/metadata/ng_module';
import { Routes, RouterModule } from '@angular/router';
                                                        
import { AllStatComponent } from './all-stat/all-stat.component';
import { StatComponent } from './stat/stat.component';
import { LinkshortComponent } from './linkshort/linkshort.component';
import { RedirectComponent } from './redirect/redirect.component';

export const Routing: Routes =[                                               
    {path: '', component: LinkshortComponent},                  
    {path: 'stat/:id', component: StatComponent},                   
    {path: 'allstat', component: AllStatComponent}, 
    {path: ':id', component: RedirectComponent}
];

export const ROUTING: ModuleWithProviders = RouterModule.forRoot(Routing);
