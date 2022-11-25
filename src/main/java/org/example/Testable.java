package org.example;

public interface Testable {

    void TestGrade();

    default int ExpectedGradeUp() {
        return 0;
    }
}
