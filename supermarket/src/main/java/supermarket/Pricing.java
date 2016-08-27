package supermarket;

import java.util.HashSet;

public class Pricing {

	private Basket basket;
	private ProductManager productManager;
	private DiscountManager discountManager;
	
	public Pricing(Basket basket, ProductManager productManager, 
			DiscountManager discountManager) {
		this.basket = basket;
		this.productManager = productManager;
		this.discountManager = discountManager;
	}

	public double getTotalPrice() {
		double totalPrice = getPriceWithoutDiscounts();
		double productPrice = 0.0;
		for(Discount d : discountManager.getRegistredDiscounts().values()) {
			switch(d.getDiscountType()){
			case BULK:
				BulkDiscount bd = (BulkDiscount) d;
				int productsToDiscount = 0;
				productPrice = productManager.getProductPrice(bd.getProdcutType());
				for(Product p : basket) {
					if(p.getProductType() == bd.getProdcutType()) {
						productsToDiscount++;
					}
				}
				double discount = (double)productsToDiscount/(double)bd.getNumberOfProducts();
				discount = Math.floor(discount);
				totalPrice -= productPrice*bd.getNumberOfProducts()*discount;
				totalPrice += discount*bd.getPriceInBulk();
				break;
			case SIMPLE:
				break;
			case GRATIS:
				GratisDiscount gd = (GratisDiscount) d;
				int hasProducts = 0;
				productPrice = productManager.getProductPrice(d.getProdcutType());
				for(Product p : basket) {
					if(p.getProductType() == gd.getProdcutType()) {
						hasProducts++;
					}
				}
				//number of products that fullifed discount condition
				double discountCompleted = (double)hasProducts/(double)gd.getNumberOfProducts();
				discountCompleted = Math.floor(discountCompleted);
				totalPrice -= discountCompleted * productPrice * gd.getPriceReturn();
				break;
			default:
				break;
			}
		}
		return totalPrice;
	}

	private double getPriceWithoutDiscounts() {
		double totalPrice = 0.0;
		for(Product p : basket) {
			switch(p.getProductType()){
			case WEIGHTED:
				double weight = ((ProductWithWeight)p).getWeight();
				totalPrice += p.getPrice()*weight;
				break;
			default:
				totalPrice += p.getPrice();
			}
		}
		return totalPrice;
	}
	
}
