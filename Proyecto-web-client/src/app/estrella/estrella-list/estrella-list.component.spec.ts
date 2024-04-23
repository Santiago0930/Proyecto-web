import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstrellaListComponent } from './estrella-list.component';

describe('EstrellaListComponent', () => {
  let component: EstrellaListComponent;
  let fixture: ComponentFixture<EstrellaListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EstrellaListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EstrellaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
