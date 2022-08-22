import { CityFullView } from 'src/app/features/models/reference/localization/views/full/CityFullView';
import { CityRestClient } from 'src/app/features/services/reference/localization/CityRestClient';
import { Component, OnInit, ViewChild } from '@angular/core';
import { CountryRestClient } from 'src/app/features/services/reference/localization/CountryRestClient';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { Observable } from 'rxjs';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { StringUtils } from 'src/app/core/services/StringUtils';
/**
 * auto generated modal component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@Component({
selector: 'app-city-modal',
templateUrl: './city-modal.component.html',
styleUrls: ['./city-modal.component.scss']
})
export class CityModalComponent implements OnInit {

view: CityFullView;
form: FormGroup;
regionCountryCodeOptions: SelectItem[];

constructor(private service:CityRestClient, private countryService:CountryRestClient, private formBuilder: FormBuilder, private notifications: NotificationService, private dialogRef: MatDialogRef<CityModalComponent>) {}

ngOnInit(): void {
this.form = this.formBuilder.group({
regionCountryCode:[null, Validators.required],
regionCode:[null, Validators.required],
code:[null, Validators.required],
label:[null, Validators.required]});
this.loadOptionsForRegionCountryCode();
this.restoreForm();
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

loadOptionsForRegionCountryCode() {
this.countryService.getOptions().subscribe((t) => {this.regionCountryCodeOptions=t;});
}

save(): void {
this.applyForm();
this.service.save(this.view.form).subscribe(success => {this.notifications.info("Operation completed");this.dialogRef.close();}, error => {this.notifications.error("Operation failed")});
}

update(): void {
this.applyForm();
this.service.update(this.view.id, this.view.form).subscribe(success => {this.notifications.info("Operation completed");this.dialogRef.close();}, error => {this.notifications.error("Operation failed")});
}

saveOrUpdate(): void {
if (this.view.id == null) {this.save()} else {this.update()}
}

/* Specific Code Start */
/* Specific Code End */
}
