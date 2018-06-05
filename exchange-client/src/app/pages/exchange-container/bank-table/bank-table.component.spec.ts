import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BankTableComponent } from './bank-table.component';
import { MatSpinner } from '@angular/material';
import { OrderPipe } from 'ngx-order-pipe';
import { ProviderService } from '../../../shared/services/message/provider.service';
import { ExchangeService } from '../../../shared/services/rest/exchange.service';

describe('BankTableComponent', () => {
  let component: BankTableComponent;
  let fixture: ComponentFixture<BankTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        BankTableComponent,
        MatSpinner,
        OrderPipe
      ],
      providers: [
        ExchangeService,
        ProviderService
      ],
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BankTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
