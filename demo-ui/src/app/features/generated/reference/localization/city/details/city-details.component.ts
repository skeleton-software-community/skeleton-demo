import { ActivatedRoute } from '@angular/router';
import { CityFullView } from '../models/CityFullView';
import { CityRestClient } from '../services/CityRestClient';
import { Component, OnInit, ViewChild } from '@angular/core';
import { CountryRestClient } from 'src/app/features/generated/reference/localization/country/services/CountryRestClient';
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
selector: 'app-city-details',
templateUrl: './city-details.component.html',
styleUrls: ['./city-details.component.scss']
})
export class CityDetailsComponent implements OnInit {

id:number;
links:NavLink[];
activePath:string;
view: CityFullView = new CityFullView();
form: FormGroup;
regionCountryCodeOptions: SelectItem[];

constructor(private service:CityRestClient, private countryService:CountryRestClient, private route: ActivatedRoute, private formBuilder: FormBuilder, private notifications: NotificationService) {
this.id = parseInt(this.route.snapshot.paramMap.get('id'));
this.activePath = '/city/' + this.id.toString();
this.links=[{text:'Details',path:'/city/' + this.id.toString()}];
}

ngOnInit(): void {
this.form = this.formBuilder.group({
regionCountryCode:[null, Validators.required],
regionCode:[null, Validators.required],
code:[null, Validators.required],
label:[null, Validators.required]})
this.load();
}
restoreForm(): void {
this.form.patchValue({
regionCountryCode: this.view.form.regionCountryCode,
regionCode: this.view.form.regionCode,
code: this.view.form.code,
label: this.view.form.label
})
}

applyForm(): void {
this.view.form.regionCountryCode = StringUtils.emptyToNull(this.form.get('regionCountryCode').value);
this.view.form.regionCode = StringUtils.emptyToNull(this.form.get('regionCode').value);
this.view.form.code = StringUtils.emptyToNull(this.form.get('code').value);
this.view.form.label = StringUtils.emptyToNull(this.form.get('label').value);
}

load(): void {
this.service.load(this.id).subscribe((t) => {this.view=t;this.restoreForm();});
this.loadOptionsForRegionCountryCode();
}

loadOptionsForRegionCountryCode() {
this.countryService.getOptions().subscribe((t) => {this.regionCountryCodeOptions=t;});
}

update(): void {
this.applyForm();
this.service.update(this.id, this.view.form).subscribe(success => this.notifications.info("Operation completed"), error => {this.notifications.error("Operation failed")});
this.load();
}
/* Specific Code Start */
/* Specific Code End */
}
