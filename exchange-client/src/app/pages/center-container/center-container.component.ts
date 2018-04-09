import { Component, OnInit } from '@angular/core';
import { ExchangeService } from '../../shared/services/exchange.service';
import { ExchangeInfo } from '../../models/exchange-info';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-center-container',
  templateUrl: './center-container.component.html',
  styleUrls: [ './center-container.component.scss' ]
})
export class CenterContainerComponent implements OnInit {

  exchangeData: ExchangeInfo = new ExchangeInfo();
  title: string = 'Finance';
  selectedCurrency: string;
  selectCurrencyForm: FormGroup;

  constructor(
    private exchangeService: ExchangeService,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.requestExchangeData();
    this.initForm();
    this.selectedCurrency = 'USD';
  }

  requestExchangeData(): void {
    this.exchangeService.getFinanceExchangeInfo().subscribe(result => this.exchangeData = result);
  };

  initForm() {
    this.selectCurrencyForm = this.fb.group({
      currency: 'USD',
    });

    this.selectCurrencyForm.valueChanges.subscribe((value) => {
      this.selectedCurrency = value.currency;
    });
  }
}
