import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MedicalStoreOwner extends Interaction{
    private int revenue;
    private int dueAmount;
    
    void printInstructions() {
        System.out.println("Hi Medical Store Owner! Please select from the given options\n"+
        "1 - Display the total revenue\n"+
        "2 - Display the due amount(received at end of semester)\n"+
        "3 - Display the inventory\n");
    }
    
    MedicalStoreOwner() {
        try
        {
            FileInputStream fis = new FileInputStream("revenue.txt");
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine())
            {
                String[] s = sc.nextLine().split(",");
                if(s[0].equals("Revenue")) {
                    this.revenue = Integer.parseInt(s[1]);
                }
                else {
                    this.dueAmount = Integer.parseInt(s[1]);
                }
            }
            sc.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public int getRevenue() {
        return revenue;
    }
    public int getDueAmount() {
        return dueAmount;
    }
    
    void options(int choice) {
        if(choice == 1) {
            showTotalRevenue();
        }
        else if(choice == 2) {
            showDueAmount();
        }
        else if(choice == 3) {
            try {
                Inventory.showInventory();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Wrong input");
        }
    }

    public void updateRevenue(int purchase, String mode) {
        revenue = revenue + purchase;
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("revenue.txt", true));
            out.write("Revenue," + getRevenue() + "\n");
            out.close();
        }
        catch (IOException e) {
            System.out.println("Revenue could not be updated" + e);
        }
        if(mode.equals("Later")) {
            dueAmount = dueAmount + purchase;
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter("revenue.txt", true));
                out.write("DueAmount," + getDueAmount() + "\n");
                out.close();
            }
            catch (IOException e) {
                System.out.println("Due Amount could not be updated" + e);
            }
        }
    }
    private void showTotalRevenue() {
        System.out.println("Total revenue = " + getRevenue());
    }
    private void showDueAmount() {
        System.out.println("Total due amount = " + getDueAmount());
    }
}
