import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../common/product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/api/products';

  constructor(private httpClient: HttpClient) { }

  getProductsList(): Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.baseUrl);
  }
  retrieveProduct(id){
    return this.httpClient.get<Product>(`http://localhost:8080/api/products/${id}`);
  }

  updateProduct(id,product){
    //console.log(id,employees);
    return this.httpClient.put(`http://localhost:8080/api/products/${id}`,product);
  }

  createProduct(product){
    //console.log(id,employees);
    return this.httpClient.put(`http://localhost:8080/api/products`,product);
  }

}

