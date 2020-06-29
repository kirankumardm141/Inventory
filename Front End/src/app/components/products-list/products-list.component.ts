import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';
import { Router } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';
import { CartItem } from 'src/app/common/cart-item';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css']
})
export class ProductsListComponent implements OnInit {

  products : Product[];
  currentCategoryId: number;

  constructor(private productService: ProductService,
              private cartService: CartService,
              private router: Router) { }

  ngOnInit() {
    this.listProducts();
  }

  listProducts(){

    this.productService.getProductsList().subscribe(
      data => {
        this.products = data;
        //console.log(data);
      }
    )
  }

  updateProduct(id)
  {
    console.log(`${id}`);
    this.router.navigate(['products', id]);
  }

  addToCart(theProduct:Product){
    console.log(theProduct.name,theProduct.sellingPrice);
    const theCartItem = new CartItem(theProduct);
    this.cartService.addToCart(theCartItem);

  }

}
