package RDBMS_JDBC_SQL.UsingPreparedSolutionAndProcessingObjects.Problem4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateStudent {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement ps = null;
        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter Roll Number: ");
            int rollno = sc.nextInt();

            System.out.print("Enter New Fee: ");
            double fees = sc.nextDouble();

            con = DBUnit.getConnection();

            String query = "UPDATE Student SET Fees=? WHERE Rollno=?";

            ps = con.prepareStatement(query);

            ps.setDouble(1, fees);
            ps.setInt(2, rollno);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Record Updated Successfully");
            else
                System.out.println("Student Record Not Found");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
                sc.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}