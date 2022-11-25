package org.example;

public abstract class Employee {

    public String getName() {
        return name;
    }

    protected final String name;

    private String department;

    protected Employee(String name) {
        this(name, "Unemployed");
    }

    protected Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public abstract double getSalary();
}
