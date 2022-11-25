package org.example;

public class Secretary extends Employee {
    public Secretary(String name) {
        super(name, "Secretariat");
    }

    @Override
    public double getSalary() {
        return 45;
    }

    public void printDocuments() {
        System.out.println("Documents printed");
    }
}
