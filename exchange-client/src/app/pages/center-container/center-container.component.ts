import { Component, OnInit } from '@angular/core';
import { ExchangeService } from '../../shared/services/rest/exchange.service';
import { ExchangeInfo } from '../../models/exchange-info';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UtilsService } from "../../shared/services/utils.service";
import { ProviderService } from "../../shared/services/message/provider.service";

@Component({
  selector: 'app-center-container',
  templateUrl: './center-container.component.html',
  styleUrls: [ './center-container.component.scss' ]
})
export class CenterContainerComponent implements OnInit {

  exchangeData: ExchangeInfo;
  title: string = 'Select provider';
  selectedCurrency: string;
  selectCurrencyForm: FormGroup;
  priorityCurrencies: string[] = [ 'USD', 'EUR', 'RUB' ];
  priorityCurrenciesMap: Map<string, string> = new Map<string, string>();
  regularCurrenciesMap: Map<string, string> = new Map<string, string>();

  constructor(
    private exchangeService: ExchangeService,
    private utilsService: UtilsService<string, string>,
    private providerService: ProviderService,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.initForm();
    this.providerService.currentCurrency.subscribe(currency => this.selectedCurrency = currency);
    this.providerService.subjectProvider.subscribe(exchangeData => this.changeProvider(exchangeData))
  }

  get priorityCurrenciesArray(): Array<[ string, string ]> {
    return this.utilsService.getArrayFromMapEntries(this.priorityCurrenciesMap.entries());
  }

  get regularCurrenciesArray(): Array<[ string, string ]> {
    return this.utilsService.getArrayFromMapEntries(this.regularCurrenciesMap.entries());
  }

  initForm() {
    this.selectCurrencyForm = this.fb.group({
      currency: 'USD',
    });

    this.selectCurrencyForm.valueChanges.subscribe(value => {
      this.selectedCurrency = value.currency;
      this.providerService.changeCurrency(value.currency);
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
