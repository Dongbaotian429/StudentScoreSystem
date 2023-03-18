package com.dbt.service;

import com.dbt.entity.Score;
import com.dbt.entity.Student;
import com.dbt.entity.Teacher;

import java.util.List;

public interface TeacherService {

/**
 * 通过teacherID和password查询Teacher对象
 * */
    Teacher getTeacher(String teacherId,String password);

    /**
     * 查询虽有的学生信息
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
     * 评分
     * */
    Integer addScore(Score score);
}
