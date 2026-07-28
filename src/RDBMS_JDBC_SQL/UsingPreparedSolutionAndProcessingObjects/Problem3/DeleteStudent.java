package RDBMS_JDBC_SQL.UsingPreparedSolutionAndProcessingObjects.Problem3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleteStudent {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        ResultSet rs = null;

        try {

            int rollno = Integer.parseInt(args[0]);

            con = DBUnit.getConnection();

            String selectQuery = "SELECT Rollno, StudentName, Standard FROM Student WHERE Rollno=?";

            ps1 = con.prepareStatement(selectQuery);
            ps1.setInt(1, rollno);

            rs = ps1.executeQuery();

            if (rs.next()) {

                String insertQuery = "INSERT INTO StudentLog VALUES(?,?,?,SYSDATE)";

                ps2 = con.prepareStatement(insertQuery);

                ps2.setInt(1, rs.getInt("Rollno"));
                ps2.setString(2, rs.getString("StudentName"));
                ps2.setString(3, rs.getString("Standard"));

                ps2.executeUpdate();

                String deleteQuery = "DELETE FROM Student WHERE Rollno=?";

                ps3 = con.prepareStatement(deleteQuery);
                ps3.setInt(1, rollno);

                int rows = ps3.executeUpdate();

                if (rows > 0)
                    System.out.println("Record Deleted Successfully");
                else
                    System.out.println("Record Not Found");

            } else {

                System.out.println("Student Record Not Found");

            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {
                if (rs != null)
                    rs.close();
                if (ps1 != null)
                    ps1.close();
                if (ps2 != null)
                    ps2.close();
                if (ps3 != null)
                    ps3.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}