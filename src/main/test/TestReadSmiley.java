import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zxg on 2018/5/28.
 */
public class TestReadSmiley {
    public static void main(String[] args) {
        File file = new File("F:\\f");
        String[] files = file.list();
        List<String> strings = new LinkedList<>();
        Arrays.stream(files).forEach(ele -> {
            strings.add("'" + ele + "'");
        });
        System.out.println(strings);
    }
}
