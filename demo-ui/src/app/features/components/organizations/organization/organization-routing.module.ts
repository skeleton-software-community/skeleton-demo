import { NgModule } from '@angular/core';
import { OrganizationDetailsComponent } from './details/organization-details.component';
import { OrganizationListComponent } from './list/organization-list.component';
import { RouterModule, Routes } from '@angular/router';
/**
 * auto generated list routing module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

const routes: Routes = [
{path: 'list', component: OrganizationListComponent }
,{path: ':id', component: OrganizationDetailsComponent }
];

@NgModule({
imports: [RouterModule.forChild(routes)],
exports: [RouterModule]
})
export class OrganizationRoutingModule { }
