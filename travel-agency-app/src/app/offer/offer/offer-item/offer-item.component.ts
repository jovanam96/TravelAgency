import { Component, OnInit, Inject, Output, EventEmitter } from '@angular/core';
import { RoomTypeServiceService } from 'src/app/shared/services/room-type-service.service';
import { RoomTypeModel } from 'src/app/shared/models/roomTypeModel';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { OfferItemModel } from 'src/app/shared/models/offerItemModel';

@Component({
  selector: 'app-offer-item',
  templateUrl: './offer-item.component.html',
  styleUrls: ['./offer-item.component.css']
})
export class OfferItemComponent implements OnInit {

  roomTypes: Array<RoomTypeModel> = new Array<RoomTypeModel>();
  offerItem: OfferItemModel;

  @Output() addItemEvent = new EventEmitter();

  constructor(private roomTypeService: RoomTypeServiceService,
              public dialogRef: MatDialogRef<OfferItemComponent>,
              @Inject(MAT_DIALOG_DATA) public data) { }

  ngOnInit() {
    this.getRoomTypes();
    if (this.data.offerItem.number === null) {
      this.offerItem = this.data.offerItem;
    } else {
      this.offerItem = Object.assign({}, this.data.offerItem);
    }
  }

  getRoomTypes() {
    this.roomTypeService.getAll().subscribe(
      res => this.roomTypes = res,
      err => alert('An error has occured!')
    );
  }

}
