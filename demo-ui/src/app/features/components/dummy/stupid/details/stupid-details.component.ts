import { ActivatedRoute } from '@angular/router';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FoolRestClient } from 'src/app/features/services/dummy/FoolRestClient';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NavLink } from 'src/app/core/models/nav-link';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { Observable } from 'rxjs';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { StringUtils } from 'src/app/core/services/StringUtils';
import { StupidFullView } from 'src/app/features/models/dummy/views/full/StupidFullView';
import { StupidRestClient } from 'src/app/features/services/dummy/StupidRestClient';
/**
 * auto generated details component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@Component({
selector: 'app-stupid-details',
templateUrl: './stupid-details.component.html',
styleUrls: ['./stupid-details.component.scss']
})
export class StupidDetailsComponent implements OnInit {

id:number;
activePath:string;
view: StupidFullView = new StupidFullView();
form: FormGroup;
foolCodeOptions: Observable<SelectItem[]>;

constructor(private service:StupidRestClient, private foolService:FoolRestClient, private route: ActivatedRoute, private formBuilder: FormBuilder, private notifications: NotificationService) {
this.id = parseInt(this.route.snapshot.paramMap.get('id'));
this.activePath = '/stupid/' + this.id.toString();
}

ngOnInit(): void {
this.form = this.formBuilder.group({
code:[null, Validators.required],
foolCode:[null, Validators.required]})
this.form.controls['foolCode'].valueChanges.subscribe(value=>{this.searchOptionsForFoolCode(value)});
this.load();
}
restoreForm(): void {
this.form.patchValue({
code: this.view.form.code,
foolCode: this.view.form.foolCode
})
}

applyForm(): void {
this.view.form.code = StringUtils.emptyToNull(this.form.get('code').value);
this.view.form.foolCode = StringUtils.emptyToNull(this.form.get('foolCode').value);
}

load(): void {
this.service.load(this.id).subscribe((t) => {this.view=t;this.restoreForm();});
}

searchOptionsForFoolCode(value:string) {
if (value) {
this.foolCodeOptions = this.foolService.searchOptions(value);
}
}

update(): void {
this.applyForm();
this.service.update(this.id, this.view.form).subscribe(success => {this.notifications.info("Operation completed");this.load();}, error => {this.notifications.error("Operation failed")});
}
/* Specific Code Start */
/* Specific Code End */
}
