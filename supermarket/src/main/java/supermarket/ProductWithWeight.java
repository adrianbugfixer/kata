package supermarket;

public class ProductWithWeight extends Product{

	private double weight = 0.0;
	
	public ProductWithWeight(double price) {
		super(price);
	}

	public ProductWithWeight(double price, double weight){
		this.price = price;
		this.weight = weight;
		this.productType = ProductType.WEIGHTED;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
