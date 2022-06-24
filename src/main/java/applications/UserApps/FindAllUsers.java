package applications.UserApps;

import entity.User;
import entityservice.UserEntityService;

import java.util.List;

public class FindAllUsers {

    public static void main(String[] args) {

        UserEntityService service = new UserEntityService();
        List<User> userList = service.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}