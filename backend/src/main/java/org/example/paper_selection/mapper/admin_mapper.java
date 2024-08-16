package org.example.paper_selection.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.example.paper_selection.entity.student;

public interface admin_mapper {

    @Insert("insert ignore into student"+
            " (sid, name, class_name, department, qq_num, phone_num, selection_status, account_status, password) " +
            "values (#{sid}, #{name}, #{class_name}, #{department}, #{qqNum}, #{phone}, '未选题', '启用', #{password})")
    public void insertstu(String sid,String name,String class_name,String phone,String qqNum,String department,String password);

    @Update("update student" +
            "  SET name = #{name}, class_name = #{class_name}, department = #{department}, qq_num = #{qqNum}, phone_num = #{phone}, " +
            " selection_status = #{selection_status}, account_status = #{account_status} WHERE `sid` = #{sid}")
    public void updatastu(String sid,String name,String class_name,String phone,String qqNum,String department,String selection_status,String account_status);

    @Insert("insert ignore into teacher"+
            "(jid,name,department,phone_num,qq_num,guide_num,paper_num,account_status,password)"+
            "values (#{jobid}, #{name}, #{department},#{phoneNum} ,#{qqNum}, #{guideNum}, #{paperNum}, '启用', #{password} ) ")
    public void inserttch(String jobid, String name, String department, String phoneNum, String qqNum, Integer guideNum, Integer paperNum, String password);

    @Update("UPDATE teacher " +
            "SET name = #{name}, department = #{department}, phone_num = #{phoneNum}, qq_num = #{qqNum}, " +
            "guide_num = #{guideNum}, paper_num = #{paperNum}, account_status = #{account_status} " +
            "WHERE jid = #{jobid}")
    public void updatetch(String jobid, String name, String department, String phoneNum, String qqNum, Integer guideNum, Integer paperNum, String account_status);

}
