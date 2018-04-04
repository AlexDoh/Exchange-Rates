import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { TopHeaderComponent } from './pages/top-header/top-header.component';
import { LeftSidebarComponent } from './pages/left-sidebar/left-sidebar.component';
import { CenterContainerComponent } from './pages/center-container/center-container.component';
import { BankServicesComponent } from './pages/bank-services/bank-services.component';
import { BankTableComponent } from './pages/bank-table/bank-table.component';
import { ExchangeService } from './shared/services/exchange.service';
import { HttpClientModule } from '@angular/common/http';


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
    BrowserModule,
    HttpClientModule
  ],
  providers: [
    ExchangeService
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule {
}
