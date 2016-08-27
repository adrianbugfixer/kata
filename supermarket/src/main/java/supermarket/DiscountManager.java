package supermarket;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class DiscountManager {

	private HashMap<Long, Discount> registredDiscounts;
	
	public DiscountManager() {
		registredDiscounts = new HashMap<>();
	}


	public void createDiscount(DiscountType discountType, double discount) {
		createDiscount(discountType, discount, 0);
	}
	
	public void createDiscount(DiscountType discountType, 
			double discount, 
			int productsNumberCondition) {
		
		switch(discountType){
		case SIMPLE:
			Discount d = new Discount(discount);
			registredDiscounts.put(d.getId(), d);
			break;
		case BULK:
			BulkDiscount bd = new BulkDiscount(productsNumberCondition, discount);
			registredDiscounts.put(bd.getId(), bd);
			break;
		default:
			break;
		}
		
	}

	public HashMap<Long,Discount> getRegistredDiscounts() {
		return registredDiscounts;
	}

	public void setRegistredDiscounts(HashMap<Long,Discount> registredDiscounts) {
		this.registredDiscounts = registredDiscounts;
	}

	public HashSet<Discount> getRegistredDiscounts(
			DiscountType discountType) {
		HashSet<Discount> discounts = new HashSet<>();
		for(Discount d : registredDiscounts.values()) {
			if(d.getDiscountType() == discountType){
				discounts.add(d);
			}
		}
		return discounts;
	}

	public Discount getDiscount(int id) {
		return registredDiscounts.get(id);
	}


	public void createDiscount(Discount d) {
		this.registredDiscounts.put(d.getId(), d);
	}

}
