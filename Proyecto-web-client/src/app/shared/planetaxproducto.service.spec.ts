import { TestBed } from '@angular/core/testing';

import { PlanetaxproductoService } from './planetaxproducto.service';

describe('PlanetaxproductoService', () => {
  let service: PlanetaxproductoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlanetaxproductoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
