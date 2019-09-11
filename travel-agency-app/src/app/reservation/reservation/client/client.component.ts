import { Component, OnInit, Input } from '@angular/core';
import { ClientModel } from 'src/app/shared/models/clientModel';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  @Input() client: ClientModel;

  constructor() { }

  ngOnInit() {
  }

}
