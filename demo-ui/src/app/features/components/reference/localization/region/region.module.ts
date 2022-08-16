import { CityListComponent } from './city/list/city-list.component';
import { CityModalComponent } from './city/list/modal/city-modal.component';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RegionDetailsComponent } from './details/region-details.component';
import { RegionListComponent } from './list/region-list.component';
import { RegionMenuComponent } from './menu/region-menu.component';
import { RegionModalComponent } from './list/modal/region-modal.component';
import { RegionRoutingModule } from './region-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';
/**
 * auto generated list module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@NgModule({
declarations: [RegionListComponent,RegionDetailsComponent, RegionModalComponent, RegionMenuComponent, CityListComponent, CityModalComponent],
imports: [CommonModule, SharedModule, RegionRoutingModule]
})
export class RegionModule { }
