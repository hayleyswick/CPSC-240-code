package Application;

import java.io.Serializable;
import java.util.Iterator;

public class SalesVanWarehouse extends Warehouse implements Serializable {
	
	private MainWareHouse mainwh;
	private String name;
	
	public SalesVanWarehouse(String n) {
		mainwh.addWarehouse(this);
		this.name = n;
	}

	public String getName() {
		return name;
	}
	
	
	public void sellPart(long id, long x) {
		Iterator<Inventory> it = dbIterator();
		while (it.hasNext()) {
			Inventory inventory = it.next();
			if (inventory.getID() == id) {
				long quantity = inventory.getQuantity();
				updateInventory(inventory, quantity-x, true);
			}
				
		}
		
	}

}
