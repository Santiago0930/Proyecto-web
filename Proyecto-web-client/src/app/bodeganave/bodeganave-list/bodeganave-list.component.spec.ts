import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BodeganaveListComponent } from './bodeganave-list.component';

describe('BodeganaveListComponent', () => {
  let component: BodeganaveListComponent;
  let fixture: ComponentFixture<BodeganaveListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BodeganaveListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BodeganaveListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
