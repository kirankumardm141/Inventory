import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {  FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ProductsListComponent } from './components/products-list/products-list.component';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';
import { UpdateProductComponent } from './components/update-product/update-product.component';
import { CartStatusComponent } from './components/cart-status/cart-status.component';


const routes: Routes = [
  { path: '',component:ProductsListComponent},
  { path: 'products',component:ProductsListComponent},
  { path: 'products/:id',component:UpdateProductComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ProductsListComponent,
    UpdateProductComponent,
    CartStatusComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
