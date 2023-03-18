package com.dbt.mapper;

import com.dbt.entity.NewPasswordAndOldPassword;
import com.dbt.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    /**
     * 获取所有学生信息
     * */
    List<Student> getAllStudent();

    /**
     * 添加学生
     * */
    Integer addStudent(Student student);

    /**
     * 修改学生信息
     * */
    Integer updateStudent(Student student);

    /**
     * 通过学号和密码查询某个学生
     * */
    Student getStudentById(@Param("studentId") String studentId,@Param("password") String password);

    /**
     * 修改学生信息
     * */
    Integer StudentUpdateOfStudent(Student student);

    /**
     * 修改密码
     * */
    Integer StudentUpdatePassword(NewPasswordAndOldPassword newPasswordAndOldPassword);
}
