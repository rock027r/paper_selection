package org.example.paper_selection.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.example.paper_selection.entity.student;

public interface admin_mapper {

    @Insert("insert ignore into student (sid, name, class_name, department, qq_num, phone_num, selection_status, account_status) " +
            "values (#{sid}, #{name}, #{class_name}, #{department}, #{qqNum}, #{phone}, '未选题', '启用')")
    public void insertstu(String sid,String name,String class_name,String phone,String qqNum,String department);



}
