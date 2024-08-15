package org.example.paper_selection.entity;

public class student {
    private String sid;
    private String name;
    private String class_name ;

    private String department;
    private String qq_num;
    private String phone_num;
    private String selection_status;
    private String account_status;

    public student(String studentId, String name, String className, String phone, String qq, String department) {
        this.sid = studentId;
        this.name = name;
        this.class_name = className;
        this.phone_num = phone;
        this.qq_num = qq;
        this.department = department;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getQq_num() {
        return qq_num;
    }

    public void setQq_num(String qq_num) {
        this.qq_num = qq_num;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getSelection_status() {
        return selection_status;
    }

    public void setSelection_status(String selection_status) {
        this.selection_status = selection_status;
    }

    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }
}
