public class Medicine {
    private String name;
    private int id;
    private double unitPrice;

    Medicine(String n, int i, double pr) {
        name = n;
        id = i;
        unitPrice = pr;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public double getPrice() { return unitPrice; }

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
