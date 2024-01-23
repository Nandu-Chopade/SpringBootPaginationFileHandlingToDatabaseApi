// app-routing.module.ts

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { FileUploadComponent } from './File/file-upload.component';
import { ViewFileComponent } from './view-file/view-file.component';


const routes: Routes = [
  { path: '', component: AppComponent },
  { path: 'upload', component: FileUploadComponent },
  { path: 'pdf/:fileId', component: ViewFileComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
