package org.example;

public class Programmer extends Employee implements Testable {
    private boolean isNdaWrote = false;
    private int grade;
    private int hoursPerWeek;

    public Programmer(String name) {
        this(name, 1);
    }

    public Programmer(String name, int grade) {
        super(name, "IT");
        this.grade = grade;
        this.hoursPerWeek = 40;
    }

    public boolean isNdaWrote() {
        return isNdaWrote;
    }

    public void writeNda() {
        isNdaWrote = true;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public double getSalary() {
        return this.hoursPerWeek * this.grade * 1.5;
    }

    public void dropDB() {
        System.out.println("; DROP TABLE Users;");
    }

    @Override
    public void TestGrade() {
        System.out.println("Testing...");
        if (super.getName().length() % 2 == 0) {
            grade++;
        }
    }

    @Override
    public int ExpectedGradeUp() {
        return (int) (0.5 * getGrade());
    }
}
