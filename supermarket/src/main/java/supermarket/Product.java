package supermarket;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class Product implements Discountable{
	static final AtomicLong NEXT_ID = new AtomicLong(0);
	protected final long id = NEXT_ID.getAndIncrement();
	protected double price = 0.0;
	protected Discount discount;
	protected ProductType productType = ProductType.PRODUCT;
	
	public Product(){
		
	}
	
	public Product(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDiscount(Discount d1) {
		this.discount = d1;
		d1.setProductType(this.productType);
	}

	public double getPriceWithDiscount() {
		discount.setDiscountStatus(DiscountStatus.COMPLETED);
		return price - discount.getDiscount();
	}
	
	public DiscountType getDiscountType() {
		return discount.getDiscountType();
	}

	public void setDiscountType(DiscountType discountType) {
		this.discount.setDiscountType(discountType);
	}

	public ProductType getProductType() {
		return this.productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	public Discount getDiscount() {
		return this.discount;
	}

	public long getId() {
		return this.id;
	}
}
