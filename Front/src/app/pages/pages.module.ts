import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainpageComponent } from './mainpage/mainpage.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser'
import { RouterModule } from '@angular/router';
import { BaseDeDatosComponent } from './base-de-datos/base-de-datos.component';
import { CargaDeDatosComponent } from './carga-de-datos/carga-de-datos.component';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';

@NgModule({
  declarations: [
    MainpageComponent,
    BaseDeDatosComponent,
    CargaDeDatosComponent
  ],
  exports: [
    MainpageComponent,
    ReactiveFormsModule,
    FormsModule,
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    [SweetAlert2Module],
  ],
  providers: [],
})
export class PagesModule { }
