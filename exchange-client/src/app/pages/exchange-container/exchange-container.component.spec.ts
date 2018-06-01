import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExchangeContainerComponent } from './exchange-container.component';
import { LeftSidebarComponent } from '../left-sidebar/left-sidebar.component';
import { BankServicesComponent } from './bank-services/bank-services.component';
import { BankTableComponent } from './bank-table/bank-table.component';
import { MatSpinner } from '@angular/material';
import { ReactiveFormsModule } from '@angular/forms';
import { OrderPipe } from 'ngx-order-pipe';

describe('CenterContainerComponent', () => {
  let component: ExchangeContainerComponent;
  let fixture: ComponentFixture<ExchangeContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [ ReactiveFormsModule ],
      declarations: [
        ExchangeContainerComponent,
        LeftSidebarComponent,
        BankServicesComponent,
        BankTableComponent,
        MatSpinner,
        OrderPipe
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExchangeContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
