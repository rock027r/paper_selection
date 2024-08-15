package org.example.paper_selection.entity;

public class teacher {
    private String jid;
    private String name;
    private String department;
    private String qq_num;
    private String phone_num;
    private Integer guide_num;
    private Integer paper_num;
    private String account_status;

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
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

    public Integer getGuide_num() {
        return guide_num;
    }

    public void setGuide_num(Integer guide_num) {
        this.guide_num = guide_num;
    }

    public Integer getPaper_num() {
        return paper_num;
    }

    public void setPaper_num(Integer paper_num) {
        this.paper_num = paper_num;
    }

    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }
}
