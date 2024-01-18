import { CommonModule } from '@angular/common';
import { FoolDetailsComponent } from './details/fool-details.component';
import { FoolListComponent } from './list/fool-list.component';
import { FoolMenuComponent } from './menu/fool-menu.component';
import { FoolModalComponent } from './modal/fool-modal.component';
import { FoolRoutingModule } from './fool-routing.module';
import { NgModule } from '@angular/core';
import { SharedModule } from 'src/app/shared/shared.module';
import { StupidListComponent } from './stupid/list/stupid-list.component';
import { StupidModalComponent } from './stupid/modal/stupid-modal.component';
/**
 * auto generated list module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@NgModule({
declarations: [FoolListComponent,FoolDetailsComponent, FoolModalComponent, FoolMenuComponent, StupidListComponent, StupidModalComponent],
imports: [CommonModule, SharedModule, FoolRoutingModule]
})
export class FoolModule { }
