package RDBMS_JDBC_SQL.UsingPreparedSolutionAndProcessingObjects.Problem5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplayStudent {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            con = DBUnit.getConnection();

            if (args.length == 0) {

                String query = "SELECT * FROM Student";

                ps = con.prepareStatement(query);

            } else {

                int rollno = Integer.parseInt(args[0]);

                String query = "SELECT * FROM Student WHERE Rollno=?";

                ps = con.prepareStatement(query);
                ps.setInt(1, rollno);

            }

            rs = ps.executeQuery();

            System.out.println("RollNo\tStudentName\tStandard\tDOB\t\tFees");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("Rollno") + "\t" +
                        rs.getString("StudentName") + "\t\t" +
                        rs.getString("Standard") + "\t\t" +
                        rs.getDate("Date_Of_Birth") + "\t" +
                        rs.getDouble("Fees"));

            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (rs != null)
                    rs.close();

                if (ps != null)
                    ps.close();

                if (con != null)
                    con.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

    }
}