import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiplayDvdComponent } from './diplay-dvd.component';

describe('DiplayDvdComponent', () => {
  let component: DiplayDvdComponent;
  let fixture: ComponentFixture<DiplayDvdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiplayDvdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiplayDvdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
