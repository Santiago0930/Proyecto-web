import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanetaListComponent } from './planeta-list.component';

describe('PlanetaListComponent', () => {
  let component: PlanetaListComponent;
  let fixture: ComponentFixture<PlanetaListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PlanetaListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PlanetaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
