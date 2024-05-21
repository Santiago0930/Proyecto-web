import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TiponaveViewComComponent } from './tiponave-view-com.component';

describe('TiponaveViewComComponent', () => {
  let component: TiponaveViewComComponent;
  let fixture: ComponentFixture<TiponaveViewComComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TiponaveViewComComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TiponaveViewComComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
