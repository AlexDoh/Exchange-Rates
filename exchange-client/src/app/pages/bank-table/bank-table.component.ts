import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ExchangeInfo } from '../../models/exchange-info';
import { ProviderService } from "../../shared/services/message/provider.service";
import { ExchangeService } from "../../shared/services/rest/exchange.service";

@Component({
  selector: 'app-bank-table',
  templateUrl: './bank-table.component.html',
  styleUrls: [ './bank-table.component.scss' ]
})
export class BankTableComponent implements OnInit, OnChanges {

  @Input() exchangeData: ExchangeInfo;
  currencyType: string;
  isDesc: boolean = false;
  column: string = 'title';
  minAsk: number;

  constructor(
    private providerService: ProviderService,
    private exchangeService: ExchangeService,
    ) {}

  ngOnInit() {
    this.providerService.currentCurrency.subscribe(currency => {
      this.currencyType = currency;
      if (this.exchangeData) {

        this.minAsk = Number.MAX_SAFE_INTEGER;
        this.exchangeData.organizations.filter(organization => organization.currencies[ currency ]).forEach(organization => {
          const ask = parseFloat(organization.currencies[ currency ].ask);
          if (ask < this.minAsk) {
            this.minAsk = ask;
          }
        });
      }
    });
    this.exchangeService.getKursExchangeInfo()
  }

  sort(columnName) {
    this.isDesc = !this.isDesc;
    this.column = columnName;
  };

  ngOnChanges(changes: SimpleChanges): void {
    if (this.exchangeData) {
      this.setMinAskCurrency(this.exchangeData);
    }

    // if (changes.currencyType && !changes.currencyType.firstChange) {
    //   this.setMinAskCurrency(this.exchangeData, changes.currencyType.currentValue);
    // }
  }

  setMinAskCurrency(exchangeData: ExchangeInfo, newCurrency?: string): void {
    this.minAsk = Number.MAX_SAFE_INTEGER;
    exchangeData.organizations.filter(organization => organization.currencies[ this.currencyType || newCurrency ]).forEach(organization => {
      const ask = parseFloat(organization.currencies[ this.currencyType || newCurrency ].ask);
      if (ask < this.minAsk) {
        this.minAsk = ask;
      }
    });
  }

}
