package org.example.paper_selection.server;

import jakarta.annotation.Resource;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.paper_selection.entity.student;
import org.example.paper_selection.mapper.admin_mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class admin_server {
    @Resource
    admin_mapper mapper;

    //处理excel数据
    private String getCellAsString(Cell cell) {
        if (cell == null) {
            return ""; // 处理空单元格的情况
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf((long) cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "Unsupported Cell Type";
        }
    }

    public String upload_stu(MultipartFile file) throws IOException {

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            // 获取第一个Sheet
            Sheet sheet = workbook.getSheetAt(0);


            // 从第二行开始遍历（跳过第一行）
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue; // 忽略空行
                }

                Cell studentIdCell = row.getCell(1); // 学号
                Cell nameCell = row.getCell(2); // 姓名
                Cell classCell = row.getCell(3); // 班级
                Cell phoneCell = row.getCell(4); // 电话
                Cell qqCell = row.getCell(5);
                Cell departmentCell = row.getCell(6);

                String studentId = getCellAsString(studentIdCell);
                String name = getCellAsString(nameCell);
                String className = getCellAsString(classCell);
                String phone = getCellAsString(phoneCell);
                String qq = getCellAsString(qqCell);
                String department = getCellAsString(departmentCell);
                // 将数据存入实体类
                String password = "123456";
                password.hashCode();
                mapper.insertstu(studentId,name,className,phone,qq,department);
            }
        }
        return "数据上传成功";
    }

    public String revise_stu(student stu) {

        return "successfully revised student";
    }
}
