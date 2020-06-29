import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Inventory-System';

  constructor(private router: Router) { }

  addProduct(){
    this.router.navigate(['products',-1]);
  }

}
