import { Injectable } from '@angular/core';
import { BehaviorSubject ,  Subject } from "rxjs";
import { ExchangeInfo } from "../../../models/exchange-info";

@Injectable()
export class ProviderService {

  private defaultCurrency = 'USD';
  private currencySource = new BehaviorSubject<string>(this.defaultCurrency);
  currentCurrency = this.currencySource.asObservable();

  subjectProvider = new Subject<ExchangeInfo>();

  constructor() { }

  changeCurrency(currency: string) {
    this.currencySource.next(currency);
  }

}
