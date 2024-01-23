import { AfterViewInit, Component, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit {

  myData ="This is the text which from parent to child";
  
  myevnentData:any ;
  
  getData(data:any){
    console.log(data);
    this.myevnentData = data;
  }

  @ViewChild("highlight") element!:ElementRef

  ngAfterViewInit(): void {
    //  this.element.nativeElement.style.color="red";
  }
  

}
