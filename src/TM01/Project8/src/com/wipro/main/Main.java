package TM01.Project8.src.com.wipro.main;
import java.util.ArrayList;
import TM01.Project8.src.com.wipro.dao.UserDAO;
import TM01.Project8.src.com.wipro.bean.UserBean;

public class Main {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        System.out.println("Scenario 1");
        System.out.println(dao.getUserType("AB1001"));

        System.out.println();

        System.out.println("Scenario 2");
        System.out.println(dao.getIncorrectAttempts("AB1001"));

        System.out.println();

        System.out.println("Scenario 3");
        System.out.println(dao.changeUserType("TA1002"));

        System.out.println();

        System.out.println("Scenario 4");
        System.out.println(dao.getLockStatus());

        System.out.println();

        System.out.println("Scenario 5");
        System.out.println(dao.changeName("RS1003", "Ganesh Kumar"));
     // Scenario 6
     System.out.println(dao.changePassword("admin123"));

     // Scenario 7
     UserBean u1 = new UserBean("AB2001", "pass123", "Rahul", 0, 0, "Employee");
     System.out.println(dao.addUser_1(u1));

     // Scenario 8
     UserBean u2 = new UserBean("AB2002", "pass456", "Kiran", 0, 0, "Employee");
     System.out.println(dao.addUser_2(u2));

     // Scenario 9
     ArrayList<UserBean> employees = dao.getUsers("Employee");
     for (UserBean u : employees) {
         System.out.println(u);
     }

     // Scenario 10
     ArrayList<UserBean> allUsers = dao.storeAllRecords();
     for (UserBean u : allUsers) {
         System.out.println(u);
     }

     // Scenario 11
     String[] names = dao.getNames();
     for (String name : names) {
         if (name != null)
             System.out.println(name);
     }
    }

}