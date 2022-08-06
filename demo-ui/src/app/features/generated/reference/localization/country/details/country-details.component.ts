import { ActivatedRoute } from '@angular/router';
import { Component, OnInit, ViewChild } from '@angular/core';
import { CountryFullView } from '../models/CountryFullView';
import { CountryRestClient } from '../services/CountryRestClient';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NavLink } from 'src/app/core/models/nav-link';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { Observable } from 'rxjs';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { StringUtils } from 'src/app/core/services/StringUtils';
/**
 * auto generated details component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@Component({
selector: 'app-country-details',
templateUrl: './country-details.component.html',
styleUrls: ['./country-details.component.scss']
})
export class CountryDetailsComponent implements OnInit {

id:number;
links:NavLink[];
activePath:string;
view: CountryFullView = new CountryFullView();
form: FormGroup;

constructor(private service:CountryRestClient, private route: ActivatedRoute, private formBuilder: FormBuilder, private notifications: NotificationService) {
this.id = parseInt(this.route.snapshot.paramMap.get('id'));
this.activePath = '/country/' + this.id.toString();
this.links=[{text:'Details',path:'/country/' + this.id.toString()}];
}

ngOnInit(): void {
this.form = this.formBuilder.group({
code:[null, Validators.required],
label:[null, Validators.required]})
this.load();
}
restoreForm(): void {
this.form.patchValue({
code: this.view.form.code,
label: this.view.form.label
})
}

applyForm(): void {
this.view.form.code = StringUtils.emptyToNull(this.form.get('code').value);
this.view.form.label = StringUtils.emptyToNull(this.form.get('label').value);
}

load(): void {
this.service.load(this.id).subscribe((t) => {this.view=t;this.restoreForm();});
}

update(): void {
this.applyForm();
this.service.update(this.id, this.view.form).subscribe(success => this.notifications.info("Operation completed"), error => {this.notifications.error("Operation failed")});
this.load();
}
/* Specific Code Start */
/* Specific Code End */
}
