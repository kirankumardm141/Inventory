import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/common/product';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  id: number;
  product = new Product();

  constructor(private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.id = this.route.snapshot.params.id;
    if (this.id != -1) {
      this.productService.retrieveProduct(this.id).subscribe(
        data => {
          this.product = data;
          console.log(this.product);
        }
      );
    }
  }

  saveProduct() {
    console.log("Inside Save product-----1")
    if (this.id === -1) {
      console.log("Inside Save product")
      console.log(this.product)
      this.productService.createProduct(this.product).subscribe(
        data => {
          // console.log(data)
          this.router.navigate(['products']);
        }
      );

    } else {
      console.log("Inside Save product");
      console.log(this.product);
      this.productService.updateProduct(this.id, this.product).subscribe(
        data => {
          this.router.navigate(['products']);
        }
      );
    }
  }

  cancel() {
    this.router.navigate(['products']);
  }


}
