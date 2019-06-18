package com.cqut.crud.controller;

import com.cqut.crud.bean.*;
import com.cqut.crud.service.*;
import com.cqut.crud.util.VeDate;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChenTengfei
 * @date 2019/4/29 15:51
 **/

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentStatusService studentStatusService;
    @Autowired
    private FamilyMemberService familyMemberService;
    @Autowired
    private ReadService readService;
    @Autowired
    DicSerivce dicSerivce;

    /**
     * 获取贫困学生信息
     */
    @RequestMapping("/getStudentInfo")
    @ResponseBody
    public Msg getStudentInfo(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                              Model model) {
        //传入页码，以及每页条数
        PageHelper.startPage(pn, 5);
        List<Student> students = studentService.getAll();

        //翻译贫困类型
        for(Student student:students){
            Dictionary povertyType = dicSerivce.translate("POVERTY_TYPE", student.getPovertyType());
            if(povertyType!=null){
                student.setPovertyType(povertyType.getDicName());
            }
        }

        //封装了详细的分页信息，包括我们查出来的数据。传入连续显示的页数
        PageInfo page = new PageInfo(students, 5);

        return Msg.success().add("pageInfo", page);
    }

    /**
     * 模糊查询
     */
    @ResponseBody
    @RequestMapping("/findByIdNumber")
    public Msg findByIdNumber(@RequestParam("idNumber") String idNumber, @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        //传入页码，以及每页条数
        PageHelper.startPage(pn, 5);
        Student studentCondition = new Student();
        studentCondition.setIdNumber(idNumber);
        List<Student> students = studentService.findByCondition(studentCondition);

        //翻译贫困类型
        for(Student student:students){
            Dictionary povertyType = dicSerivce.translate("POVERTY_TYPE", student.getPovertyType());
            if(povertyType!=null){
                student.setPovertyType(povertyType.getDicName());
            }
        }

        //封装了详细的分页信息，包括我们查出来的数据。传入连续显示的页数
        PageInfo page = new PageInfo(students, 5);
        return Msg.success().add("pageInfo", page);
    }

    /**
     * 删除学生，即修改学生delete_at
     */
    @ResponseBody
    @RequestMapping(value = "deleteBy/{ids}", method = RequestMethod.PUT)
    public Msg deleteBy(@PathVariable("ids") String ids) {
        if (ids.contains("-")) {
            String[] str_ids = ids.split("-");
            for (String string : str_ids) {
                studentService.deleteBy(string);
            }
        } else {
            studentService.deleteBy(ids);
        }
        return Msg.success();
    }

    /**
     * 跳转到studentDetail.jsp界面传递id
     */
    @RequestMapping(value = "/toStudentDetail")
    @ResponseBody
    public Msg Login(@RequestParam("id") String id, HttpServletRequest request) {
        request.getSession().setAttribute("studentId", id);
        return Msg.success();
    }

    /**
     * 根据学生Id获取信息
     */
    @ResponseBody
    @RequestMapping("/getInfoById")
    public Msg getInfoById(@RequestParam("id") String id) {

        Student student = studentService.getInfoById(id);
        StudentStatus studentStatus = studentStatusService.getInfoByStudentId(id);
        //翻译学段
        Dictionary school_phase = dicSerivce.translate("SCHOOL_PHASE", studentStatus.getSchoolPhase());
        if(school_phase!=null){
            studentStatus.setSchoolPhase(school_phase.getDicName());
        }
        //翻译学籍状态
        Dictionary student_status = dicSerivce.translate("STUDENT_STATUS", studentStatus.getStatus());
        if(student_status!=null){
            studentStatus.setStatus(student_status.getDicName());
        }
        List<FamilyMember> familyMembers = familyMemberService.getInfoByStudentId(id);
        return Msg.success().add("student", student).add("studentStatus", studentStatus).add("familyMembers", familyMembers);
    }

    /**
     * 学生个人信息保存
     */
    @ResponseBody
    @RequestMapping("/saveStudentInfo")
    public Msg saveStudentInfo(@Valid Student student, @RequestParam("id") String id, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, Object> map = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println("错误字段：" + fieldError.getField());
                System.out.println("错误信息：" + fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);

        } else {
            student.setId(Integer.parseInt(id));
            studentService.saveStudentInfo(student);
            return Msg.success();
        }
    }

    /**
     * 删除家庭成员，即修改家庭成员delete_at
     */
    @ResponseBody
    @RequestMapping(value = "deleteFamilyById/{id}", method = RequestMethod.PUT)
    public Msg deleteFamilyById(@PathVariable("id") String id) {
        familyMemberService.deleteFamilyById(id);
        return Msg.success();
    }

    /**
     * 家庭成员添加
     */
    @ResponseBody
    @RequestMapping("/addFamilyMemberInfo")
    public Msg addFamilyMemberInfo(@Valid FamilyMember familyMember, @RequestParam("studentId") String studentId, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, Object> map = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println("错误字段：" + fieldError.getField());
                System.out.println("错误信息：" + fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);

        } else {
            familyMember.setStudentId(Integer.parseInt(studentId));
            familyMember.setBirthday(VeDate.idCardToDate(familyMember.getIdNumber()));
            familyMemberService.addFamilyMemberInfo(familyMember);
            return Msg.success();
        }
    }

    /**
     * 家庭成员编辑获取信息
     */
    @ResponseBody
    @RequestMapping(value = "getFamilyMemberInfo/{id}", method = RequestMethod.GET)
    public Msg getFamilyMemberInfo(@PathVariable("id") String id) {
        FamilyMember familyMember = familyMemberService.getFamilyMemberInfo(id);
        return Msg.success().add("familyMember", familyMember);
    }

    /**
     * 家庭成员更新
     */
    @ResponseBody
    @RequestMapping(value = "updateFamilyMember/{id}", method = RequestMethod.PUT)
    public Msg updateFamilyMember(@Valid FamilyMember familyMember, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, Object> map = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println("错误字段：" + fieldError.getField());
                System.out.println("错误信息：" + fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);

        } else {
            familyMemberService.updateFamilyMember(familyMember);
            return Msg.success();
        }
    }

    @ResponseBody
    @RequestMapping("/readStudentInfo")
    public Msg readStudentInfo(@RequestBody List<StudentFullInfo> studentFullInfos) {
        try {
            readService.insertStudentAndStatus(studentFullInfos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Msg.fail();
        }
        return Msg.success().add("studentFullInfos",studentFullInfos);
    }
    @ResponseBody
    @RequestMapping("/readFamily")
    public Msg readFamily(@RequestBody List<FamilyMember> familyMembers) {
        for(FamilyMember familyMember:familyMembers){
            familyMember.setBirthday(VeDate.idCardToDate(familyMember.getIdNumber()));
        }
        try {
            readService.insertFamilyMember(familyMembers);
        }catch (Exception e){
            return Msg.fail();
        }
        return Msg.success();
    }
}