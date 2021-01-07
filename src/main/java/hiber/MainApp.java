package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {

      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Honda", 567);
      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
      Car car2 = new Car("Lada", 11);
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
      Car car3 = new Car("Lada", 12);
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));

      User user = userService.getUserByCar("Lada", 11);

      System.out.println(user);

      context.close();
   }
}
