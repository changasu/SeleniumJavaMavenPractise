package com.xyz.automationtestingdemo.testpackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JavaPolymorphism {
	public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.drive1(); // Output: "Driving the vehicle..."

        Car c = new Car();
        c.drive1(); // Output: "Driving the car..."
        c.drive(60); // Output: "Driving the car at 60 mph..."
        
        Vehicle v1 = new Car(); //Upcasting
        v1.drive1();
    }
	
	@DataProvider(name = "DataProviderName")
    public Object[][] dpMethod()
    {
    	return new Object[][] {{"Subba", "Reddy"}, {"Changa", "Subbareddy"}};
    }
    
    @Test (dataProvider = "DataProviderName")
    public void DataProviderParameterizedTest(String parameter1, String parameter2)
    {
    	System.out.println(parameter1 + parameter2);
    }
}

class Vehicle {
    public void drive1() {
        System.out.println("Driving the vehicle...");
    }
}

class Car extends Vehicle {
    // Method Overriding
    public void drive() {
        System.out.println("Driving the car...");
    }
    
 // Method Overriding
    public void drive1() {
        System.out.println("Driving the car...");
    }

    // Method Overloading
    public void drive(int speed) {
        System.out.println("Driving the car at " + speed + " mph...");
    }
}
