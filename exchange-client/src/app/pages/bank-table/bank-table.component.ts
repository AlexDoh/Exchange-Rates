import { Component, Input, OnInit } from '@angular/core';
import { ExchangeInfo } from '../../models/exchange-info';

@Component({
  selector: 'app-bank-table',
  templateUrl: './bank-table.component.html',
  styleUrls: ['./bank-table.component.scss']
})
export class BankTableComponent implements OnInit {

  @Input() exchangeData: ExchangeInfo;

  constructor() { }

  ngOnInit() {
  }

}
