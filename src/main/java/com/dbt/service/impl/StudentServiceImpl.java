package com.dbt.service.impl;

import com.dbt.entity.NewPasswordAndOldPassword;
import com.dbt.entity.Student;
import com.dbt.mapper.StudentMapper;
import com.dbt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    public Student getStudentById(String studentId, String password) {
        return studentMapper.getStudentById(studentId,password);
    }

    public Integer updateStudent(Student student) {
        return studentMapper.StudentUpdateOfStudent(student);
    }

        public Integer updateStudentPassword(NewPasswordAndOldPassword newPasswordAndOldPassword) {
            return studentMapper.StudentUpdatePassword(newPasswordAndOldPassword);
        }
}
