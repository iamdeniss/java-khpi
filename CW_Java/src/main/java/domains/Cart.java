package main.java.domains;

import java.util.LinkedList;
import java.util.List;

public class Cart {
	private List<Good>  items = new LinkedList<Good>();

    public void add(Good item) {
        items.add(item);
    }

    public List<Good> getList(){
        return items;
    }

    public int getCount() {
        return items.size();
    }

    public void remove(int i) {
        items.remove(i);
    }
    
    public int getTotal() {
    	int total = 0;
    	for(Good g : items)
    		total += g.getPrice();
    	return total;
    }
}
