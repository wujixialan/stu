import java.util.concurrent.atomic.AtomicReference;

public class Te {
    public static void main(String[] args) {
        String str = "610222198401020112";
        String newStr = "***********";
        String sub = str.substring(3, 14);
        str = str.replace(sub, newStr);
        System.out.println(str);
        AtomicReference<Double> atomic = new AtomicReference<>((double) 0);
        System.out.println(atomic.get());
        atomic.set(atomic.get() + 2);
        System.out.println(atomic.get());
    }
}
