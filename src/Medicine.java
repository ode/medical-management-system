public class Medicine {
    private String name;
    private int id;
    private int unitPrice;

    Medicine(String n, int i, int pr) {
        name = n;
        id = i;
        unitPrice = pr;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public int getPrice() { return unitPrice; }

    public void updateCount(int count) {
        try {
            Inventory inv = new Inventory();
            inv.updateCount(this, count);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
