import { Component, OnInit } from '@angular/core';
import { HotelModel } from '../../shared/models/hotelModel';
import { CityModel } from '../../shared/models/cityModel';
import { HotelServiceService } from '../../shared/services/hotel-service.service';
import { CityServiceService } from '../../shared/services/city-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.css']
})
export class HotelComponent implements OnInit {

  hotel: HotelModel = new HotelModel();
  cities: Array<CityModel> = new Array<CityModel>();
  selectedCity: CityModel = new CityModel();
  selectedFile: File;

  constructor(private hotelService: HotelServiceService, private cityService: CityServiceService,
              private courentRout: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.getCities();
    const hotelId = this.courentRout.snapshot.paramMap.get('hotelId');
    if (hotelId != null) {
      this.hotelService.getOne(+hotelId).subscribe(
        res => {
          this.hotel = res;
          this.selectedCity = this.hotel.city;
          const base64 = this.hotel.image.split(';')[1].split(',')[1];
          const format = this.hotel.image.split(';')[0].split(':')[1];
          const imageBlob = this.dataURItoBlob(base64, format);
          this.selectedFile = new File([imageBlob], this.hotel.fileName, { type: format });
        },
        err => {
          alert(err.error.message);
          this.router.navigate(['/all-hotels']);
        }
      );
    } else {
      this.hotel.image = '../../../../assets/images/default-image.png';
      this.selectedCity = new CityModel();
    }
  }

  saveOrUpdateHotel() {
    this.hotel.city = this.selectedCity;
    if (typeof this.selectedFile !== 'undefined') {
      this.hotel.fileName = this.selectedFile.name;
    }
    const formData = new FormData();
    formData.append('hotel', JSON.stringify(this.hotel));
    formData.append('file', this.selectedFile);
    if (this.hotel.hotelId == null) {
      this.hotelService.saveHotel(formData).subscribe(
        res => {
          alert('Hotel is successfully saved!');
          this.hotel = new HotelModel();
          this.hotel.image = '../../../../assets/images/default-image.png';
          this.selectedCity = new CityModel();
        },
        err => alert(err.error.message)
      );
    } else {
      this.hotelService.updateHotel(formData).subscribe(
        res => {
          alert('Hotel is successfully updated!');
          this.router.navigate(['/all-hotels']);
        },
        err => alert(err.error.message)
      );
    }
  }

  getCities() {
    this.cityService.getAll().subscribe(
      res => {
        res.sort((a, b) => a.name.localeCompare(b.name));
        this.cities = res;
      }
    );
  }

  uploadFile(event) {
    this.selectedFile = event.target.files[0];
    const reader = new FileReader();
    reader.onload = (e: any) => {
      this.hotel.image = e.target.result;
    };
    reader.readAsDataURL(this.selectedFile);
  }

  dataURItoBlob(dataURI, format) {
    const byteString = window.atob(dataURI);
    const arrayBuffer = new ArrayBuffer(byteString.length);
    const int8Array = new Uint8Array(arrayBuffer);
    for (let i = 0; i < byteString.length; i++) {
      int8Array[i] = byteString.charCodeAt(i);
    }
    const blob = new Blob([int8Array], { type: format });
    return blob;
  }

}
