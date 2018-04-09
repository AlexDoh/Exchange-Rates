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
  exchangeInfo: ExchangeInfo;
  isDesc: boolean = false;
  column: string = 'title';
  direction: number = 1;

  constructor() { }

  ngOnInit() {
  }

  sort(property){
    this.isDesc = !this.isDesc; //change the direction
    this.column = property;
    this.direction = this.isDesc ? 1 : -1;
  };



  // ngOnChanges(changes: SimpleChanges) {
  //   if (changes['exchangeData']) {
  //     this.exchangeData = this.exchangeData;
  //   }
  // }

}
