package supermarket;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class ProductTests {

	@Test
	public void handleBasicPricing() {
		Product p1 = new Product(30.00);
		assertEquals(p1.getPrice(), 30.00, 0);
	}

	@Test
	public void handlePriceWithDiscount_simpleDiscount() {
		Product p1 = new Product(60.00);
		Discount d1 = new Discount(30.00);
		p1.setDiscount(d1);
		double price = p1.getPriceWithDiscount();
		assertEquals(30.00, price, 0);
		assertEquals(DiscountStatus.COMPLETED, d1.getDiscountStatus());
		assertEquals(DiscountType.SIMPLE, p1.getDiscountType());
	}
	
	@Test
	public void handlePriceWithDiscount_bulkDiscount() {
		Product p1 = new Product(60.00);
		Discount d1 = new BulkDiscount(3, 50.00);
		p1.setDiscount(d1);
		assertEquals("", 60.00, p1.getPriceWithDiscount(), 0);
		assertEquals(DiscountType.BULK, p1.getDiscountType());
		assertEquals(DiscountStatus.COMPLETED, d1.getDiscountStatus());
	}
	
	@Test
	public void simpleBasketTest() {
		Basket basket = new Basket();
		
		for(int i=0; i<3; i++) {
			Product p = new Product(50.00);
			basket.add(p);
		}
		
		assertEquals(3, basket.numberOfProducts(),0);
		assertEquals(3, basket.numberOfProducts(ProductType.PRODUCT),0);
	}
	
	@Test
	public void simplePricingTest() {
		Basket basket = new Basket();
		ProductManager productManager = new ProductManager();
		DiscountManager discountManager = new DiscountManager();
		discountManager.createDiscount(DiscountType.BULK, 10.0, 4);
		for(int i=0; i<3; i++) {
			basket.add(productManager.createProduct(10.00));
		}
		Pricing pricing = new Pricing(basket, productManager, discountManager);
		assertEquals(30.00, pricing.getTotalPrice(),0);
	}
	
	@Test
	public void pricingTest_withBulkDiscount() {
		Basket basket = new Basket();
		ProductManager productManager = new ProductManager();
		DiscountManager discountManager = new DiscountManager();
		discountManager.createDiscount(DiscountType.BULK, 10.0, 3);
		
		for(int i=0; i<3; i++) {
			basket.add(productManager.createProduct(10.0));
		}
		
		Pricing pricing = new Pricing(basket, productManager, discountManager);
		assertEquals(10.00, pricing.getTotalPrice(),0);
	}
	
	@Test
	public void simpleDiscountManagerTest() {
		DiscountManager discountManager = new DiscountManager();
		discountManager.createDiscount(DiscountType.SIMPLE, 10.0);
		discountManager.createDiscount(DiscountType.SIMPLE, 20.0);
		discountManager.createDiscount(DiscountType.SIMPLE, 30.0);
		assertEquals(3, discountManager.getRegistredDiscounts(DiscountType.SIMPLE).size(),0);
		discountManager.createDiscount(DiscountType.BULK, 10.00, 3);
		discountManager.createDiscount(DiscountType.BULK, 10.00, 3);
		discountManager.createDiscount(DiscountType.BULK, 10.00, 3);
		discountManager.createDiscount(DiscountType.BULK, 10.00, 3);
		assertEquals(4, discountManager.getRegistredDiscounts(DiscountType.BULK).size(),0);
	}
	
	@Test
	public void simpleProductManagerTest() {
		ProductManager productManager = new ProductManager();
		productManager.createProduct(10.0);
		assertEquals(1, productManager.getRegistredProducts().size(),0);
	}
	
	@Test
	public void productWithWeightTest() {
		ProductWithWeight pww = new ProductWithWeight(10.00, 5.00);
		assertEquals(pww.getProductType(), ProductType.WEIGHTED);
		assertEquals(pww.getWeight(), 5.00, 0);
	}
	
	@Test
	public void pricingTest_withWeightedProduct() {
		Basket basket = new Basket();
		ProductManager productManager = new ProductManager();
		DiscountManager discountManager = new DiscountManager();
		
		for(int i=0; i<3; i++) {
			ProductWithWeight pww = new ProductWithWeight(1.99, 4.0);
			basket.add(productManager.createProduct(pww));
		}
		
		Pricing pricing = new Pricing(basket, productManager, discountManager);
		assertEquals(23.88, pricing.getTotalPrice(),0);
	}
	
	@Test
	public void gratisDiscountTest() {
		GratisDiscount gd = new GratisDiscount(
				ProductType.PRODUCT, 2, 1.0);
		assertEquals(gd.getDiscountType(), DiscountType.GRATIS);
		assertEquals(gd.getProductType(), ProductType.PRODUCT);
		assertEquals(gd.getNumberOfProducts(), 2, 0);
		assertEquals(gd.getPriceReturn(), 1.0, 0);
	}
	
	@Test
	public void pricingTest_withGratisProduct() {
		Basket basket = new Basket();
		ProductManager productManager = new ProductManager();
		DiscountManager discountManager = new DiscountManager();
		GratisDiscount gd = new GratisDiscount(ProductType.PRODUCT, 
				2, 1.0);
		discountManager.createDiscount(gd);
		
		for(int i=0; i<6; i++) {
			basket.add(productManager.createProduct(10.0));
		}
		
		Pricing pricing = new Pricing(basket, productManager, discountManager);
		assertEquals(30.0, pricing.getTotalPrice(),0);
	}
	
	@Test
	public void addProductTest() {
		ProductDao pD = new ProductDaoImpl();
		Product p = new Product(20.0);
		pD.add(p);
		
		assertNotNull(pD.get(0));
	}
	
	@Test
	public void addProductTest_addNull() {
		ProductDao pD = new ProductDaoImpl();
		assertEquals(false, pD.add(null));
	}
	
	@Test
	public void removeProductTest() {
		ProductDao pd = new ProductDaoImpl();
		
	}
}
