import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { ConfirmationModalComponent } from 'src/app/core/components/confirmation-modal/confirmation-modal.component';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { ScrollForm } from "src/app/core/models/ScrollForm";
import { ScrollView } from "src/app/core/models/ScrollView";
import { SelectItem } from "src/app/core/models/SelectItem";
import { StringUtils } from 'src/app/core/services/StringUtils';
import { StupidBasicView } from '../models/StupidBasicView';
import { StupidFilter } from '../models/StupidFilter';
import { StupidForm } from '../models/StupidForm';
import { StupidFullView } from '../models/StupidFullView';
import { StupidModalComponent } from './modal/stupid-modal.component';
import { StupidRestClient } from '../services/StupidRestClient';
import { StupidSorting } from '../models/StupidSorting';
/**
 * auto generated list component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@Component({
selector: 'app-stupid-list',
templateUrl: './stupid-list.component.html',
styleUrls: ['./stupid-list.component.scss']
})
export class StupidListComponent implements OnInit, AfterViewInit {

scrollForm: ScrollForm<StupidFilter, StupidSorting> = new ScrollForm();
scrollView: ScrollView<StupidBasicView> = new ScrollView();
dataSource:MatTableDataSource<StupidBasicView>;
@ViewChild(MatPaginator) paginator: MatPaginator;
@ViewChild(MatSort) sort: MatSort
pageSizeOptions: number[] = [10, 20, 50, 100];
displayedColumns: string[] = ['code','foolCode','Actions'];
filter: FormGroup;

constructor(private service:StupidRestClient, private formBuilder: FormBuilder, private dialog: MatDialog, private notifications: NotificationService) { }
ngOnInit(): void {
this.filter = this.formBuilder.group({
code:[null],
foolCode:[null]})
this.reset();
}

ngAfterViewInit(): void {
this.paginator.page.subscribe(
(event) => {
this.scrollForm.page=event.pageIndex+1;
this.scrollForm.elementsPerPage=event.pageSize;
this.refresh();
});

this.sort.sortChange.subscribe(
(event) => {
this.scrollForm.sorting = new StupidSorting();
switch (this.sort.active) {
case 'code': this.scrollForm.sorting.codeOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
case 'foolCode': this.scrollForm.sorting.foolCodeOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
}
this.refresh();
});

this.filter.controls['code'].valueChanges.subscribe(value=>{
this.scrollForm.filter.code=value;
this.refresh();
});
this.filter.controls['foolCode'].valueChanges.subscribe(value=>{
this.scrollForm.filter.foolCode=value;
this.refresh();
});
}

refresh(): void {
this.service.scroll(this.scrollForm).subscribe((t) => {
this.scrollView=t;
this.dataSource = new MatTableDataSource(this.scrollView.elements);
});
}

reset(): void {
this.scrollForm = new ScrollForm();
this.scrollForm.filter = new StupidFilter();
this.scrollForm.sorting = new StupidSorting();
this.scrollForm.page=1;
this.scrollForm.elementsPerPage=10;
this.filter.patchValue({
code: [null],
foolCode: [null]
})
this.refresh();
}

create(): void {
this.service.create().subscribe((t) => {
let ref = this.dialog.open(StupidModalComponent);
ref.componentInstance.view = t;
ref.afterClosed().subscribe(result => {this.refresh();});
});
}

edit(id: number): void {
this.service.load(id).subscribe((t) => {
let ref = this.dialog.open(StupidModalComponent);
ref.componentInstance.view = t;
ref.afterClosed().subscribe(result => {this.refresh();});
});
}

delete(id: number): void {
this.dialog.open(ConfirmationModalComponent).afterClosed().subscribe(result => {
if (result) {
this.service.delete(id).subscribe(success => {this.notifications.info("Operation completed");this.refresh()}, error => {this.notifications.error("Operation failed")});
}
});
}

/* Specific Code Start */
/* Specific Code End */
}
