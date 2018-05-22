import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from '../../../../environments/environment';
import { ExchangeInfo } from '../../../models/exchange-info';
import { map } from 'rxjs/operators';

@Injectable()
export class ExchangeService {

  constructor(private http: HttpClient) {
  }

  getFinanceExchangeInfo(): Observable<ExchangeInfo> {
    return this.http.get<ExchangeInfo>(environment.api.exchange.get.finance).pipe(map(result => new ExchangeInfo(result)));
  }

  getKursExchangeInfo(): Observable<ExchangeInfo> {
    return this.http.get<ExchangeInfo>(environment.api.exchange.get.kurs).pipe(map(result => new ExchangeInfo(result)));
  }

}
