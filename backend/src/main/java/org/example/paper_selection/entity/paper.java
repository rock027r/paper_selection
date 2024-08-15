package org.example.paper_selection.entity;

import org.w3c.dom.Text;

import java.util.Date;

public class paper {
    private String paper_id;
    private String paper_name;
    private Text paper_description;
    private String teacher_id;
    private String student_id;
    private Date upload_time;

    public Date getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(Date upload_time) {
        this.upload_time = upload_time;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Text getPaper_description() {
        return paper_description;
    }

    public void setPaper_description(Text paper_description) {
        this.paper_description = paper_description;
    }

    public String getPaper_name() {
        return paper_name;
    }

    public void setPaper_name(String paper_name) {
        this.paper_name = paper_name;
    }

    public String getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(String paper_id) {
        this.paper_id = paper_id;
    }
}
