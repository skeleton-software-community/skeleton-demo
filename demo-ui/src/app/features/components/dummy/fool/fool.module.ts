import { CommonModule } from '@angular/common';
import { FoolDetailsComponent } from './details/fool-details.component';
import { FoolListComponent } from './list/fool-list.component';
import { FoolModalComponent } from './list/modal/fool-modal.component';
import { FoolRoutingModule } from './fool-routing.module';
import { NgModule } from '@angular/core';
import { SharedModule } from 'src/app/shared/shared.module';
/**
 * auto generated list module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@NgModule({
declarations: [FoolListComponent,FoolDetailsComponent, FoolModalComponent],
imports: [CommonModule, SharedModule, FoolRoutingModule]
})
export class FoolModule { }
