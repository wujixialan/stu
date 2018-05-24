package com.stu.excel;

import com.stu.entity.Mark;
import com.stu.entity.Student;
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
public class ReadMarkExcel {
    public static List<Mark> readXlsx(InputStream path) throws IOException {
        XSSFWorkbook xwb = new XSSFWorkbook(path);
        XSSFSheet sheet = xwb.getSheetAt(0);
        XSSFRow row;
        String cell;
        List<Mark> marks = new LinkedList<>();
        for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            row = sheet.getRow(i);
            int j = row.getFirstCellNum();
            Mark mark = new Mark();
            Student student = new Student();
            student.setSid(row.getCell(j).toString());
            student.setName(row.getCell(j + 1).toString());
            mark.setStudent(student);
            mark.setSubjectId(row.getCell(j + 2).toString());
            mark.setSubjectName(row.getCell(j + 3).toString());
            mark.setScore(Double.parseDouble(row.getCell(j + 4).toString()));
            mark.setHang(row.getCell(j + 5).toString());
            mark.setStudy(row.getCell(j + 6).toString());
            mark.setSubjectType(row.getCell(j + 7).toString());
            mark.setTeam(row.getCell(j + 8).toString());
            mark.setCredit(Double.parseDouble(row.getCell(j + 9).toString()));
            mark.setGpa(Double.parseDouble(row.getCell(j + 10).toString()));
            mark.setReview(Integer.parseInt(row.getCell(j + 11).toString()));
            marks.add(mark);
        }
        return marks;
    }

//    public static void main(String[] args) throws IOException {
//        readXlsx("E:\\test.xlsx");
//    }
}
