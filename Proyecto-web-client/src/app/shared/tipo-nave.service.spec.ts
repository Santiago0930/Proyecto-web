import { TestBed } from '@angular/core/testing';

import { TipoNaveService } from './tipo-nave.service';

describe('TipoNaveService', () => {
  let service: TipoNaveService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TipoNaveService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
