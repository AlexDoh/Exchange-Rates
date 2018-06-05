import { Component, OnInit } from '@angular/core';
import { ExchangeInfo } from '../../../models/exchange-info';
import { ProviderService } from '../../../shared/services/message/provider.service';

@Component({
  selector: 'app-bank-table',
  templateUrl: './bank-table.component.html',
  styleUrls: [ './bank-table.component.scss' ]
})
export class BankTableComponent implements OnInit {

  exchangeData: ExchangeInfo;
  currencyType: string;
  isDesc = false;
  column = 'title';
  minAsk: number;
  isLoading: boolean;
  noProviderLoaded: boolean;

  constructor(private providerService: ProviderService) {
  }

  ngOnInit() {
    this.providerService.startedLoadProviderSubject.subscribe(() => this.isLoading = true);
    this.providerService.changeCurrencySubject.subscribe(currency => {
      this.currencyType = currency;
      if (this.exchangeData) {
        this.setMinAskCurrency();
      }
    });
    this.providerService.changeProviderSubject.subscribe(
      (exchangeData: ExchangeInfo) => {
        this.isLoading = false;
        if (Object.keys(exchangeData).length !== 0) {
          this.exchangeData = exchangeData;
          this.setMinAskCurrency();
        } else {
          this.exchangeData = null;
          this.noProviderLoaded = true;
        }
      }
    );
  }

  sort(columnName): void {
    this.isDesc = !this.isDesc;
    this.column = columnName;
  }

  setMinAskCurrency(): void {
    this.minAsk = Number.MAX_SAFE_INTEGER;
    this.exchangeData.organizations.filter(organization => organization.currencies[ this.currencyType ]).forEach(organization => {
      const ask = parseFloat(organization.currencies[ this.currencyType ].ask);
      if (ask < this.minAsk) {
        this.minAsk = ask;
      }
    });
  }

}
