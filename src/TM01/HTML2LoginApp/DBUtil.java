package TM01.HTML2LoginApp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    public static Connection getConnection()
            throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521/xepdb1",
            "hr",
            "hr"
        );

        return con;
    }
}