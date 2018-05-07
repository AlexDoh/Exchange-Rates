import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ExchangeService } from "../../shared/services/exchange.service";

@Component({
  selector: 'app-bank-services',
  templateUrl: './bank-services.component.html',
  styleUrls: [ './bank-services.component.scss' ]
})
export class BankServicesComponent implements OnInit {

  @Output() onSelectProvider: EventEmitter<any> = new EventEmitter();

  constructor(private exchangeService: ExchangeService) {
  }

  ngOnInit() {
    this.requestFinanceExchangeData();
  }

  requestFinanceExchangeData(): void {
    this.exchangeService.getFinanceExchangeInfo().subscribe(result => this.onSelectProvider.emit(result));
  };

  requestKursExchangeData(): void {
    this.exchangeService.getKursExchangeInfo().subscribe(result => this.onSelectProvider.emit(result));
  };

}
