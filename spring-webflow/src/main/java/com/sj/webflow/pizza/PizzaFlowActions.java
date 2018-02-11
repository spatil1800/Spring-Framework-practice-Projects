package com.sj.webflow.pizza;

import java.io.Serializable;

public class PizzaFlowActions implements Serializable {

	private static final long serialVersionUID = 1L;

	public Customer validateCustomer(long phoneNo) throws Exception{
		if(phoneNo==1212) {
		      Customer customer = new Customer();
		      customer.setName("Suraj Patil");
		      customer.setAddress("Karve Road");
		      customer.setCity("Pune");
		      customer.setState("MH");
		      customer.setPincode(411041);
		      customer.setPhoneNo(phoneNo);
		      return customer;
		    } else {
		      throw new Exception();
		    }
	}
	
	public static boolean checkDelivery(int pincode) {
		 return "411001".equals(pincode);
	}
	
	public static void addCustomer(Customer customer) {
		System.out.println("Added to Customer");
	}
	
	public Payment verifyPayment(PaymentDetails paymentDetails) {
	     Payment payment = null;
	     if(paymentDetails.getPaymentType() == PaymentType.CREDIT_CARD) {
	       payment = new CreditCardPayment();
	     } else {
	       payment = new CashOrCheckPayment();
	     }
	     
	     return payment;
	   }
	   
	   public void saveOrder(Order order) {
	      System.out.println("TODO: Flesh out the saveOrder() method.");
	   }
}
