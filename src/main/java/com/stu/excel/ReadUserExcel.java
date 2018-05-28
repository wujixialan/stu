package com.stu.excel;

import com.stu.entity.Student;
import com.stu.entity.User;
import com.stu.util.PwdEncryption;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * 用来读取 excel 的内容。
 */
public class ReadUserExcel {
    public static List<User> readXlsx(InputStream path) throws IOException {
        XSSFWorkbook xwb = new XSSFWorkbook(path);
        XSSFSheet sheet = xwb.getSheetAt(0);
        XSSFRow row;
        String cell;
        List<User> users = new LinkedList<>();
        for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            row = sheet.getRow(i);
            int j = row.getFirstCellNum();
            User user = new User();
            user.setUserId(row.getCell(j).getStringCellValue());
            user.setUsername(row.getCell(j + 1).getStringCellValue());
            user.setPassword(row.getCell(j + 2).getStringCellValue());
            String userType = row.getCell(j + 3).getStringCellValue();
            user.setUserType(userType);
            if (userType.trim().equals("学生")) {
                Student student = new Student(user.getUserId());
            }
            user = PwdEncryption.encryption(user);
            users.add(user);
        }
        return users;
    }

    public static List<User> readXlsx1(String path) throws IOException {
        XSSFWorkbook xwb = new XSSFWorkbook(path);
        XSSFSheet sheet = xwb.getSheetAt(0);
        XSSFRow row;
        String cell;
        List<User> users = new LinkedList<>();
        for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            row = sheet.getRow(i);
            int j = row.getFirstCellNum();
            User user = new User();
            user.setUserId(row.getCell(j).getStringCellValue());
            user.setUsername(row.getCell(j + 1).getStringCellValue());
            user.setPassword(row.getCell(j + 2).getStringCellValue());
            String userType = row.getCell(j + 3).getStringCellValue();
            user.setUserType(userType);
            if (userType.trim().equals("学生")) {
                Student student = new Student();
                student.setSid(user.getUserId());
                user.setStudent(student);
            }
            user = PwdEncryption.encryption(user);
            System.out.println(user);
        }
        return users;
    }

    public static void main(String[] args) throws IOException {
        readXlsx1("E:/user.xlsx");
    }
}
