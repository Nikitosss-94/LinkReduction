import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinkshortComponent } from './linkshort.component';

describe('LinkshortComponent', () => {
  let component: LinkshortComponent;
  let fixture: ComponentFixture<LinkshortComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinkshortComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinkshortComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
