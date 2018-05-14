import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { environment } from '../../../../environments/environment';
import { ExchangeInfo } from '../../../models/exchange-info';

@Injectable()
export class ExchangeService {

  constructor(private http: HttpClient) {
  }

  getFinanceExchangeInfo(): Observable<ExchangeInfo> {
    return this.http.get<ExchangeInfo>(environment.api.exchange.get.finance).map(result => new ExchangeInfo(result));
  }

  getKursExchangeInfo(): Observable<ExchangeInfo> {
    return this.http.get<ExchangeInfo>(environment.api.exchange.get.kurs).map(result => new ExchangeInfo(result));
  }

}
