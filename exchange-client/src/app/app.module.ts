import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { OrderModule } from 'ngx-order-pipe';


import { AppComponent } from './app.component';
import { TopHeaderComponent } from './pages/top-header/top-header.component';
import { LeftSidebarComponent } from './pages/left-sidebar/left-sidebar.component';
import { CenterContainerComponent } from './pages/center-container/center-container.component';
import { BankServicesComponent } from './pages/bank-services/bank-services.component';
import { BankTableComponent } from './pages/bank-table/bank-table.component';
import { ExchangeService } from './shared/services/rest/exchange.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from "@angular/forms";
import { EntriesPipe } from './shared/pipes/entries.pipe';
import { ReactiveFormsModule } from '@angular/forms';
import { CurrencyPipe } from './shared/pipes/currency.pipe';
import { AppRoutingModule } from './app-routing.module';
import { WelcomeComponent } from './pages/welcome/welcome.component';
import { UtilsService } from "./shared/services/utils.service";
import { ProviderService } from "./shared/services/message/provider.service";
import { FooterComponent } from './pages/footer/footer.component';


@NgModule({
  declarations: [
    AppComponent,
    TopHeaderComponent,
    LeftSidebarComponent,
    CenterContainerComponent,
    BankServicesComponent,
    BankTableComponent,
    EntriesPipe,
    CurrencyPipe,
    WelcomeComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    OrderModule,
    AppRoutingModule
  ],
  providers: [
    ExchangeService,
    UtilsService,
    ProviderService
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule {
}
