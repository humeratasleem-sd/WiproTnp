package TM01.Project8.src.com.wipro.dao;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import TM01.Project8.src.com.wipro.util.DBUtil;
import TM01.Project8.src.com.wipro.bean.UserBean;

public class UserDAO {

    // Scenario 1
    public String getUserType(String userID) {

        String userType = "";

        try {
            Connection con = DBUtil.getConnection();

            String sql = "SELECT UserType FROM UserTable WHERE UserID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                userType = rs.getString("UserType");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userType;
    }

    // Scenario 2
    public String getIncorrectAttempts(String userID) {

        String result = "";

        try {

            Connection con = DBUtil.getConnection();

            String sql = "SELECT IncorrectAttempts FROM UserTable WHERE UserID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int attempts = rs.getInt("IncorrectAttempts");

                if (attempts == 0)
                    result = "No Incorrect Attempt";
                else if (attempts == 1)
                    result = "One Time";
                else
                    result = "Incorrect Attempt Exceeded";
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // Scenario 3
    public String changeUserType(String userID) {

        String message = "Update Failed";

        try {

            Connection con = DBUtil.getConnection();

            String sql = "UPDATE UserTable SET UserType='Admin' WHERE UserID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userID);

            int rows = ps.executeUpdate();

            if (rows > 0)
                message = "Update Success";

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return message;
    }

    // Scenario 4
    public int getLockStatus() {

        int count = 0;

        try {

            Connection con = DBUtil.getConnection();

            String sql = "SELECT COUNT(*) FROM UserTable WHERE LockStatus=0";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    // Scenario 5
    public String changeName(String id, String name) {

        String message = "Failed";

        try {

            Connection con = DBUtil.getConnection();

            String sql = "UPDATE UserTable SET Name=? WHERE UserID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                message = "Success";

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return message;
    }
 // Scenario 6
    public String changePassword(String password) {

        String result = "0";

        try {

            Connection con = DBUtil.getConnection();

            String sql = "UPDATE UserTable SET Password=? WHERE UserType='Admin'";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, password);

            int rows = ps.executeUpdate();

            if (rows > 0)
                result = "Changed";

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
 // Scenario 7
    public String addUser_1(UserBean bean) {

        String result = "Fail";

        try {

            Connection con = DBUtil.getConnection();

            String sql = "INSERT INTO UserTable VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, bean.getUserID());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getName());
            ps.setInt(4, bean.getIncorrectAttempts());
            ps.setInt(5, bean.getLockStatus());
            ps.setString(6, bean.getUserType());

            int rows = ps.executeUpdate();

            if (rows > 0)
                result = "Success";

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
 // Scenario 8
    public String addUser_2(UserBean bean) {

        if (bean.getLockStatus() != 0)
            return "Fail";

        String result = "Fail";

        try {

            Connection con = DBUtil.getConnection();

            String sql = "INSERT INTO UserTable VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, bean.getUserID());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getName());
            ps.setInt(4, bean.getIncorrectAttempts());
            ps.setInt(5, bean.getLockStatus());
            ps.setString(6, bean.getUserType());

            int rows = ps.executeUpdate();

            if (rows > 0)
                result = "Success";

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
 // Scenario 9
    public ArrayList<UserBean> getUsers(String userType) {

        ArrayList<UserBean> list = new ArrayList<>();

        try {

            Connection con = DBUtil.getConnection();

            String sql = "SELECT * FROM UserTable WHERE UserType=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, userType);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                UserBean bean = new UserBean();

                bean.setUserID(rs.getString("UserID"));
                bean.setPassword(rs.getString("Password"));
                bean.setName(rs.getString("Name"));
                bean.setIncorrectAttempts(rs.getInt("IncorrectAttempts"));
                bean.setLockStatus(rs.getInt("LockStatus"));
                bean.setUserType(rs.getString("UserType"));

                list.add(bean);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
 // Scenario 10
    public ArrayList<UserBean> storeAllRecords() {

        ArrayList<UserBean> list = new ArrayList<>();

        try {

            Connection con = DBUtil.getConnection();

            String sql = "SELECT * FROM UserTable";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                UserBean bean = new UserBean();

                bean.setUserID(rs.getString("UserID"));
                bean.setPassword(rs.getString("Password"));
                bean.setName(rs.getString("Name"));
                bean.setIncorrectAttempts(rs.getInt("IncorrectAttempts"));
                bean.setLockStatus(rs.getInt("LockStatus"));
                bean.setUserType(rs.getString("UserType"));

                list.add(bean);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
 // Scenario 11
    public String[] getNames() {

        String[] names = new String[100];
        int i = 0;

        try {

            Connection con = DBUtil.getConnection();

            String sql = "SELECT Name FROM UserTable";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                names[i] = rs.getString("Name");
                i++;
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return names;
    }

}
