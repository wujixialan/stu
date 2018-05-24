/**
 * Created by zxg on 2018/5/12.
 */
public class Cla {
    private int id;
    private int age;

    public Cla() {
    }

    public Cla(int id) {

        this.id = id;
    }

    public Cla(int id, int age) {
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cla{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
