import com.stu.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

/**
 * Created by zxg on 2018/5/7.
 */
public class TestUserDao {
   @Test
   public void tets() {
       Configuration cfg = new Configuration().configure();

       StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
               .configure("classpath:hibernate.cfg.xml").build();

       SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
       Session session = sessionFactory.openSession();
       User user = new User();
       user.setUserId("201407040324");
       user.setUserType("管理员");
       String hql = "from User u where u.username <> :username and u.userType <> :userType";
       List<User> users = session.createQuery(hql)
               .setString("username", user.getUsername())
               .setString("userType", user.getUserType())
               .list();
       System.out.println(users.size());
   }
}
