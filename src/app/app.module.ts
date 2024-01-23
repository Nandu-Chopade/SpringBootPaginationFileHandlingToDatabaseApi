import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ChildComponent } from './child/child.component';
import { FileUploadComponent } from '.././app/File/file-upload.component';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './router.module';
import { NgxExtendedPdfViewerModule } from 'ngx-extended-pdf-viewer';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ChildComponent,
    FileUploadComponent,

  ],
  imports: [
   BrowserModule,
   HttpClientModule,
   AppRoutingModule, 
   NgxExtendedPdfViewerModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
