public class Transaction {
	private String bitsId;
	private int itemId;
	private int quantity;
	private String paymentMode;
	private int price;
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
		try {
			Inventory inv = new Inventory();
			inv.updateCount(getItemId(), getQuantity());

			price = inv.getPrice(getItemId());
			total = (price * getQuantity());

			MedicalStoreOwner owner = new MedicalStoreOwner();
			owner.updateRevenue(total, getPaymentMode());
			if(getPaymentMode().equals("Cash")) {
				System.out.println("Purchase done successfully");
			}
			else {
				System.out.println("Purchase done successfully and the amount is added to your fees");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
