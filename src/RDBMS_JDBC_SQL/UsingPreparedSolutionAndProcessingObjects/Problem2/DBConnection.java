package RDBMS_JDBC_SQL.UsingPreparedSolutionAndProcessingObjects.Problem2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/XEPDB1",
                    "hr",
                    "hr");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}