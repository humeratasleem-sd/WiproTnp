package RDBMS_JDBC_SQL.UsingPreparedSolutionAndProcessingObjects.Problem2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class StudentDAO {

    public void insertStudent(Student s) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO Student VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, s.getRollNo());
            ps.setString(2, s.getStudentName());
            ps.setString(3, s.getStandard());
            ps.setDate(4, Date.valueOf(s.getDob()));
            ps.setDouble(5, s.getFees());

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Record Inserted Successfully");
            else
                System.out.println("Insertion Failed");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}