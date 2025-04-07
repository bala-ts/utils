package com.tsb.util;

//basic enum
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}


//enum with Methods and Constructors
enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRALARGE("XL");

    private String abbreviation;

    Size(String abbreviation) { // Constructor
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() { // Method
        return abbreviation;
    }
}



//Enum with Abstract Methods
enum Operation {
    ADD {
        public int apply(int a, int b) { return a + b; }
    },
    SUBTRACT {
        public int apply(int a, int b) { return a - b; }
    },
    MULTIPLY {
        public int apply(int a, int b) { return a * b; }
    };

    public abstract int apply(int a, int b);
}

//Enum Implementing Interfaces

interface Printable {
    void print();
}

enum Status implements Printable {
    SUCCESS, ERROR, PENDING;

    public void print() {
        System.out.println("Status: " + this);
    }
}



public class Enum {
    public static void main(String[] args) {
        Size size = Size.LARGE;
        System.out.println("Size: " + size + ", Abbreviation: " + size.getAbbreviation());
        
        Day today = Day.FRIDAY;
        System.out.println("Today is: " + today);
        
        // Iterating Over enum Values
        for (Day d : Day.values()) {
            System.out.println(d);
        }
        
        //switch case can be used 
        
        int result = Operation.ADD.apply(5, 3);
        System.out.println("Addition: " + result);
        
        
        Status.SUCCESS.print();
        
        
    }
}
