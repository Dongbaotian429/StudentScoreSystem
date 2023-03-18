package com.dbt.mapper;

import com.dbt.entity.Student;
import com.dbt.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    /**
     * 登录
     * */

    Teacher getTeacher(@Param("teacherId") String teacherId,@Param("password") String password);

}
