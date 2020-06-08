package model;

public class Product {
	private static int count = 1;
	private int idProduct;
	private String nameProduct;
	private String category;
	private int price;
	private int amount;
	private String description;

	public Product() {
	}

	public Product(int idProduct, String nameProduct, String category, int price, int amount, String description) {
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.category = category;
		this.price = price;
		this.amount = amount;
		this.description = description;
	}
	
	

	public Product(String nameProduct, String category, int price, int amount, String description) {
		this.nameProduct = nameProduct;
		this.category = category;
		this.price = price;
		this.amount = amount;
		this.description = description;
		this.idProduct = count;
		count++;
	}

	public void setIdProduct(int id) {
		this.idProduct = id;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return this.idProduct + " " + this.nameProduct;
	}

}
