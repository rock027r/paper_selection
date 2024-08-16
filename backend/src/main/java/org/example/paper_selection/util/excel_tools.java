package org.example.paper_selection.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.paper_selection.entity.student;
import org.example.paper_selection.entity.teacher;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class excel_tools {

    //获取数据
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

    public List<student> upload_student(MultipartFile file) throws IOException {
        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            // 获取第一个Sheet
            Sheet sheet = workbook.getSheetAt(0);
            //HashTools  hashool = new HashTools();
            //List 对象
            List<student> stu = new ArrayList<>();
            // 从第二行开始遍历（跳过第一行 表头）
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue; // 忽略空行
                }

                //这里读取信息
                Cell studentIdCell = row.getCell(1); // 学号
                Cell nameCell = row.getCell(2); // 姓名
                Cell classCell = row.getCell(3); // 班级
                Cell phoneCell = row.getCell(4); // 电话
                Cell qqCell = row.getCell(5);//qq
                Cell departmentCell = row.getCell(6);//系

                String studentId = getCellAsString(studentIdCell);
                String name = getCellAsString(nameCell);
                String className = getCellAsString(classCell);
                String phone = getCellAsString(phoneCell);
                String qq = getCellAsString(qqCell);
                String department = getCellAsString(departmentCell);
                String password = HashTools.digestBySHA256("123456");

                stu.add(new student(studentId, name, className, phone, qq, department,password));
            }
            return stu;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public List<teacher> upload_teacher(MultipartFile file) throws IOException {
        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            // 获取第一个Sheet
            Sheet sheet = workbook.getSheetAt(0);

            //List 对象
            List<teacher> tch = new ArrayList<>();
            // 从第二行开始遍历（跳过第一行 表头）
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue; // 忽略空行
                }

                //这里读取信息
                Cell jobIdCell = row.getCell(1); // 工号
                Cell nameCell = row.getCell(2); // 姓名
                Cell guide_numCell = row.getCell(3); // 指导学生数量
                Cell paper_numCell = row.getCell(4); // 选题数量
                Cell phoneCell = row.getCell(5);//phone
                Cell qqCell = row.getCell(6);//qq
                Cell departmentCell = row.getCell(7);//系别

                String jobId = getCellAsString(jobIdCell);
                String name = getCellAsString(nameCell);
                Integer guide = Integer.valueOf(getCellAsString(guide_numCell));
                Integer paper = Integer.valueOf(getCellAsString(paper_numCell));
                String qq = getCellAsString(qqCell);
                String phone = getCellAsString(phoneCell);
                String department = getCellAsString(departmentCell);
                String password = HashTools.digestBySHA256("888888");

                tch.add(new teacher(jobId, name, guide,paper, qq, phone,department,password));
            }
            return tch;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


}
