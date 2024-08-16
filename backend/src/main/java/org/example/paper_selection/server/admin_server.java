package org.example.paper_selection.server;

import jakarta.annotation.Resource;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.paper_selection.entity.student;
import org.example.paper_selection.entity.teacher;
import org.example.paper_selection.mapper.admin_mapper;
import org.example.paper_selection.util.HashTools;
import org.example.paper_selection.util.excel_tools;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class admin_server {
    @Resource
    admin_mapper mapper;

    public String upload_stu(MultipartFile file) throws IOException {
        excel_tools tools = new excel_tools();
        List<student> stu = tools.upload_student(file);
        if(stu.isEmpty()){
            return "数据为空";
        }
        for (student stus : stu) {
            String studentId = stus.getSid();
            String name = stus.getName();
            String className = stus.getClass_name();
            String phone = stus.getPhone_num();
            String qq =  stus.getQq_num();
            String department = stus.getDepartment();
            String password = stus.getPassword();
            mapper.insertstu(studentId,name,className,phone,qq,department,password);
        }
        return "数据上传成功";
    }

    //修改学生信息
    public String revise_stu(List<student> stu) {
        //System.out.println("Received student list: " + stu);
        for (student student : stu) {
            System.out.println("SID: " + student.getSid());
            System.out.println("Name: " + student.getName());
            System.out.println("Class: " + student.getClass_name());

            System.out.println("Department: " + student.getDepartment());
            String studentId = student.getSid();
            String name = student.getName();
            String className = student.getClass_name();
            String phone = student.getPhone_num();
            String qq = student.getQq_num();
            String department = student.getDepartment();
            String selection_status = student.getSelection_status();
            String account_status = student.getAccount_status();
            mapper.updatastu(studentId,name,className,phone,qq,department,selection_status,account_status);
        }

        return "数据修改成功";
    }

    //上传老师信息
    public String upload_tch(MultipartFile file) throws IOException {
        excel_tools tools = new excel_tools();
        List<teacher> tch = tools.upload_teacher(file);
        if(tch.isEmpty()){
            return "数据为空";
        }
        for (teacher tchs : tch) {
           String jobid = tchs.getJid();
           String name = tchs.getName();
           String department = tchs.getDepartment();
           String phone_num = tchs.getPhone_num();
           String qq_num = tchs.getQq_num();
           Integer guide_num = tchs.getGuide_num();
           Integer paper_num = tchs.getPaper_num();
           String password = tchs.getPassword();
           mapper.inserttch(jobid,name,department,phone_num,qq_num,guide_num,paper_num,password);

        }
        return "数据上传成功";
    }

    // 修改教师信息
    public String revise_tch(List<teacher> teachers) {
        // 遍历教师列表
        for (teacher teacher : teachers) {

            // 从 Teacher 对象中提取字段
            String jobid = teacher.getJid();
            String name = teacher.getName();
            String department = teacher.getDepartment();
            String phoneNum = teacher.getPhone_num();
            String qqNum = teacher.getQq_num();
            Integer guideNum = teacher.getGuide_num();
            Integer paperNum = teacher.getPaper_num();
            String accountStatus = teacher.getAccount_status();

            // 调用 mapper 方法更新教师信息
            mapper.updatetch(jobid, name, department, phoneNum, qqNum, guideNum, paperNum, accountStatus);
        }

        return "数据修改成功";
    }
}
