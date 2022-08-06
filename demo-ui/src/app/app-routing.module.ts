import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
/**
 * auto generated app routing module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

const routes: Routes = [
{path:'country', loadChildren:()=>import('src/app/features/generated/reference/localization/country/country.module').then(m=>m.CountryModule) }
,{path:'region', loadChildren:()=>import('src/app/features/generated/reference/localization/region/region.module').then(m=>m.RegionModule) }
,{path:'city', loadChildren:()=>import('src/app/features/generated/reference/localization/city/city.module').then(m=>m.CityModule) }
,{path:'calendar', loadChildren:()=>import('src/app/features/generated/reference/time/calendar/calendar.module').then(m=>m.CalendarModule) }
,{path:'organization', loadChildren:()=>import('src/app/features/generated/organizations/organization/organization.module').then(m=>m.OrganizationModule) }
,{path:'fool', loadChildren:()=>import('src/app/features/generated/dummy/fool/fool.module').then(m=>m.FoolModule) }
,{path:'stupid', loadChildren:()=>import('src/app/features/generated/dummy/stupid/stupid.module').then(m=>m.StupidModule) }
/* Specific Code Start */

/* Specific Code End */
];

@NgModule({
imports: [RouterModule.forRoot(routes)],
exports: [RouterModule]
})
export class AppRoutingModule { }
