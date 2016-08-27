package supermarket;

public class GratisDiscount extends Discount {

	private ProductType productType = ProductType.PRODUCT;
	private int numberOfProducts;
	private double priceReturn;
	
	public GratisDiscount(ProductType productType, 
			int numberOfProducts, double priceReturn) {
		this.numberOfProducts = numberOfProducts;
		this.priceReturn = priceReturn;
		this.discountType = DiscountType.GRATIS;
	}

	public ProductType getProductType() {
		return this.productType ;
	}

	public int getNumberOfProducts() {
		return this.numberOfProducts;
	}

	public double getPriceReturn() {
		return priceReturn;
	}

	public void setPriceReturn(double priceReturn) {
		this.priceReturn = priceReturn;
	}
}
