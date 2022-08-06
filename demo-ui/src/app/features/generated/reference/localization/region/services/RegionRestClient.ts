import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RegionBasicView } from '../models/RegionBasicView';
import { RegionFilter } from '../models/RegionFilter';
import { RegionForm } from '../models/RegionForm';
import { RegionFullView } from '../models/RegionFullView';
import { RegionSorting } from '../models/RegionSorting';
import { ScrollForm } from "src/app/core/models/ScrollForm";
import { ScrollView } from "src/app/core/models/ScrollView";
import { SelectItem } from "src/app/core/models/SelectItem";
import { environment } from 'src/environments/environment';

/**
 * auto generated rest client ts file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
@Injectable({providedIn:'root'})
export class RegionRestClient {

private httpOptions = {headers:new HttpHeaders({'Content-Type':'application/json'})};

constructor(private http: HttpClient) { }
/**
 * load object list
 */
public loadList() {
return this.http.get<RegionBasicView[]>(environment.restApiUrl + '/region/list');
}

/**
 * load object list from country
 */
public loadListFromCountry (countryId: number) {
return this.http.get<RegionBasicView[]>(environment.restApiUrl + '/region/' + countryId + '/country/list');
}

/**
 * scroll object list
 */
public scroll(form: ScrollForm<RegionFilter, RegionSorting>) {
return this.http.post<ScrollView<RegionBasicView>>(environment.restApiUrl + '/region/scroll', form, this.httpOptions);
}

/**
 * scroll object list from country
 */
public scrollFromCountry (countryId: number, form: ScrollForm<RegionFilter, RegionSorting>) {
return this.http.post<ScrollView<RegionBasicView>>(environment.restApiUrl + '/region/' + countryId + '/country/scroll', form, this.httpOptions);
}

/**
 * load object
 */
public load(id:number) {
return this.http.get<RegionFullView>(environment.restApiUrl + '/region/' + id);
}

/**
 * create object
 */
public create() {
return this.http.get<RegionFullView>(environment.restApiUrl + '/region/new');
}

/**
 * save object
 */
public save(form: RegionForm) {
return this.http.post<number>(environment.restApiUrl + '/region', form, this.httpOptions);
}

/**
 * update object
 */
public update(id: number, form: RegionForm) {
return this.http.put(environment.restApiUrl + '/region/' + id, form, this.httpOptions);
}

/**
 * delete object
 */
public delete(id: number) {
return this.http.delete(environment.restApiUrl + '/region/' + id);
}


/* Specific Code Start */
/* Specific Code End */

}
