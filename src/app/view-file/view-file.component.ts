// view-file.component.ts
import { Component, OnInit, OnDestroy } from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import { FileUploadService } from '../file.service';

@Component({
  selector: 'app-view-file',
  templateUrl: './view-file.component.html',
  styleUrls: ['./view-file.component.css']
})
export class ViewFileComponent implements OnInit, OnDestroy {

  pdfBlob: Blob;
  private pdfBlobUrl: string;

  constructor(private fileUploadService: FileUploadService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const fileId = this.route.snapshot.params['fileId'];

    if (fileId) {
      this.fileUploadService.getPdf(fileId).subscribe(
        (pdfBlob: Blob) => {
          this.pdfBlob = pdfBlob;
        },
        error => {
          console.error('Error retrieving PDF file', error);
          // Handle error
        }
      );
    } else {
      console.error('File ID not provided');
      // Handle error
    }
  }

  getBlobUrl(): string {
    if (this.pdfBlob && !this.pdfBlobUrl) {
      // Create a Blob URL
      this.pdfBlobUrl = URL.createObjectURL(this.pdfBlob);
    }
    return this.pdfBlobUrl;
  }

  ngOnDestroy(): void {
    // Revoke the Blob URL when the component is destroyed
    if (this.pdfBlobUrl) {
      URL.revokeObjectURL(this.pdfBlobUrl);
    }
  }
}
























// import { Component, OnInit } from '@angular/core';
// import { FileUploadService } from '../File/file-upload.service';
// import { ActivatedRoute } from '@angular/router';

// @Component({
//   selector: 'app-view-file',
//   templateUrl: './view-file.component.html',
//   styleUrls: ['./view-file.component.css']
// })
// export class ViewFileComponent implements OnInit {

//   pdfBlob: Blob;


//   constructor(private fileUploadService: FileUploadService, private route: ActivatedRoute) { }

//   ngOnInit(): void {
//     const fileId = this.route.snapshot.params['fileId'];

//     if (fileId) {
//       this.fileUploadService.getPdf(fileId).subscribe(
//         (pdfBlob: Blob) => {
//           this.pdfBlob = pdfBlob;
//         },
//         error => {
//           console.error('Error retrieving PDF file', error);
//           // Handle error
//         }
//       );
//     } else {
//       console.error('File ID not provided');
//       // Handle error
//     }
//   }
// }
