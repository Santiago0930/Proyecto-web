import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TiponaveListComponent } from './tiponave-list.component';

describe('TiponaveListComponent', () => {
  let component: TiponaveListComponent;
  let fixture: ComponentFixture<TiponaveListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TiponaveListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TiponaveListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
