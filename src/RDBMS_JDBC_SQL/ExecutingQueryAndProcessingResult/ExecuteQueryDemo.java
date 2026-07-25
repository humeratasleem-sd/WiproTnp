package RDBMS_JDBC_SQL.ExecutingQueryAndProcessingResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExecuteQueryDemo {

    public static void main(String[] args) {

        Connection con = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/XEPDB1",
                    "hr",
                    "hr");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEES");

            while (rs.next()) {
            	System.out.println(
            		    rs.getInt("EMPLOYEE_ID") + "    " +
            		    rs.getString("FIRST_NAME"));

            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

}
