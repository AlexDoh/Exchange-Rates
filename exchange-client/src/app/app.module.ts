import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { TopHeaderComponent } from './top-header/top-header.component';
import { LeftSidebarComponent } from './left-sidebar/left-sidebar.component';
import { CenterContainerComponent } from './center-container/center-container.component';
import { BankServicesComponent } from './bank-services/bank-services.component';
import { BankTableComponent } from './bank-table/bank-table.component';


@NgModule({
  declarations: [
    AppComponent,
    TopHeaderComponent,
    LeftSidebarComponent,
    CenterContainerComponent,
    BankServicesComponent,
    BankTableComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
