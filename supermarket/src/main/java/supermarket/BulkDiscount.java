package supermarket;

public class BulkDiscount extends Discount {

	private double priceInBulk;
	private int numberOfProducts;
	
	public BulkDiscount(double discount) {
		super(discount);
	}
	
	public BulkDiscount(int numberOfProducts, double priceInBulk) {
		this.setNumberOfProducts(numberOfProducts);
		this.setPriceInBulk(priceInBulk);
		this.discountType = DiscountType.BULK;
		System.out.println("Created discount " + this.id +" of type " + this.discountType );	
	}

	public double getPriceInBulk() {
		return priceInBulk;
	}

	public void setPriceInBulk(double priceInBulk) {
		this.priceInBulk = priceInBulk;
	}

	public int getNumberOfProducts() {
		return numberOfProducts;
	}

	public void setNumberOfProducts(int numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}
}
