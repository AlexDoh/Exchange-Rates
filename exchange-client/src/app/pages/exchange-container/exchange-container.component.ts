import { Component, OnInit } from '@angular/core';
import { ExchangeService } from '../../shared/services/rest/exchange.service';
import { ExchangeInfo } from '../../models/exchange-info';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UtilsService } from '../../shared/services/utils.service';
import { ProviderService } from '../../shared/services/message/provider.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-exchange-container',
  templateUrl: './exchange-container.component.html',
  styleUrls: [ './exchange-container.component.scss' ]
})
export class ExchangeContainerComponent implements OnInit {

  exchangeData: ExchangeInfo;
  title = 'Select provider';
  selectedCurrency = 'USD';
  selectCurrencyForm: FormGroup;
  priorityCurrencies: string[] = [ 'USD', 'EUR', 'RUB' ];
  priorityCurrenciesMap: Map<string, string> = new Map<string, string>();
  regularCurrenciesMap: Map<string, string> = new Map<string, string>();

  constructor(
    private exchangeService: ExchangeService,
    private utilsService: UtilsService<string, string>,
    private providerService: ProviderService,
    private fb: FormBuilder
  ) {
  }

  ngOnInit() {
    this.initForm();
    this.providerService.changeProviderSubject.subscribe(
      (exchangeData: ExchangeInfo) => {
        if (Object.keys(exchangeData).length !== 0) {
          this.providerService.changeCurrencySubject.next(this.selectedCurrency);
          this.changeProvider(exchangeData);
        }
      },
      (err: HttpErrorResponse) => {
      }
    );
  }

  get priorityCurrenciesArray(): Array<[ string, string ]> {
    return this.utilsService.getArrayFromMapEntries(this.priorityCurrenciesMap.entries());
  }

  get regularCurrenciesArray(): Array<[ string, string ]> {
    return this.utilsService.getArrayFromMapEntries(this.regularCurrenciesMap.entries());
  }

  initForm(): void {
    this.selectCurrencyForm = this.fb.group({
      currency: this.selectedCurrency,
    });

    this.selectCurrencyForm.valueChanges.subscribe(value => {
      this.selectedCurrency = value.currency;
      this.providerService.changeCurrencySubject.next(value.currency);
    });
  }

  changeProvider(exchangeData: ExchangeInfo): void {
    this.exchangeData = exchangeData;
    this.exchangeData.currencies.forEach((currencyText, currencyType) => {
      this.priorityCurrencies.includes(currencyType) ?
        this.priorityCurrenciesMap.set(currencyType, currencyText) :
        this.regularCurrenciesMap.set(currencyType, currencyText);
    });
  }
}
