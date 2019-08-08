import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiplayBookComponent } from './diplay-book.component';

describe('DiplayBookComponent', () => {
  let component: DiplayBookComponent;
  let fixture: ComponentFixture<DiplayBookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiplayBookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiplayBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
