import { Component, OnInit } from '@angular/core';
import { ExchangeService } from '../../shared/services/exchange.service';
import { ExchangeInfo } from '../../models/exchange-info';
import { ControlValueAccessor, FormBuilder, FormGroup, NG_VALUE_ACCESSOR } from '@angular/forms';

@Component({
  selector: 'app-center-container',
  templateUrl: './center-container.component.html',
  styleUrls: [ './center-container.component.scss' ],
  providers: [{
    provide: NG_VALUE_ACCESSOR,
    multi: true,
    useExisting: CenterContainerComponent
  }]
})
export class CenterContainerComponent implements OnInit, ControlValueAccessor {

  exchangeData: ExchangeInfo = new ExchangeInfo();
  title: string = 'Finance';
  selectedCurrency: string;
  selectCurrencyForm: FormGroup;
  kolo: any;

  constructor(
    private exchangeService: ExchangeService,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.requestExchangeData();
    this.initForm();
    this.yolo();
    this.selectedCurrency = 'USD';
  }

  requestExchangeData(): void {
    this.exchangeService.getFinanceExchangeInfo().subscribe(result => this.exchangeData = result);
  };

  yolo() {
    console.log(this.selectCurrencyForm.value);
  }

  initForm() {
    this.selectCurrencyForm = this.fb.group({
      currency: 'USD',
    });

    this.selectCurrencyForm.valueChanges.subscribe((value) => {
      this.selectedCurrency = value.currency;
    });
  }

  getCurrency() {
    return this.selectedCurrency;
  }

  registerOnChange(fn: any): void {
    this.kolo = fn;
  }

  registerOnTouched(fn: any): void {
    this.kolo = fn;
  }


  setDisabledState(isDisabled: boolean): void {
    console.log(isDisabled);
  }
  writeValue(obj: any): void {
    console.log(obj);
  }

}
