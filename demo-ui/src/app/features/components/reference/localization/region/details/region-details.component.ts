import { ActivatedRoute } from '@angular/router';
import { Component, OnInit, ViewChild } from '@angular/core';
import { CountryRestClient } from 'src/app/features/services/reference/localization/CountryRestClient';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NavLink } from 'src/app/core/models/nav-link';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { Observable } from 'rxjs';
import { RegionFullView } from 'src/app/features/models/reference/localization/views/full/RegionFullView';
import { RegionRestClient } from 'src/app/features/services/reference/localization/RegionRestClient';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { StringUtils } from 'src/app/core/services/StringUtils';
/**
 * auto generated details component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@Component({
selector: 'app-region-details',
templateUrl: './region-details.component.html',
styleUrls: ['./region-details.component.scss']
})
export class RegionDetailsComponent implements OnInit {

id:number;
activePath:string;
view: RegionFullView = new RegionFullView();
form: FormGroup;
countryCodeOptions: SelectItem[];

constructor(private service:RegionRestClient, private countryService:CountryRestClient, private route: ActivatedRoute, private formBuilder: FormBuilder, private notifications: NotificationService) {
this.id = parseInt(this.route.snapshot.paramMap.get('id'));
this.activePath = '/region/' + this.id.toString();
}

ngOnInit(): void {
this.form = this.formBuilder.group({
countryCode:[{value:null}, Validators.required],
code:[{value:null}, Validators.required],
label:[{value:null}, Validators.required]})
this.load();
}
restoreForm(): void {
this.form.patchValue({
countryCode: this.view.form.countryCode,
code: this.view.form.code,
label: this.view.form.label
})
}

applyForm(): void {
this.view.form.countryCode = StringUtils.emptyToNull(this.form.get('countryCode').value);
this.view.form.code = StringUtils.emptyToNull(this.form.get('code').value);
this.view.form.label = StringUtils.emptyToNull(this.form.get('label').value);
}

load(): void {
this.service.load(this.id).subscribe((t) => {this.view=t;this.restoreForm();});
this.loadOptionsForCountryCode();
}

loadOptionsForCountryCode() {
this.countryService.getOptions().subscribe((t) => {this.countryCodeOptions=t;});
}

update(): void {
this.applyForm();
this.service.update(this.id, this.view.form).subscribe(success => {this.notifications.info("Operation completed");this.load();}, error => {this.notifications.error("Operation failed")});
}
/* Specific Code Start */
/* Specific Code End */
}
