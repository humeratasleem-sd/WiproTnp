package RDBMS_JDBC_SQL.UsingPreparedSolutionAndProcessingObjects.Problem5;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUnit {

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