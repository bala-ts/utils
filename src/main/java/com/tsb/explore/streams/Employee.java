package com.tsb.explore.streams;
public class Employee {
    // Fields
    private String name;
    private int age;

    // Constructor
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + "}";
    }
}
