import java.util.*;
import java.io.*;

public class Inventory {
    private Map<Medicine, Integer> inventory;

    Inventory() throws FileNotFoundException{
        inventory = new HashMap<Medicine, Integer>();
        Scanner sc = new Scanner(new File("inventory.txt"));
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(",");
            int id = Integer.parseInt(s[0]);
            String name = s[1];
            int price = Integer.parseInt(s[2]);
            int quantity = Integer.parseInt(s[3]);
            Medicine medicine = new Medicine(name, id, price);
            inventory.put(medicine, quantity);
        }
    }

    public int getStock(Medicine m) { return inventory.get(m); }
    public void updateCount(Medicine m, int count) { inventory.put(m, count); save(); }
    public void showInventory() throws FileNotFoundException{
        Scanner sc = new Scanner(new File("inventory.txt"));
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }

    public void save() {
        
    }

}
