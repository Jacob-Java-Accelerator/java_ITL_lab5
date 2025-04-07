package com.roczyno;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

	public void checkout(){
		System.out.println("Checkout method from shoppping cart called");
	}
}

