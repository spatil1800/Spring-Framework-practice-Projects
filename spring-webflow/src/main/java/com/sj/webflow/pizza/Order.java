package com.sj.webflow.pizza;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
//  // injected
	Customer customer;
	private List<Pizza> pizzas;
	Payment payment;
	private PricingEngine pricingEngine=new PricingEngine();
	 public Order() {
	      pizzas = new ArrayList<Pizza>();
	      customer = new Customer();
	   }
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public void addPizza(Pizza pizza) {
		if(pizza.equals(null)) {
			System.out.println(pizza);
		}else {
			System.out.println(pizza);
		pizzas.add(pizza);
		}
	}

	public Payment getPayment() {
		return payment;
	}

	public float getTotal() {
		return pricingEngine.calculateOrderTotal(this);
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Order [customer=" + customer + ", pizza=" + pizzas + ", payment=" + payment + "]";
	}

	public Order(Customer customer, List<Pizza> pizza, Payment payment) {
		super();
		this.customer = customer;
		this.pizzas = pizza;
		this.payment = payment;
	}


	public void save() {

	}
}
