package com.rays.ioc;

public class Order1 {
	
	private Payment payment;
	private Inventory inventory;
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public void bookTicket(int item) {
		
		int price = 10;
		double totalAmount = item *price;
		
		double updatedBalance = payment.makePayment(totalAmount);
		
		int updatedStock = inventory.sold(item);
		
		System.out.println("Tickets are Booked");
		System.out.println("Total Amount Paid: " + totalAmount);
		System.out.println("Remaining Balance: " + updatedBalance);
		System.out.println("Updated Stock: " + updatedStock);

		
	}

	
}
