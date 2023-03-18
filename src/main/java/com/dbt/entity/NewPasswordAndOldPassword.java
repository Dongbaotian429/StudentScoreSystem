package com.dbt.entity;

public class NewPasswordAndOldPassword {
    private String oldPassword;
    private String newPassword;
    private String verifyPassword;

    private String studentId;

    public NewPasswordAndOldPassword(String oldPassword, String newPassword, String verifyPassword, String studentId) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.verifyPassword = verifyPassword;
        this.studentId = studentId;
    }

    public NewPasswordAndOldPassword() {
    }


    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "NewPasswordAndOldPassword{" +
                "oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", verifyPassword='" + verifyPassword + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}
