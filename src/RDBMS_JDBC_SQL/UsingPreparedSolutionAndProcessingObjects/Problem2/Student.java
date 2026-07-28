package RDBMS_JDBC_SQL.UsingPreparedSolutionAndProcessingObjects.Problem2;

public class Student {

    private int rollNo;
    private String studentName;
    private String standard;
    private String dob;
    private double fees;

    public Student(int rollNo, String studentName, String standard, String dob, double fees) {
        this.rollNo = rollNo;
        this.studentName = studentName;
        this.standard = standard;
        this.dob = dob;
        this.fees = fees;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStandard() {
        return standard;
    }

    public String getDob() {
        return dob;
    }

    public double getFees() {
        return fees;
    }
}