import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BankServicesComponent } from './bank-services.component';
import { ExchangeService } from '../../../shared/services/rest/exchange.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ProviderService } from '../../../shared/services/message/provider.service';

describe('BankServicesComponent', () => {
  let component: BankServicesComponent;
  let fixture: ComponentFixture<BankServicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ],
      providers: [
        ExchangeService,
        ProviderService
      ],
      declarations: [ BankServicesComponent ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BankServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
