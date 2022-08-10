import { CalendarDayOffListComponent } from './calendar-day-off/list/calendar-day-off-list.component';
import { CalendarDayOffModalComponent } from './calendar-day-off/list/modal/calendar-day-off-modal.component';
import { CalendarDetailsComponent } from './details/calendar-details.component';
import { CalendarListComponent } from './list/calendar-list.component';
import { CalendarModalComponent } from './list/modal/calendar-modal.component';
import { CalendarRoutingModule } from './calendar-routing.module';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from 'src/app/shared/shared.module';
/**
 * auto generated list module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@NgModule({
declarations: [CalendarListComponent,CalendarDetailsComponent, CalendarModalComponent, CalendarDayOffListComponent, CalendarDayOffModalComponent],
imports: [CommonModule, SharedModule, CalendarRoutingModule]
})
export class CalendarModule { }
