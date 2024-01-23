import { Component, Input, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

//child component 
export class HomeComponent {
  
  @Input() inputData!:string;
  @Output() outEvent:EventEmitter<String> = new EventEmitter();
  outputData:string = "This is Event type example to send to data vai event binding ";
  
  sendData(){
    this.outEvent.emit(this.outputData);
  }
}
