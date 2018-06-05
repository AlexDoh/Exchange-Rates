import { Component, OnInit } from '@angular/core';
import { ExchangeService } from '../../../shared/services/rest/exchange.service';
import { ProviderService } from '../../../shared/services/message/provider.service';
import { ExchangeInfo } from '../../../models/exchange-info';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-bank-services',
  templateUrl: './bank-services.component.html',
  styleUrls: [ './bank-services.component.scss' ]
})
export class BankServicesComponent implements OnInit {

  activeProvider = 'Finance.ua';

  constructor(
    private exchangeService: ExchangeService,
    private providerService: ProviderService
  ) {
  }

  ngOnInit() {
    this.requestFinanceExchangeData();
  }

  requestFinanceExchangeData(): void {
    this.providerService.startedLoadProviderSubject.next();
    this.activeProvider = 'Finance.ua';
    this.exchangeService.getFinanceExchangeInfo().subscribe(
      (result: ExchangeInfo) => this.providerService.changeProviderSubject.next(result),
      (err: HttpErrorResponse) => this.providerService.changeProviderSubject.next({} as ExchangeInfo)
    );
  }

  requestKursExchangeData(): void {
    this.providerService.startedLoadProviderSubject.next();
    this.activeProvider = 'Kurs.com.ua';
    this.exchangeService.getKursExchangeInfo().subscribe(
      (result: ExchangeInfo) => this.providerService.changeProviderSubject.next(result),
      (err: HttpErrorResponse) => this.providerService.changeProviderSubject.next({} as ExchangeInfo)
    );
  }

}
