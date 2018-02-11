package com.sj.webflow.pizza;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public enum Topping implements Serializable {
	  PEPPERONI, 
	  SAUSAGE, 
	  HAMBURGER,
	  MUSHROOM, 
	  CANADIAN_BACON, 
	  PINEAPPLE,
	  GREEN_PEPPER,
	  JALAPENO,
	  TOMATO,
	  ONION,
	  EXTRA_CHEESE;
	  
	  public static List<Topping> asList() {
	    Topping[] all = Topping.values();
	    return Arrays.asList(all);
	  }
	  
	
	}