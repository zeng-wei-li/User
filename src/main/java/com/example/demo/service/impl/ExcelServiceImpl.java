package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.ExcelService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExcelServiceImpl implements ExcelService {
    @Autowired
    private UserDao userDao;
    @Override
    public XSSFWorkbook show() {
        //查出user表所有数据
        List<User> list = userDao.all();
        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("User");//创建一张表
        Row titleRow = sheet.createRow(0);//创建第一行，起始为0
        titleRow.createCell(0).setCellValue("序号");//第一列
        titleRow.createCell(1).setCellValue("ID");
        titleRow.createCell(2).setCellValue("姓名");
        int cell = 1;
        for (User user : list) {
            Row row = sheet.createRow(cell);//从第二行开始保存数据
            row.createCell(0).setCellValue(cell);
            row.createCell(1).setCellValue(user.getId());//将数据库的数据遍历出来
            row.createCell(2).setCellValue(user.getName());

            cell++;
        }
        return wb;
    }

}
