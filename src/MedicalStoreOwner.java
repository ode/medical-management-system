import java.util.Scanner;

public class MedicalStoreOwner {
    private int revenue;
    private int dueAmount;
    MedicalStoreOwner() {
        System.out.println("Hi Medical Store Owner! Please select from the given options");
        System.out.println("1 - Display the total revenue");
        System.out.println("2 - Display the due amount(received at end of semester)");
        System.out.println("3 - Display the inventory");

        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        if(choice == 1) {
            showTotalRevenue();
        }
        else if(choice == 2) {
            showDueAmount();
        }
        else if(choice == 3) {
            try {
                Inventory inv = new Inventory();
                inv.showInventory();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Wrong input");
        }
    }

    public int getRevenue() {
        return revenue;
    }
    public int getDueAmount() {
        return dueAmount;
    }
    public void updateRevenue(int purchase, String mode) {
        revenue = revenue + purchase;
        if(mode.equals("Later")) {
            dueAmount = dueAmount + purchase;
        }
    }
    private void showTotalRevenue() {
        System.out.println("Total revenue = " + getRevenue());
    }
    private void showDueAmount() {
        System.out.println("Total due amount = " + getDueAmount());
    }
}
