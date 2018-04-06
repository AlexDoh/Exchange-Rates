import { Component, OnInit } from '@angular/core';
import { ExchangeService } from '../../shared/services/exchange.service';
import { ExchangeInfo } from '../../models/exchange-info';

@Component({
  selector: 'app-center-container',
  templateUrl: './center-container.component.html',
  styleUrls: [ './center-container.component.scss' ]
})
export class CenterContainerComponent implements OnInit {

  constructor(private exchangeService: ExchangeService) {
  }

  exchangeData: ExchangeInfo;
  title: string = 'Finance';

  ngOnInit() {
    this.requestExchangeData();
  }

  requestExchangeData(): void {
    this.exchangeService.getFinanceExchangeInfo().subscribe(result => this.exchangeData = result);
  };

}
