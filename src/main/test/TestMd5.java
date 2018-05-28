import org.apache.commons.codec.digest.DigestUtils;

public class TestMd5 {
    public static void main(String[] args) {
        String res = DigestUtils.md5Hex("031209");
        System.out.println(res);
    }
}
