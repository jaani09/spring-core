package com.rays.ioc;

public class Order2 {
	
	private Payment payment;
	private Inventory inventory;
	
	
	public Order2(Payment payment , Inventory inventory) {
		this.payment = payment;
		this.inventory = inventory;
	}
	public void bookTickit(int item) {
		
		int price =10;
		
		double totalAmount = item *price;
		
		double updatedBalance = payment.makePayment(totalAmount);
		
		int updatedStock = inventory.sold(item);
		
		System.out.println("Tickets are BOOKed");
		System.out.println("Total Amount Paid:" +totalAmount);
		System.out.println("Remaining Balance: " +updatedBalance );
		System.out.println("Update Stock: " +updatedStock );
		
	}

}
