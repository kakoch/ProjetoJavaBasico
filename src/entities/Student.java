package entities;

import java.util.List;

public class Student {

    private int code;
    private String name;
    private float testOne;
    private float testTwo;
    private float testThree;

    public Student() {}

    public Student(int code, String name, float testOne, float testTwo, float testThree) {
        this.code = code;
        this.name = name;
        this.testOne = testOne;
        this.testTwo = testTwo;
        this.testThree = testThree;
    }

    public String getName() {
        return name;
    }

    public float getTestOne() {
        return testOne;
    }

    public float getTestTwo() {
        return testTwo;
    }

    public float getTestThree() {
        return testThree;
    }

    public int getCode() {
        return code;
    }
}