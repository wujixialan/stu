import com.stu.util.Message;
import net.sf.json.JSONObject;

public class TestMessage {
    public static void main(String[] args) {
        Message message= new Message();
        message.add(1, 1);
        System.out.println(JSONObject.fromObject(message));
    }
}
