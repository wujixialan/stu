import cn.hutool.core.util.RandomUtil;
import com.stu.util.UUIDUtils;

/**
 * Created by zxg on 2018/5/26.
 */
public class TestHutool {
    public static void main(String[] args) {
       String uuid = RandomUtil.randomUUID();
        System.out.println(uuid);
        System.out.println(RandomUtil.simpleUUID());
        System.out.println(UUIDUtils.uuid());
    }
}
