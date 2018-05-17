import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { ExchangeInfo } from '../../../models/exchange-info';

@Injectable()
export class ProviderService {

  changeCurrencySubject = new Subject<string>();
  changeProviderSubject = new Subject<ExchangeInfo>();
  startedLoadProviderSubject = new Subject<void>();

  constructor() { }
}
