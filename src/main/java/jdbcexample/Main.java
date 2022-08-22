package jdbcexample;


import jdbcexample.manager.UserManager;
import jdbcexample.model.User;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
UserManager userManager=new UserManager();


        try {
            User user1 = new User("poxos","poxosyan","poxos","poxos@mail.com");
            userManager.addUser(user1);
            System.out.println(user1);
            List<User>allUsers=userManager.getAllUsers();
            for (User user : allUsers) {
                System.out.println(user);
            }
            userManager.deleteUserById(4);

            allUsers=userManager.getAllUsers();
            for (User user:allUsers){
                System.out.println(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
