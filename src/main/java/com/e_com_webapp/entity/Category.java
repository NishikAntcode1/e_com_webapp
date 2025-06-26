package com.e_com_webapp.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int categorId;
	@Column(name = "cname", length = 100)
	private String categoryName;
	@Column(name = "cdesc", length = 500)
	private String categoryDesc;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Product> products = new HashSet<>();

	public int getCategorId() {
		return categorId;
	}

	public void setCategorId(int categorId) {
		this.categorId = categorId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Category(int categorId, String categoryName, String categoryDesc, Set<Product> products) {
		super();
		this.categorId = categorId;
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
		this.products = products;
	}

	public Category() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Category [categorId=" + categorId + ", categoryName=" + categoryName + ", categoryDesc=" + categoryDesc
				+ ", products=" + products + "]";
	}
}