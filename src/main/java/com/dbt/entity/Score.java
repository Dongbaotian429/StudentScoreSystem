package com.dbt.entity;

public class Score {
    private String studentId;
    private Integer classPerformance;
    private Integer finalExam;
    private Integer sumScore;

    public Score(String studentId, Integer classPerformance, Integer finalExam, Integer sumScore) {
        this.studentId = studentId;
        this.classPerformance = classPerformance;
        this.finalExam = finalExam;
        this.sumScore = sumScore;
    }

    public Score() {
    }

    public Integer getClassPerformance() {
        return classPerformance;
    }

    public void setClassPerformance(Integer classPerformance) {
        this.classPerformance = classPerformance;
    }

    public Integer getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(Integer finalExam) {
        this.finalExam = finalExam;
    }

    public Integer getSumScore() {
        return sumScore;
    }

    public void setSumScore(Integer sumScore) {
        this.sumScore = sumScore;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Score{" +
                "studentId='" + studentId + '\'' +
                ", classPerformance=" + classPerformance +
                ", finalExam=" + finalExam +
                ", sumScore=" + sumScore +
                '}';
    }
}
