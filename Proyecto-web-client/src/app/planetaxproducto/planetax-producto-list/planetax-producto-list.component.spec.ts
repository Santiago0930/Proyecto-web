import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanetaxProductoListComponent } from './planetax-producto-list.component';

describe('PlanetaxProductoListComponent', () => {
  let component: PlanetaxProductoListComponent;
  let fixture: ComponentFixture<PlanetaxProductoListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PlanetaxProductoListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PlanetaxProductoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
