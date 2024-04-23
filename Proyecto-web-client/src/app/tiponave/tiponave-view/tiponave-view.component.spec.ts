import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TiponaveViewComponent } from './tiponave-view.component';

describe('TiponaveViewComponent', () => {
  let component: TiponaveViewComponent;
  let fixture: ComponentFixture<TiponaveViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TiponaveViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TiponaveViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
