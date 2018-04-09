import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ExchangeInfo } from '../../models/exchange-info';

@Component({
  selector: 'app-bank-table',
  templateUrl: './bank-table.component.html',
  styleUrls: ['./bank-table.component.scss']
})
export class BankTableComponent implements OnInit {

  @Input() exchangeData: ExchangeInfo;
  @Input() currencyType: string;
  isDesc: boolean = false;
  column: string = 'title';

  constructor() { }

  ngOnInit() {
  }

  sort(property){
    this.isDesc = !this.isDesc;
    this.column = property;
  };

}
