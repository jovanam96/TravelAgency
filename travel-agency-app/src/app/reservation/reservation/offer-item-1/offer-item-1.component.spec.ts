import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OfferItemComponent1 } from './offer-item-1.component';

describe('OfferItemComponent', () => {
  let component: OfferItemComponent1;
  let fixture: ComponentFixture<OfferItemComponent1>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OfferItemComponent1 ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OfferItemComponent1);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
