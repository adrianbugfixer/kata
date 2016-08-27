package supermarket;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Basket extends HashSet<Product>{
	
	public Basket() {

	}

//	public void add(Product p) {
//		HashSet<Product> phs = this.get(p.getProductType());
//		if(phs == null) {
//			this.put(p.getProductType(), new HashSet<Product>(Arrays.asList(p)));
//		} else {
//			phs.add(p);	
//		}
//	}

	public int numberOfProducts() {
		return this.size();
	}
	
	public int numberOfProducts(ProductType productType) {
		int n = 0;
		for(Product p : this) {
			if(p.getProductType() == productType){
				n++;
			}
		}
		return n;
	}
}
