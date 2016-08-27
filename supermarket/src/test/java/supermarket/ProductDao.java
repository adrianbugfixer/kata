package supermarket;

import java.util.ArrayList;

public interface ProductDao {
	public ArrayList<Product> getAll();
	public boolean add(Product p);
	public Product get(int idx);
}
