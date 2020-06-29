package com.inventorysystem.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
//	@ManyToOne
//	@JoinColumn(name="category_id",nullable=false)
//	private ProductCategory productcategory;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private ProductCategory productcategory;
	
	@Column(name="name")
	private String name;
	
	@Column(name="category")
	private String category;
	
	@Column(name="cost_price")
	private BigDecimal costPrice;
	
	@Column(name="selling_price")
	private BigDecimal sellingPrice;
	
	@Column(name="image_url")
	private String imageurl;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="quantity")
	private long quantity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((costPrice == null) ? 0 : costPrice.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((imageurl == null) ? 0 : imageurl.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (quantity ^ (quantity >>> 32));
		result = prime * result + ((sellingPrice == null) ? 0 : sellingPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (active != other.active)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (costPrice == null) {
			if (other.costPrice != null)
				return false;
		} else if (!costPrice.equals(other.costPrice))
			return false;
		if (id != other.id)
			return false;
		if (imageurl == null) {
			if (other.imageurl != null)
				return false;
		} else if (!imageurl.equals(other.imageurl))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quantity != other.quantity)
			return false;
		if (sellingPrice == null) {
			if (other.sellingPrice != null)
				return false;
		} else if (!sellingPrice.equals(other.sellingPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", costPrice=" + costPrice
				+ ", sellingPrice=" + sellingPrice + ", imageurl=" + imageurl + ", active=" + active + ", quantity="
				+ quantity + "]";
	}

}
