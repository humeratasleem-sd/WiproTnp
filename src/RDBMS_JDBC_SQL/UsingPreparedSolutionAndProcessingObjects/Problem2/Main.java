package RDBMS_JDBC_SQL.UsingPreparedSolutionAndProcessingObjects.Problem2;

public class Main {

    public static void main(String[] args) {

        Student s = new Student(
                1001,
                "RAHUL",
                "X",
                "2008-05-15",
                25000
        );

        StudentDAO dao = new StudentDAO();
        dao.insertStudent(s);
    }
}
