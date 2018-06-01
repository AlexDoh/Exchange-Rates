import { TestBed, inject } from '@angular/core/testing';

import { ExchangeService } from './exchange.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('ExchangeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ],
      providers: [ ExchangeService ]
    });
  });

  it('should be created', inject([ ExchangeService ], (service: ExchangeService) => {
    expect(service).toBeTruthy();
  }));
});
