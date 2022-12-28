import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { ProductregisterComponent } from './productregister/productregister.component';
import { GetproductComponent } from './getproduct/getproduct.component';
import { ProductlistComponent } from './productlist/productlist.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ProductregisterComponent,
    GetproductComponent,
    ProductlistComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
