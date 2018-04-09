import { Component, OnInit } from '@angular/core';
import { ExchangeService } from '../../shared/services/exchange.service';
import { ExchangeInfo } from '../../models/exchange-info';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ExchangeOrganization } from '../../models/exchange-organization';

@Component({
  selector: 'app-center-container',
  templateUrl: './center-container.component.html',
  styleUrls: [ './center-container.component.scss' ]
})
export class CenterContainerComponent implements OnInit {

  exchangeData: ExchangeInfo = new ExchangeInfo();
  title: string = 'Finance';
  selectedCurrency: string;
  selectCurrencyForm: FormGroup;
  priorityCurrencies: string[] = ['USD', 'EUR', 'RUB'];
  priorityCurrenciesMap: {} = {};
  regularCurrenciesMap: {} = {};

  constructor(
    private exchangeService: ExchangeService,
    private fb: FormBuilder
  ) {
  }

  ngOnInit() {
    this.requestExchangeData();
    this.initForm();
    this.selectedCurrency = 'USD';
  }

  processExchangeData(exchangeData) {
    this.exchangeData = exchangeData;
    Object.entries(this.exchangeData.currencies).forEach(([currencyType, currencyText]) => {
      this.priorityCurrencies.includes(currencyType) ?
        this.priorityCurrenciesMap[currencyType] =  currencyText :
        this.regularCurrenciesMap[currencyType] = currencyText;
    });
  }

  requestExchangeData(): void {
    this.exchangeService.getFinanceExchangeInfo().subscribe(result => this.processExchangeData(result));
  };

  initForm() {
    this.selectCurrencyForm = this.fb.group({
      currency: 'USD',
    });

    this.selectCurrencyForm.valueChanges.subscribe((value) => {
      this.selectedCurrency = value.currency;
    });
  }
}
