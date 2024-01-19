import { Component, Input, OnInit } from '@angular/core';
import { NavLink } from 'src/app/core/models/nav-link';
/**
 * auto generated menu component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@Component({
selector: 'app-fool-menu',
templateUrl: './fool-menu.component.html',
styleUrls: ['./fool-menu.component.scss']
})
export class FoolMenuComponent implements OnInit {

links:NavLink[];
@Input() id:string;
@Input() activePath:string;

ngOnInit(): void {
this.links=[{text:'Details',path:'/fool/' + this.id.toString()},{text:'Stupids',path:'/fool/' + this.id.toString() + '/stupid/list'}];
}
}
