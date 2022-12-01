import java.util.*;

public class Transaction {
	private int bits_ID;
	private int item_ID;
	private int quantity;
	private String paymentMode;
	private double subTotalPrice;
	
	Transaction(String s){
		String[] temp = s.split(",");
		this.bits_ID = Integer.parseInt(temp[0]);
		this.item_ID = Integer.parseInt(temp[1]);
		this.quantity = Integer.parseInt(temp[2]);
		this.paymentMode = temp[3];
	}
	
	public void getTransactionSummary() {
		System.out.println("BITS_ID "+bits_ID);
		System.out.println("ITEM_ID "+item_ID);
		System.out.println("Quantity "+quantity);
		System.out.println("Payment_Mode "+paymentMode);
		System.out.println("Total Price "+subTotalPrice);
		System.out.println();
	}
	
	
	public void addRevenue(double revenue) {
		GlobalVariables.revenue += revenue;
	}
	
	public void addAmountOwned(double amountOwned) {
		GlobalVariables.amountOwned += amountOwned;
	}
}
