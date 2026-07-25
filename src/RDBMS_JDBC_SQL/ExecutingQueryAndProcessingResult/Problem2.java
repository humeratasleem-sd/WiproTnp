package RDBMS_JDBC_SQL.ExecutingQueryAndProcessingResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Problem2 {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establish Connection
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/XEPDB1",
                    "hr",
                    "hr");
            // Create Statement
            stmt = con.createStatement();

            // SQL Query
            String query = "SELECT FIRST_NAME, JOB_ID, SALARY, COMMISSION_PCT "
                         + "FROM EMPLOYEES "
                         + "WHERE SALARY > 4000 AND SALARY < 10000";

            // Execute Query
            rs = stmt.executeQuery(query);

            System.out.println("FIRST_NAME\tJOB_ID\t\tSALARY\tCOMMISSION_PCT");
            System.out.println("---------------------------------------------------------------");

            while (rs.next()) {

                String firstName = rs.getString("FIRST_NAME");
                String jobId = rs.getString("JOB_ID");
                double salary = rs.getDouble("SALARY");
                String commission = rs.getString("COMMISSION_PCT");

                System.out.println(firstName + "\t\t"
                        + jobId + "\t"
                        + salary + "\t"
                        + commission);
            }

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        } finally {

            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}