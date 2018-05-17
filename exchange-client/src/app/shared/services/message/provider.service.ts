import { Injectable } from '@angular/core';
import { BehaviorSubject ,  Subject } from "rxjs";
import { ExchangeInfo } from "../../../models/exchange-info";

@Injectable()
export class ProviderService {

  private defaultCurrency = 'USD';
  private currencySource = new BehaviorSubject<string>(this.defaultCurrency);
  currentCurrency = this.currencySource.asObservable();

  changeProviderSubject = new Subject<ExchangeInfo>();
  startedLoadProviderSubject = new Subject<void>();

  constructor() { }

  changeCurrency(currency: string) {
    this.currencySource.next(currency);
  }

}
