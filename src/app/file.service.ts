// file-upload.service.ts

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FileUploadService {
  private apiUrl = 'http://localhost:8080/files';
  constructor(private http: HttpClient) {}

  uploadFile(file: File) {
    const formData: FormData = new FormData();
    formData.append('file', file, file.name);

    return this.http.post(`${this.apiUrl}/upload`, formData ,  { responseType: 'text' })
    .pipe(
      catchError((error) => {
        // Handle the 400 Bad Request error here
        console.error('Error uploading file:', error);
        return throwError('File upload failed. Please check your file and try again.');
      }),
      

    );
  }

  getPdf(fileId: number): Observable<Blob> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/pdf' });
    const params = new HttpParams().set('fileId', fileId.toString());
   /* This is param we need to convert in string because we must send value as string convention */
    return this.http.get<Blob>(`${this.apiUrl}/pdf/${fileId}`, { headers, responseType: 'blob' as 'json', params });
  }

}
