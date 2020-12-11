import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';

import { routing, appRoutingProviders } from './app.routing';

import { PeopleListComponent } from './components/peopleList.component';
		
import { FormsModule }   from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AccordionModule } from 'primeng/components/accordion/accordion';
import { PanelModule } from 'primeng/components/panel/panel';
import { ButtonModule } from 'primeng/components/button/button';
import { RadioButtonModule } from 'primeng/components/radiobutton/radiobutton';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {DataTableModule,SharedModule} from 'primeng/primeng';

import { DialogModule } from 'primeng/components/dialog/dialog';



@NgModule({
  declarations: [
    AppComponent,
	PeopleListComponent
  ],
  imports: [
    BrowserModule,
	routing,
	FormsModule,
	HttpModule,
	AccordionModule,
	PanelModule,
	ButtonModule,
	RadioButtonModule,
	BrowserAnimationsModule,
	DataTableModule,
	SharedModule,
	DialogModule
  ],
  providers: [
	appRoutingProviders
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
