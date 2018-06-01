import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BankTableComponent } from './bank-table.component';
import { MatSpinner } from '@angular/material';
import { OrderPipe } from 'ngx-order-pipe';

describe('BankTableComponent', () => {
  let component: BankTableComponent;
  let fixture: ComponentFixture<BankTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        BankTableComponent,
        MatSpinner,
        OrderPipe
      ]
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
