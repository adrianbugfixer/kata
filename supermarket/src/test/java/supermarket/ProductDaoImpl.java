package supermarket;

import java.util.ArrayList;

public class ProductDaoImpl implements ProductDao {

	ArrayList<Product> products;
	
	public ProductDaoImpl() {
		products = new ArrayList<>();
	}
	
	@Override
	public ArrayList<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Product p) {
		return (p!=null) ? products.add(p) : false; 
	}

	@Override
	public Product get(int idx) {
		return products.get(idx);
	}

}
