import { Product } from './product';

export class CartItem {

    id:number;
    name:string;
    imageUrl :string;
    sellingPrice : number;
    quantity :number;

    constructor (product:Product)
    {
        this.id = product.id;
        this.name= product.name;
        this.imageUrl= product.imageurl;
        this.sellingPrice = product.sellingPrice;

        this.quantity=1;
    }
}
