import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from 'src/app/shared/shared.module';
import { StupidDetailsComponent } from './details/stupid-details.component';
import { StupidListComponent } from './list/stupid-list.component';
import { StupidMenuComponent } from './menu/stupid-menu.component';
import { StupidModalComponent } from './modal/stupid-modal.component';
import { StupidRoutingModule } from './stupid-routing.module';
/**
 * auto generated list module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@NgModule({
declarations: [StupidListComponent,StupidDetailsComponent, StupidModalComponent, StupidMenuComponent],
imports: [CommonModule, SharedModule, StupidRoutingModule]
})
export class StupidModule { }
