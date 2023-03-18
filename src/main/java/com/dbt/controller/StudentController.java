package com.dbt.controller;

import com.alibaba.fastjson.JSONObject;
import com.dbt.entity.NewPasswordAndOldPassword;
import com.dbt.entity.Student;
import com.dbt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.dbt.utils.FinallyUtils.STUDENT_LOGIN;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping(value = "/login")
    @ResponseBody
    public JSONObject StudentLogin(@RequestBody Student student ,HttpServletResponse response,
                                   HttpServletRequest request){
        JSONObject json = new JSONObject();
       String studentId=student.getStudentId();
       String password=student.getPassword();
        try{
            if(studentId==null || "".equals(studentId)){
                json.put("code","400");
                json.put("msg","学号不可以为空");
                json.put("data",null);
            }else if(password==null || "".equals(password)){
                json.put("code","400");
                json.put("msg","密码不可以为空");
                json.put("data",null);
            }else{
                Student student1 = studentService.getStudentById(studentId, password);
                    if(student1==null){
                        json.put("code","400");
                        json.put("msg","密码错误或者学生不存在");
                        json.put("data",null);
                    }else{
                        request.getSession().setAttribute(STUDENT_LOGIN,student1);
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
     * 学生查询自己的信息，需要在登录之后查询
     * */

    @RequestMapping(value = "/getStudentById")
    @ResponseBody
    public JSONObject getStudentById(HttpServletResponse response,
                                   HttpServletRequest request){
        JSONObject json = new JSONObject();
        try{
            Student student = (Student)request.getSession().getAttribute(STUDENT_LOGIN);
            if(student==null){
                json.put("code","400");
                json.put("msg","您还未登录，没有此权限");
                json.put("data",null);
            }else{
                String studentId = student.getStudentId();
                String password=student.getPassword();
                Student student1 = studentService.getStudentById(studentId, password);
                json.put("code","200");
                json.put("msg","查询成功");
                json.put("data",student1);
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
     * 学生修改名字和班级
     * */

    @RequestMapping(value = "/updateStudent")
    @ResponseBody
    public JSONObject updateStudent(@RequestBody Student student, HttpServletResponse response,
                                     HttpServletRequest request){
        String name=student.getName();
        String studentClazz=student.getStudentClazz();
        JSONObject json = new JSONObject();
        try{
              if(name==null|| "".equals(name)){
                  json.put("code","400");
                  json.put("msg","姓名不能为空");
                  json.put("data",null);
              }else if(studentClazz==null|| "".equals(studentClazz)){
                  json.put("code","400");
                  json.put("msg","班级不能为空");
                  json.put("data",null);
              }else{
                  Student student1 = (Student)request.getSession().getAttribute(STUDENT_LOGIN);
                  if(student1==null){
                      json.put("code","400");
                      json.put("msg","没有此权限");
                      json.put("data",null);
                  }else {
                      student.setStudentId(student1.getStudentId());
                      Integer integer = studentService.updateStudent(student);
                      if(integer>0){
                          json.put("code","200");
                          json.put("msg","修改成功");
                          json.put("data",null);
                      }else{
                          json.put("code","400");
                          json.put("msg","修改失败");
                          json.put("data",null);
                      }
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
     * 学生修改密码
     * */

    @RequestMapping(value = "/updateStudentPassword")
    @ResponseBody
    public JSONObject updateStudentPassword(@RequestBody NewPasswordAndOldPassword newPasswordAndOldPassword, HttpServletResponse response,
                                            HttpServletRequest request){
        String oldPassword=newPasswordAndOldPassword.getOldPassword();
        String newPassword=newPasswordAndOldPassword.getNewPassword();
        String verifyPassword=newPasswordAndOldPassword.getVerifyPassword();
        System.out.println(oldPassword);
        System.out.println(newPassword);
        System.out.println(verifyPassword);
        JSONObject json = new JSONObject();
        try{
            if(oldPassword==null || "".equals(oldPassword)){
                json.put("code","400");
                json.put("msg","新密码不可以为空");
                json.put("data",null);
            }else if(newPassword==null || "".equals(newPassword)){
                json.put("code","400");
                json.put("msg","旧密码不可以为空");
                json.put("data",null);
            }else if(verifyPassword==null || "".equals(verifyPassword)){
                json.put("code","400");
                json.put("msg","确认密码不可以为空");
                json.put("data",null);
            }else{
                Student student = (Student)request.getSession().getAttribute(STUDENT_LOGIN);
                if(student==null){
                    json.put("code", "400");
                    json.put("msg", "您还未登录");
                    json.put("data", null);
                }else{
                    String password =student.getPassword();
                    System.out.println(password);
                    if(!(oldPassword.equals(password))){
                        json.put("code", "400");
                        json.put("msg", "原密码不相同");
                        json.put("data", null);
                    }else if(!(newPassword.equals(verifyPassword))){
                        json.put("code", "400");
                        json.put("msg", "两次密码不一致");
                        json.put("data", null);
                    } else{
                        newPasswordAndOldPassword.setStudentId(student.getStudentId());
                        Integer integer = studentService.updateStudentPassword(newPasswordAndOldPassword);
                            if(integer>0){
                                json.put("code", "200");
                                json.put("msg", "修改成功");
                                json.put("data", null);
                            }else{
                                json.put("code", "400");
                                json.put("msg", "修改失败");
                                json.put("data", null);
                            }
                        }
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
