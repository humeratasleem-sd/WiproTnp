package RDBMS_JDBC_SQL.EstablishingConnection;
import java.sql.Connection;
import java.sql.DriverManager;
public class Problem2 {
    public static void main(String[] args) {
        Connection con = null;
        try {
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "system",
                    "oracle123");
            if (con != null) {
                System.out.println("Connection Established successfully");
            }
        } catch (Exception e) {
            System.out.println("Connection could not be established");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

