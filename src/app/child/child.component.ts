import { AfterViewInit, Component, ViewChildren, QueryList} from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements AfterViewInit{
 
  @ViewChildren("highlight") element!:QueryList<any>;

  ngAfterViewInit(): void {
   
    console.log(this.element)
    this.element.first.nativeElement.style.color = "red"
    this.element.last.nativeElement.style.color = "blue"
    this.element.forEach((element , index) =>{
      element.nativeElement.style.color = this.getColorByIndex(index)
      element.nativeElement.style.fontSize = "20px"
    })

  }

  private getColorByIndex(index: number): string {
    switch (index) {
      case 0: return 'blue';
      case 1: return 'green';
      case 2: return 'red';
      default: return 'black';
    }


}
}