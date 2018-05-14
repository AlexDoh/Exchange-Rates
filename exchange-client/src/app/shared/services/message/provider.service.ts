import { Injectable } from '@angular/core';
import { BehaviorSubject } from "rxjs/BehaviorSubject";

@Injectable()
export class ProviderService {

  private defaultCurrency = 'USD';
  private currencySource = new BehaviorSubject<string>(this.defaultCurrency);
  currentCurrency = this.currencySource.asObservable();

  constructor() { }

  changeCurrency(currency: string) {
    this.currencySource.next(currency);
  }

}
