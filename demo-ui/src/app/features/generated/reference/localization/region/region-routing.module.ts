import { NgModule } from '@angular/core';
import { RegionDetailsComponent } from './details/region-details.component';
import { RegionListComponent } from './list/region-list.component';
import { RouterModule, Routes } from '@angular/router';
/**
 * auto generated list routing module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

const routes: Routes = [
{path: 'list', component: RegionListComponent }
,{path: ':id', component: RegionDetailsComponent }
];

@NgModule({
imports: [RouterModule.forChild(routes)],
exports: [RouterModule]
})
export class RegionRoutingModule { }
