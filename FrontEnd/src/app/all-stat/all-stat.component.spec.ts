import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ClarityModule } from '@clr/angular';
import { AllStatComponent } from './all-stat.component';

describe('AllStatComponent', () => {
                                                
  let component: AllStatComponent;
  let fixture: ComponentFixture<AllStatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllStatComponent ],
      imports: [ClarityModule.forRoot()]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllStatComponent);
    component = fixture.componentInstance;

    fixture.detectChanges();            });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
