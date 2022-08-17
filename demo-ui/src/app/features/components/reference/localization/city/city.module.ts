import { CityDetailsComponent } from './details/city-details.component';
import { CityListComponent } from './list/city-list.component';
import { CityMenuComponent } from './menu/city-menu.component';
import { CityModalComponent } from './modal/city-modal.component';
import { CityRoutingModule } from './city-routing.module';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from 'src/app/shared/shared.module';
/**
 * auto generated list module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@NgModule({
declarations: [CityListComponent,CityDetailsComponent, CityModalComponent, CityMenuComponent],
imports: [CommonModule, SharedModule, CityRoutingModule]
})
export class CityModule { }
