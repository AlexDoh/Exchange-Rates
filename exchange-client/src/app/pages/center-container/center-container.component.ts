import { Component, OnInit } from '@angular/core';
import { ExchangeService } from '../../shared/services/exchange.service';
import { ExchangeInfo } from '../../models/exchange-info';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ExchangeOrganization } from '../../models/exchange-organization';
import { UtilsService } from "../../shared/services/utils.service";

@Component({
  selector: 'app-center-container',
  templateUrl: './center-container.component.html',
  styleUrls: [ './center-container.component.scss' ]
})
export class CenterContainerComponent implements OnInit {

  exchangeData: ExchangeInfo;
  title: string = 'Finance';
  selectedCurrency: string;
  selectCurrencyForm: FormGroup;
  priorityCurrencies: string[] = ['USD', 'EUR', 'RUB'];
  priorityCurrenciesMap: Map<string, string> = new Map<string, string>();
  regularCurrenciesMap: Map<string, string> = new Map<string, string>();

  constructor(
    private exchangeService: ExchangeService,
    private utilsService: UtilsService<string, string>,
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
    this.exchangeData.currencies.forEach((currencyText, currencyType) => {
      this.priorityCurrencies.includes(currencyType) ?
        this.priorityCurrenciesMap.set(currencyType, currencyText) :
        this.regularCurrenciesMap.set(currencyType, currencyText);
    });
  };

  get priorityCurrenciesArray(): Array<[string, string]> {
    return this.utilsService.getArrayFromMapEntries(this.priorityCurrenciesMap.entries());
  }

  get regularCurrenciesArray(): Array<[string, string]> {
    return this.utilsService.getArrayFromMapEntries(this.regularCurrenciesMap.entries());
  }

  requestExchangeData(): void {
    this.exchangeService.getFinanceExchangeInfo().subscribe(result => this.processExchangeData(result));
  };

  initForm() {
    this.selectCurrencyForm = this.fb.group({
      currency: 'USD',
    });

    this.selectCurrencyForm.valueChanges.subscribe(value => {
      this.selectedCurrency = value.currency;
    });
  }
}
