package org.example;

public class Executive extends Manager {
    private static double ceoSalary = 1000;

    public Executive(String name) {
        super(name, null, "all");
        super.updateSalaryTo(ceoSalary);
    }

    public static void setCeoSalary(double ceoSalary) {
        Executive.ceoSalary = ceoSalary;
    }

    public static void writeTwitterPost() {
        System.out.println("We created new project!");
    }

    @Override
    public void TestGrade() {
        System.out.println("Testing...");
        updateSalaryTo(0.314 * getSalary());
    }
}
