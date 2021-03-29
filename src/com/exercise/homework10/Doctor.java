package com.exercise.homework10;

/**
 * @author pi
 * @date 2021/03/26 10:45:07
 **/
public class Doctor {
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Doctor) {
            Doctor doctor = (Doctor) obj;
            if (this.getName().equals(doctor.getName()) &&
                    this.getAge() == doctor.getAge() &&
                    this.getGender() == doctor.getGender() &&
                    this.getJob().equals(doctor.getJob()) &&
                    this.getSal() == doctor.getSal()) {
                return true;
            }
        }
        return false;
    }
}
