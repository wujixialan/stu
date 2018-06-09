import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.stu.entity.Student;

import java.util.List;

/**
 * Created by zxg on 2018/6/6.
 */
public class TestHutoolExcel {
    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("E:\\stu1.xlsx"), 0);
        List<Student> students = reader.readAll(Student.class);
        students.stream().forEach(System.out::println);
    }
}
