import { CommonModule } from '@angular/common';
import { CountryDetailsComponent } from './details/country-details.component';
import { CountryListComponent } from './list/country-list.component';
import { CountryModalComponent } from './list/modal/country-modal.component';
import { CountryRoutingModule } from './country-routing.module';
import { NgModule } from '@angular/core';
import { SharedModule } from 'src/app/shared/shared.module';
/**
 * auto generated list module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@NgModule({
declarations: [CountryListComponent,CountryDetailsComponent, CountryModalComponent],
imports: [CommonModule, SharedModule, CountryRoutingModule]
})
export class CountryModule { }
