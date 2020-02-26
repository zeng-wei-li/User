package com.example.demo.controller;

import com.example.demo.service.ExcelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
@Api("导出Excel模块")
@RestController
@RequestMapping("/export")
public class ExcelController {
    @Autowired
    private ExcelService excelService;
    //导出user表
    @ApiOperation(value = "导出user表",notes = "导出user表",httpMethod = "GET" )
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String  userExcel(HttpServletResponse response){
        XSSFWorkbook wb =excelService.show();
        String fileName = "User报表.xlsx";
        OutputStream outputStream =null;
        try {
            fileName = URLEncoder.encode(fileName,"UTF-8");
            //设置ContentType请求信息格式
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            outputStream = response.getOutputStream();
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

}
