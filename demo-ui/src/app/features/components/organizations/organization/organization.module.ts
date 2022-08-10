import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { OrganizationDetailsComponent } from './details/organization-details.component';
import { OrganizationListComponent } from './list/organization-list.component';
import { OrganizationModalComponent } from './list/modal/organization-modal.component';
import { OrganizationRoutingModule } from './organization-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';
/**
 * auto generated list module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@NgModule({
declarations: [OrganizationListComponent,OrganizationDetailsComponent, OrganizationModalComponent],
imports: [CommonModule, SharedModule, OrganizationRoutingModule]
})
export class OrganizationModule { }