package supermarket;

import java.util.HashMap;

public class ProductManager {

	private HashMap<Long, Product> registredProducts;

	public ProductManager(){
		this.registredProducts = new HashMap<>();
	}
	
	public Product createProduct(ProductType productType, double price) {
		Product p;
		switch(productType) {
		case PRODUCT:
			p = new Product(price);
			registredProducts.put(p.getId(), p);
			break;
		default:
			p = new Product(0);
			break;
		}
		return p;
	}

	public Product createProduct(double d) {
		return createProduct(ProductType.PRODUCT, d);
	}

	public Product createProduct(Product p) {
		if(p!=null){
			registredProducts.put(p.getId(), p);
		}
		return p;
	}
	
	public HashMap<Long, Product> getRegistredProducts() {
		return registredProducts;
	}

	public void setRegistredProducts(HashMap<Long, Product> registredProducts) {
		this.registredProducts = registredProducts;
	}

	public double getProductPrice(ProductType prodcutType) {
		for(Product p : registredProducts.values()){
			if(p.getProductType() == prodcutType) {
				return p.getPrice();
			}
		}
		return 0.0;
	}
}
