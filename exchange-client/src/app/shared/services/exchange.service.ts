import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../../environments/environment';
import { ExchangeInfo } from '../../models/exchange-info';

@Injectable()
export class ExchangeService {

  constructor(private http: HttpClient) { }

  getFinanceExchangeInfo(): Observable<ExchangeInfo> {
    return this.http.get<ExchangeInfo>(environment.api.exchange.get.finance);
  }

}
