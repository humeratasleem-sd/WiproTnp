package RDBMS_JDBC_SQL.UsingPreparedSolutionAndProcessingObjects.Problem1;

import java.sql.*;

public class DAOClass {

    Connection con;

    public DAOClass() throws Exception {
        con = DriverManager.getConnection(
                "jdbc:oracle:thin:@//localhost:1521/XEPDB1",
                "hr",
                "hr");
    }

    public void insert(int rollno, String name, int marks, String dob, int fees) throws Exception {

        String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, rollno);
        ps.setString(2, name);
        ps.setInt(3, marks);
        ps.setDate(4, java.sql.Date.valueOf(dob));
        ps.setInt(5, fees);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Record Inserted Successfully");

        ps.close();
    }

    public void delete(int rollno) throws Exception {
        PreparedStatement ps = con.prepareStatement(
                "DELETE FROM STUDENT WHERE ROLLNO=?");
        ps.setInt(1, rollno);
        ps.executeUpdate();
        ps.close();
    }

    public void modify(int rollno, int fees) throws Exception {
        PreparedStatement ps = con.prepareStatement(
                "UPDATE STUDENT SET FEES=? WHERE ROLLNO=?");
        ps.setInt(1, fees);
        ps.setInt(2, rollno);
        ps.executeUpdate();
        ps.close();
    }

    public void display() throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM STUDENT");

        while (rs.next()) {
            System.out.println(
                    rs.getInt("ROLLNO") + " "
                    + rs.getString("NAME") + " "
                    + rs.getInt("MARKS") + " "
                    + rs.getDate("DOB") + " "
                    + rs.getInt("FEES"));
        }

        rs.close();
        st.close();
    }

    public void display(int rollno) throws Exception {
        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM STUDENT WHERE ROLLNO=?");
        ps.setInt(1, rollno);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
                    rs.getInt("ROLLNO") + " "
                    + rs.getString("NAME") + " "
                    + rs.getInt("MARKS") + " "
                    + rs.getDate("DOB") + " "
                    + rs.getInt("FEES"));
        }

        rs.close();
        ps.close();
    }
}