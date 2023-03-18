package com.dbt.service.impl;

import com.dbt.entity.Score;
import com.dbt.entity.Student;
import com.dbt.entity.Teacher;
import com.dbt.mapper.ScoreMapper;
import com.dbt.mapper.StudentMapper;
import com.dbt.mapper.TeacherMapper;
import com.dbt.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ScoreMapper scoreMapper;
    public Teacher getTeacher(String teacherId,String password) {
        Teacher teacher = teacherMapper.getTeacher(teacherId, password);
        return teacher;
    }

    public List<Student> getAllStudent() {
        return studentMapper.getAllStudent();
    }

    public Integer addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    public Integer updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    public Integer addScore(Score score) {
        Integer classPerformance=score.getClassPerformance();
        Integer finalExam =score.getFinalExam();
        Integer sumScore=classPerformance+finalExam;
        score.setSumScore(sumScore);
        return scoreMapper.addScore(score);
    }
}
