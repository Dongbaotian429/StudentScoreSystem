package com.dbt.entity;

import java.util.List;

public class Student {
    private String studentId;
    private String name;
    private String studentClazz;
    private String password;

    private List<Score> listScore;

    public Student(String studentId, String name, String studentClazz, String password, List<Score> listScore) {
        this.listScore = listScore;
        this.studentId = studentId;
        this.name = name;
        this.studentClazz = studentClazz;
        this.password = password;
    }

    public Student() {
    }

    public List<Score> getListScore() {
        return listScore;
    }

    public void setListScore(List<Score> listScore) {
        this.listScore = listScore;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentClazz() {
        return studentClazz;
    }

    public void setStudentClazz(String studentClazz) {
        this.studentClazz = studentClazz;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", studentClazz='" + studentClazz + '\'' +
                ", password='" + password + '\'' +
                ", listScore=" + listScore +
                '}';
    }
}
