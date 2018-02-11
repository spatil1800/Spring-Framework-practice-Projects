package com.sj.webflow.pizza;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("serial")
public class PricingEngine implements Serializable {
 
  
  private static Map<PizzaSize, Float> SIZE_PRICES;
  static {
    SIZE_PRICES = new HashMap<PizzaSize, Float>();
    SIZE_PRICES.put(PizzaSize.SMALL, 6.99f);
    SIZE_PRICES.put(PizzaSize.MEDIUM, 7.99f);
    SIZE_PRICES.put(PizzaSize.LARGE, 8.99f);
    SIZE_PRICES.put(PizzaSize.GINORMOUS, 9.99f);
  }
  private static float PRICE_PER_TOPPING = 0.20f;
  
  public PricingEngine() {}
  
  public float calculateOrderTotal(Order order) {    
    float total = 0.0f;
    
    for (Pizza pizza : order.getPizzas()) {
      float pizzaPrice = SIZE_PRICES.get(pizza.getSize());
      if(pizza.getToppings().size() > 2) {
        pizzaPrice += (pizza.getToppings().size() * 
            PRICE_PER_TOPPING);
      }
      total += pizzaPrice;
    }
    
    return total;
  }
}