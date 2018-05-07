import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ExchangeInfo } from '../../models/exchange-info';

@Component({
  selector: 'app-bank-table',
  templateUrl: './bank-table.component.html',
  styleUrls: [ './bank-table.component.scss' ]
})
export class BankTableComponent implements OnInit, OnChanges {

  @Input() exchangeData: ExchangeInfo;
  @Input() currencyType: string;
  isDesc: boolean = false;
  column: string = 'title';
  minAsk: number = Number.MAX_SAFE_INTEGER;

  constructor() {
  }

  ngOnInit() {
  }

  sort(columnName) {
    this.isDesc = !this.isDesc;
    this.column = columnName;
  };

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.exchangeData.currentValue) {
      this.setMinAskCurrency(changes.exchangeData.currentValue);
    }
  }

  setMinAskCurrency(exchangeData: ExchangeInfo): void {
    exchangeData.organizations.forEach(organization => {
      Object.entries(organization.currencies).filter(([ currencyType ]) =>
        currencyType === this.currencyType).forEach(([ currencyType, currencyData ]) => {
        const ask = parseFloat(currencyData.ask);
        if (ask < this.minAsk) {
          this.minAsk = ask;
        }
      })
    });
  }

}
