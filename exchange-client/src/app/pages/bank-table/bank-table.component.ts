import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ExchangeInfo } from '../../models/exchange-info';

@Component({
  selector: 'app-bank-table',
  templateUrl: './bank-table.component.html',
  styleUrls: ['./bank-table.component.scss']
})
export class BankTableComponent implements OnInit {

  @Input() exchangeData: ExchangeInfo;
  @Input() currency: string;
  exchangeInfo: ExchangeInfo;

  constructor() { }

  ngOnInit() {
  }



  // ngOnChanges(changes: SimpleChanges) {
  //   if (changes['exchangeData']) {
  //     this.exchangeData = this.exchangeData;
  //   }
  // }

}
