import { Component, OnInit, ViewChild, Input, EventEmitter, Output, OnChanges } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { OfferItemComponent } from '../offer-item/offer-item.component';
import { OfferItemModel } from 'src/app/shared/models/offerItemModel';
import { MatTableDataSource } from '@angular/material/table';
import { RoomTypeServiceService } from 'src/app/shared/services/room-type-service.service';
import { UserProfile } from 'src/app/shared/models/userProfile';

@Component({
  selector: 'app-offer-items-table',
  templateUrl: './offer-items-table.component.html',
  styleUrls: ['./offer-items-table.component.css']
})
export class OfferItemsTableComponent implements OnChanges {

  displayedColumns = ['offerItemId.number', 'roomType', 'price'];
  @Input() items: Array<OfferItemModel>;
  @Input() details;
  selectedRow: OfferItemModel;
  dataSource = new MatTableDataSource(this.items);
  loggedUser: UserProfile = new UserProfile();

  @Output() updateItemsEvent = new EventEmitter();
  @Output() selectItemEvent = new EventEmitter();


  ngOnChanges(changes: import('@angular/core').SimpleChanges): void {
    this.loggedUser = JSON.parse(localStorage.getItem('userProfile'));
    if (this.details === false) {
      if (this.displayedColumns.indexOf('capacity') === -1) {
        this.displayedColumns.push('capacity');
      }
      if (this.displayedColumns.indexOf('action') === -1) {
        this.displayedColumns.push('action');
      }
    }
    if (this.details === true) {
      if (this.loggedUser === null || this.loggedUser.roles === 'CLIENT') {
        if (this.displayedColumns.indexOf('reserve') === -1) {
          this.displayedColumns.push('reserve');
        }
        for (const item of this.items) {
          console.log(item);
          if (item.capacity === 0) {
            this.items.splice(this.items.indexOf(item, 1));
          }
        }
      }
      if (this.loggedUser != null && this.loggedUser.roles === 'ADMIN') {
        if (this.displayedColumns.indexOf('capacity') === -1) {
          this.displayedColumns.push('capacity');
        }
      }
    }
    this.dataSource = new MatTableDataSource(this.items);
  }

  constructor(public dialog: MatDialog, private roomTypeService: RoomTypeServiceService) { }


  addItem() {
    let offerItem = new OfferItemModel();
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.disableClose = true;
    dialogConfig.width = '25%';
    dialogConfig.data = { offerItem };
    this.dialog.open(OfferItemComponent, dialogConfig).afterClosed().subscribe(
      result => {
        offerItem = result;
        this.roomTypeService.getOne(offerItem.roomType.roomTypeId).subscribe(
          res => offerItem.roomType = res
        );
        if (offerItem != null) {
          this.items.push(offerItem);
          this.addItemNumber();
          this.updateItems();
          this.dataSource = new MatTableDataSource(this.items);
        }
      }
    );
  }

  updateItems() {
    this.updateItemsEvent.emit(this.items);
  }

  addItemNumber() {
    let no = 1;
    for (const item of this.items) {
      item.offerItemId.number = no;
      no = no + 1;
    }
  }

  deleteItem(offerItem: OfferItemModel) {
    if (confirm('Are you sure you want to delete item?')) {
      const index = this.items.indexOf(offerItem);
      this.items.splice(index, 1);
      this.addItemNumber();
      this.dataSource = new MatTableDataSource(this.items);
    }
  }

  editItem(offerItem: OfferItemModel) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.disableClose = true;
    dialogConfig.width = '25%';
    dialogConfig.data = { offerItem };
    this.dialog.open(OfferItemComponent, dialogConfig).afterClosed().subscribe(
      result => {
        if (result != null) {
          this.roomTypeService.getOne(offerItem.roomType.roomTypeId).subscribe(
            res => result.roomType = res
          );
          this.items[this.items.indexOf(offerItem)] = result;
          this.updateItems();
          this.dataSource = new MatTableDataSource(this.items);
        }
      }
    );
  }

  makeReservation(offerItem: OfferItemModel) {
    this.selectItemEvent.emit(offerItem);
  }

  selectRow(row) {
    this.selectedRow = row;
    //  this.selectItemEvent.emit(this.selectedRow);
  }

  sortingDataAccessor(item, property) {
    if (property.includes('.')) {
      return property.split('.')
        .reduce((object, key) => object[key] || '', item);
    }
    return item[property];
  }
}
