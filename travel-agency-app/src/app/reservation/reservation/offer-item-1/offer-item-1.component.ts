import { Component, OnInit, Input } from '@angular/core';
import { OfferItemModel } from 'src/app/shared/models/offerItemModel';


@Component({
  selector: 'app-offer-item-1',
  templateUrl: './offer-item-1.component.html',
  styleUrls: ['./offer-item-1.component.css']
})
// tslint:disable-next-line: component-class-suffix
export class OfferItemComponent1 implements OnInit {

  @Input() offerItem;

  constructor() { }

  ngOnInit() {
  }

}
