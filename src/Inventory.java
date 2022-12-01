import java.util.*;

public class Inventory {
    private Map<Medicine, Integer> inventory;

    // make constructor read from file

    public int getStock(Medicine m) { return inventory.get(m); }
    public void updateCount(Medicine m, int count) { inventory.put(m, count); save(); }

    public void save() {
        // save current inventory to file
    }

}
