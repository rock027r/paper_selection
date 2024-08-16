package org.example.paper_selection.controller;

import org.example.paper_selection.entity.ApiResponse;
import org.example.paper_selection.entity.student;
import org.example.paper_selection.entity.teacher;
import org.example.paper_selection.server.admin_server;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("admin")
public class    admin_controller {

    private final admin_server server;

    public admin_controller(admin_server server) {
        this.server = server;
    }


    //导入学生信息
        @PostMapping("upload_stu")
    public ResponseEntity<ApiResponse> upload_stu(@RequestParam("file") MultipartFile file) throws IOException {
            try {
                String result =  server.upload_stu(file);
                ApiResponse response = new ApiResponse(result, true);
                return ResponseEntity.ok(response);  // 返回 200 OK 和 JSON 响应
            } catch (Exception e) {
                ApiResponse errorResponse = new ApiResponse("Error: " + e.getMessage(), false);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)  // 返回 500 错误和 JSON 响应
                        .body(errorResponse);
            }

    }
    //学生信息修改
        @PostMapping("revise_stu")
    public  ResponseEntity<ApiResponse> revise_stu(@RequestBody List<student> stu)
        {

            try {
                String result = server.revise_stu(stu);
                ApiResponse response = new ApiResponse(result, true);
                return ResponseEntity.ok(response);  // 返回 200 OK 和结果
            } catch (Exception e) {
                ApiResponse errorResponse = new ApiResponse("Error: " + e.getMessage(), false);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)  // 返回 500 错误和 JSON 响应
                        .body(errorResponse);
            }
        }
    //导入老师信息
        @PostMapping("upload_tch")
    public ResponseEntity<ApiResponse> upload_tch(@RequestParam("file") MultipartFile file) throws IOException {
            try {
                String result =  server.upload_tch(file);
                ApiResponse response = new ApiResponse(result, true);
                return ResponseEntity.ok(response);  // 返回 200 OK 和 JSON 响应
            } catch (Exception e) {
                ApiResponse errorResponse = new ApiResponse("Error: " + e.getMessage(), false);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)  // 返回 500 错误和 JSON 响应
                        .body(errorResponse);
            }
        }
    //老师信息修改
        @PostMapping("revise_tch")
    public  ResponseEntity<ApiResponse> revise_tch(@RequestBody List<teacher> tch)
    {

        try {
            String result = server.revise_tch(tch);
            ApiResponse response = new ApiResponse(result, true);
            return ResponseEntity.ok(response);  // 返回 200 OK 和结果
        } catch (Exception e) {
            ApiResponse errorResponse = new ApiResponse("Error: " + e.getMessage(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)  // 返回 500 错误和 JSON 响应
                    .body(errorResponse);
        }
    }
}
