package com.dbt.entity;

public class Teacher {
    private String teacherId;
    private String teacherName;
    private String password;

    public Teacher(String teacherId, String teacherName, String password) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.password = password;
    }

    public Teacher() {
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

