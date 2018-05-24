import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zxg on 2018/5/11.
 */
public class TestObject {
    public static void main(String[] args) {
        List<Cla> list = new ArrayList<>();
        list.add(new Cla(1));
        list.add(new Cla(2));
        Set<Cla> arrayList = new HashSet<>();
        arrayList.add(new Cla(2));
        arrayList.add(new Cla(0));
        arrayList.stream().forEach(ele -> {
            list.contains(ele);
            System.out.println(ele + "-" + list.contains(ele));
        });
    }
}
