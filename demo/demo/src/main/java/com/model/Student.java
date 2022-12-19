package com.model;

public class Student {
    private int id;
    private String name = null;
    private boolean gender;
    private float point = 0;
    private int age = 0;

    public Student() {
    }

    public Student(int id, String name, boolean gender, float point, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.point = point;
        this.age = age;
    }

    public Student( String name, float point, int age) {

        this.name = name;
        this.point = point;
        this.age = age;
    }
    public Student(String name, boolean gender, float point, int age) {
        this.name = name;
        this.gender = gender;
        this.point = point;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
