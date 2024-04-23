import { TestBed } from '@angular/core/testing';

import { BodeganaveService } from './bodeganave.service';

describe('BodeganaveService', () => {
  let service: BodeganaveService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BodeganaveService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
