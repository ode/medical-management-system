import java.util.*;
import java.io.*;

public class Inventory {
    private Map<Medicine, Integer> inventory;
    private Map<Integer, Medicine> idMap;
    private static Inventory obj = null;

    private Inventory() throws FileNotFoundException{
        inventory = new HashMap<Medicine, Integer>();
        idMap = new HashMap<Integer, Medicine>();

        Scanner sc;
        try { sc = new Scanner(new File("inventory.txt")); }
        catch (Exception e) {return;}
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(",");
            int id = Integer.parseInt(s[0]);
            String name = s[1];
            int price = Integer.parseInt(s[2]);
            int quantity = Integer.parseInt(s[3]);
            Medicine medicine = new Medicine(name, id, price);
            inventory.put(medicine, quantity);
            idMap.put(id, medicine);
        }
    }

    public int getStock(Medicine m) { return inventory.get(m); }
    public void updateCount(int medicineId, int count) { 
        Medicine medicine = idMap.get(medicineId);
        int currCount = inventory.get(medicine);
        inventory.put(medicine, currCount - count);
        save(); 
    }

    public static void showInventory() throws FileNotFoundException{
        Scanner sc = new Scanner(new File("inventory.txt"));
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }

    public int getPrice(int id) {
        Medicine medicine = idMap.get(id);
        return medicine.getPrice();
    }

    public void save() {
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("inventory.txt"));
            for (Map.Entry<Medicine, Integer> entry : inventory.entrySet()) {
                Medicine medicine = entry.getKey();
                fw.write(medicine.getId() + "," + medicine.getName() + "," + medicine.getPrice() + "," + entry.getValue() + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("error saving:" + e);
        }
    }

    public static Inventory getInstance() throws FileNotFoundException {
        if (obj == null)
            obj = new Inventory();
        return obj;
    }

}
