package com.dbt.service;

import com.dbt.entity.NewPasswordAndOldPassword;
import com.dbt.entity.Student;

public interface StudentService {
    Student getStudentById(String studentId, String password);

    Integer updateStudent(Student student);

    Integer updateStudentPassword(NewPasswordAndOldPassword newPasswordAndOldPassword);
}
