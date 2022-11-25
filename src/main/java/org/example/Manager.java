package org.example;

public class Manager extends Employee implements Testable {
    private String securityLevel;

    private String project;

    private double salary;

    private static final double salaryCoefficient = 15000;

    public Manager(String name, String department, String securityLevel) {
        super(name, department);
        this.securityLevel = securityLevel;
        this.salary = 0;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    public final String sendSticker() {
        return "KittySticker";
    }

    public final void orderPizza(int numberOfPeople) {
        System.out.printf("Ordered pizza for %s people from Papa Johns", numberOfPeople);
    }

    public void updateSalaryTo(double delta) {
        this.salary += delta;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void TestGrade() {
        System.out.println("Testing...");
        salary += 1.1 * salary + salaryCoefficient * securityLevel.length();
    }
}
