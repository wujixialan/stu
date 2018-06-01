package com.stu.excel;

import com.stu.entity.Clazz;
import com.stu.entity.Student;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * 用来读取 excel 的内容。
 */
public class ReadStudentExcel {
    public static List<Student> readXlsx(InputStream path) throws Exception
    {
        XSSFWorkbook xwb = new XSSFWorkbook(path);
        XSSFSheet sheet = xwb.getSheetAt(0);
        XSSFRow row;
        String cell;
        List<Student> students = new LinkedList<>();
        for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++)
        {
            try {
                row = sheet.getRow(i);
                int j = row.getFirstCellNum();
                Student student = new Student();
                student.setSid(row.getCell(j).toString());
                student.setName(row.getCell(j + 1).toString());
                student.setGender(row.getCell(j + 2).toString());
                student.setNation(row.getCell(j + 3).toString());
                student.setOrigin(row.getCell(j + 4).toString());
                student.setBirth(row.getCell(j + 5).getDateCellValue());
                student.setIdCard(row.getCell(j + 6).toString());
                student.setAddress(row.getCell(j + 7).toString());
                student.setReviewId(0);
                student.setReviewContent("学生未审核");
                Clazz clazz = new Clazz();
                clazz.setCid(row.getCell(j + 8).toString());
                clazz.setClazzName(row.getCell(j + 9).toString());
                student.setClazz(clazz);
                students.add(student);
            } catch (Exception e) {
                throw new Exception();
            }
        }
        return students;
    }
}
