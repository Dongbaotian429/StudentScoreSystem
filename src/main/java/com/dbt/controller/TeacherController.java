package com.dbt.controller;

import com.alibaba.fastjson.JSONObject;
import com.dbt.entity.Score;
import com.dbt.entity.Student;
import com.dbt.entity.Teacher;
import com.dbt.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import static com.dbt.utils.FinallyUtils.TEACHER_LOGIN;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    /**
     *老师登录
     * */
    @RequestMapping(value = "/login")
    @ResponseBody
    public JSONObject teacherLogin(@RequestBody Teacher teacher, HttpServletRequest request, HttpServletResponse response){
        JSONObject json = new JSONObject();
        String teacherId = teacher.getTeacherId();
        String password = teacher.getPassword();
        try{
            if(teacherId == null || "".equals(teacherId)){
                json.put("code","400");
                json.put("msg","账号不能为空");
                json.put("data",null);
            }else if(password == null || "".equals(password)){
                json.put("code","400");
                json.put("msg","密码不能为空");
                json.put("data",null);
            }else{
                Teacher teacher1 = teacherService.getTeacher(teacherId, password);
                if(teacher1==null){
                    json.put("code","300");
                    json.put("msg","用户名不存在或者密码错误");
                    json.put("data",null);
                }else{
                    request.getSession().setAttribute(TEACHER_LOGIN,teacher1);
                    json.put("code","200");
                    json.put("msg","登录成功");
                    json.put("data",null);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("code","500");
            json.put("msg","服务器错误");
            json.put("data",null);
        }
        return json;
    }


    /**
     *老师查询所有学生信息
     * */
    @RequestMapping(value = "/getAllStudent")
    @ResponseBody
    public JSONObject getAllStudent(HttpServletRequest request, HttpServletResponse response){
        JSONObject json = new JSONObject();
       try{
           Teacher teacher =(Teacher) request.getSession().getAttribute(TEACHER_LOGIN);
           if(teacher==null || "".equals(teacher)){
               json.put("code","400");
               json.put("msg","没有此权限");
               json.put("data",null);
           }else{
               List<Student> allStudent = teacherService.getAllStudent();
               json.put("code","200");
               json.put("msg","操作成功");
               json.put("data",allStudent);
           }
       }catch (Exception e){
           e.printStackTrace();
           json.put("code","500");
           json.put("msg","服务器错误");
           json.put("data",null);
       }
        return json;
    }

    /**
     *老师添加学生
     * */
    @RequestMapping(value = "/addStudent")
    @ResponseBody
    public JSONObject addStudent(@RequestBody Student student, HttpServletRequest request, HttpServletResponse response){
        JSONObject json = new JSONObject();
        String name=student.getName();
        String studentClazz=student.getStudentClazz();
        String password = student.getPassword();
        String studentId=student.getStudentId();
        try{
            if(studentId==null || "".equals(studentId)) {
                json.put("code", "400");
                json.put("msg", "学生Id不可以为空");
                json.put("data", null);
            }else if(name==null || "".equals(name)){
                json.put("code","400");
                json.put("msg","姓名不可以为空");
                json.put("data",null);
            }else if(studentClazz==null || "".equals(studentClazz)){
                json.put("code","400");
                json.put("msg","学生班级不可以为空");
                json.put("data",null);
            }else if(password==null || "".equals(password)){
                json.put("code","400");
                json.put("msg","密码不可以为空");
                json.put("data",null);
            }else if(request.getSession().getAttribute(TEACHER_LOGIN)==null){
                json.put("code","400");
                json.put("msg","没有此权限，请您登录");
                json.put("data",null);
            }else{
                Integer integer = teacherService.addStudent(student);
                if(integer>0){
                    json.put("code","200");
                    json.put("msg","添加成功");
                    json.put("data",integer);
                }else {
                    json.put("code","400");
                    json.put("msg","添加失败");
                    json.put("data",null);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("code","500");
            json.put("msg","服务器错误");
            json.put("data",null);
        }
        return json;
    }
    /**
     * 修改学生信息
     * */
    @RequestMapping(value = "/updateStudent")
    @ResponseBody
    public JSONObject updateStudent(@RequestBody Student student, HttpServletRequest request, HttpServletResponse response){
        JSONObject json = new JSONObject();
        String name=student.getName();
        String studentClazz=student.getStudentClazz();
        String password = student.getPassword();
        String studentId=student.getStudentId();
        try{
            if(studentId==null || "".equals(studentId)) {
                json.put("code", "400");
                json.put("msg", "学生Id不可以为空");
                json.put("data", null);
            }else if(name==null || "".equals(name)){
                json.put("code","400");
                json.put("msg","姓名不可以为空");
                json.put("data",null);
            }else if(studentClazz==null || "".equals(studentClazz)){
                json.put("code","400");
                json.put("msg","学生班级不可以为空");
                json.put("data",null);
            }else if(password==null || "".equals(password)){
                json.put("code","400");
                json.put("msg","密码不可以为空");
                json.put("data",null);
            }else if(request.getSession().getAttribute(TEACHER_LOGIN)==null){
                json.put("code","400");
                json.put("msg","没有此权限，请您登录");
                json.put("data",null);
            }else{
                Integer integer = teacherService.updateStudent(student);
                if(integer>0){
                    json.put("code","200");
                    json.put("msg","修改成功");
                    json.put("data",integer);
                }else {
                    json.put("code","400");
                    json.put("msg","修改失败");
                    json.put("data",null);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("code","500");
            json.put("msg","服务器错误");
            json.put("data",null);
        }
        return json;
    }
    /**
     * 教师评分
     * */
    @RequestMapping(value = "/addScore")
    @ResponseBody
    public JSONObject addScore(@RequestBody Score score, HttpServletRequest request, HttpServletResponse response){
        JSONObject json = new JSONObject();
        String studentId=score.getStudentId();
        Integer classPerformance =score.getClassPerformance();
        Integer finalExam=score.getFinalExam();
        try{
            if(studentId==null || "".equals(studentId)) {
                json.put("code", "400");
                json.put("msg", "学号不可以为空");
                json.put("data", null);
            }else if(classPerformance==null || "".equals(classPerformance)){
                json.put("code","400");
                json.put("msg","课上成绩不可以为空");
                json.put("data",null);
            }else if(finalExam==null || "".equals(finalExam)){
                json.put("code","400");
                json.put("msg","期末成绩不可以为空");
                json.put("data",null);
            }else if(request.getSession().getAttribute(TEACHER_LOGIN)==null){
                json.put("code","400");
                json.put("msg","没有此权限，请您登录");
                json.put("data",null);
            }else{
                Integer integer = teacherService.addScore(score);
                if(integer>0){
                    json.put("code","200");
                    json.put("msg","评分成功");
                    json.put("data",integer);
                }else {
                    json.put("code","400");
                    json.put("msg","评分失败");
                    json.put("data",null);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("code","500");
            json.put("msg","服务器错误");
            json.put("data",null);
        }
        return json;
    }
}
