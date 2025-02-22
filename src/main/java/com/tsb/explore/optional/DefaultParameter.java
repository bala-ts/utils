package com.tsb.explore.optional;

import java.util.Optional;

public class DefaultParameter {
	
	//how to make java function parameter as optional 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DefaultParameter example = new DefaultParameter();
		
		//using overloading
        example.greet("Alice");           // Uses default greeting
        example.greet("Bob", "Welcome");  // Custom greeting

        
        //Using optinal 
        example.greet("Alice", Optional.empty());             // Uses default greeting
        example.greet("Bob", Optional.of("Good evening"));  
        
        //using Varargs
        example.greet("Alice");                   // Uses default greeting
        example.greet("Bob", "Good afternoon");    // Custom greeting
        
        //using null check
        
        example.greet1("Alice",null);                  
        example.greet1("Bob", "Good afternoon");
        
        
	}

	// Method with two parameters
    public void greet(String name, String greeting) {
        System.out.println(greeting + ", " + name + "!");
    }

    // Overloaded method with one parameter (default greeting)
    public void greet(String name) {
        greet(name, "Hello"); // Default greeting
    }

    
    public void greet(String name, Optional<String> greeting) {
        String greetText = greeting.orElse("Hello");
        System.out.println(greetText + ", " + name + "!");
    }
    
	
    public void greet(String name, String... greeting) {
        String greetText = (greeting.length > 0) ? greeting[0] : "Hello";
        System.out.println(greetText + ", " + name + "!");
    }
    
    
    //Simple nullcheck
    public void greet1(String name, String greeting) {
        if (greeting == null) {
            greeting = "Hello";
        }
        System.out.println(greeting + ", " + name + "!");
    }

    
}
