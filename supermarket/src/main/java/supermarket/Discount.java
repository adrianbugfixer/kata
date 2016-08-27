package supermarket;

import java.util.concurrent.atomic.AtomicLong;

public class Discount {
    static final AtomicLong NEXT_ID = new AtomicLong(0);
    protected final long id = NEXT_ID.getAndIncrement();
	protected double discount = 0;
	protected DiscountType discountType = DiscountType.SIMPLE;
	protected ProductType prodcutType = ProductType.PRODUCT;
	protected DiscountStatus discountStatus = DiscountStatus.NEW;

	
	protected Discount() {
	}
	
	public Discount(double discount) {
		this.setDiscount(discount);
		System.out.println("Created discount " + this.id +" of type " + this.discountType );
	}
	
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	/**
	 * @return the discountType
	 */
	public DiscountType getDiscountType() {
		return discountType;
	}

	/**
	 * @param discountType the discountType to set
	 */
	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}

	public void setProductType(ProductType productType) {
		this.prodcutType = productType;
	}

	public DiscountStatus getDiscountStatus() {
		return this.discountStatus;
	}

	public void setDiscountStatus(DiscountStatus discountStatus) {
		this.discountStatus = discountStatus;
	}

	public long getId() {
		return id;
	}

	public ProductType getProdcutType() {
		return prodcutType;
	}

	public void setProdcutType(ProductType prodcutType) {
		this.prodcutType = prodcutType;
	}
}
