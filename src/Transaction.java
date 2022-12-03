import java.util.*;

public class Transaction {
	private String bitsId;
	private int itemId;
	private int quantity;
	private String paymentMode;
	private int total;
	
	Transaction(String bitsId, int itemId, int quantity, String mode) {
		this.bitsId = bitsId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.paymentMode = mode;
		purchase();
	}
	public String getBitsId() {
		return bitsId;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public int getItemId() {
		return itemId;
	}
	public int getQuantity() {
		return quantity;
	}

	public void purchase() {
		// take price from Inventory
		// call revenue from MedicalStoreOwner class
		// total = ;
	}
}
