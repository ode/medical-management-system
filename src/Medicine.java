public class Medicine {
    private String name;
    private int batchNo;
    private double unitPrice;

    Medicine(String n, int bno, double pr) {
        name = n;
        batchNo = bno;
        unitPrice = pr;
    }

    public String getName() { return name; }
    public int getBatchNo() { return batchNo; }
    public double getPrice() { return unitPrice; }

    public void updateCount(int count) {
        Inventory inv = new Inventory();
        inv.updateCount(this, count);
    }
    
}
