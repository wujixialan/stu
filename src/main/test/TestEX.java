import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zxg on 2018/5/28.
 */
public class TestEX {
    public static void main(String[] args) {
        String s = "1525960196466.jg";
        s = s.substring(s.lastIndexOf("."));
        Pattern pattern = Pattern.compile("^\\.(gif|jpg|jpeg|png|JPG|PNG)$");
        Matcher matcher = pattern.matcher(s);
        System.out.println(s);
        if (!matcher.find()) {
            System.out.println("ddd");;
        }
    }
}
