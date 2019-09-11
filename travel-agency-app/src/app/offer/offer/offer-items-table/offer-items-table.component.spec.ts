import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OfferItemsTableComponent } from './offer-items-table.component';

describe('OfferItemsTableComponent', () => {
  let component: OfferItemsTableComponent;
  let fixture: ComponentFixture<OfferItemsTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OfferItemsTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OfferItemsTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
