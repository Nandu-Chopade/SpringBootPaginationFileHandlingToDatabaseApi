// file-upload.component.ts

import { Component, Input } from '@angular/core';
import { FileUploadService } from '../file.service';

@Component({
  selector: 'file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css']
})
export class FileUploadComponent {
  selectedFile: File ;

  constructor(private fileUploadService: FileUploadService) {}

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }

  uploadFile() {
    if (this.selectedFile) {
      this.fileUploadService.uploadFile(this.selectedFile)
        .subscribe(
          response => {
            console.log('Response from backend ---> ', response);
          },
          error => {
            console.error('Error uploading file', error);
          }
        );
    } else {
      console.warn('No file selected');
    }
  }

  
}
