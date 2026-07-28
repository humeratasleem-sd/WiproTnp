package RDBMS_JDBC_SQL.UsingCallableStatementAndTransactions.Problem1;
import java.sql.*;

public class CallProcedure {

    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {

            con = DBUnit.getConnection();

            st = con.createStatement();

            rs = st.executeQuery(
                "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME FROM EMPLOYEES");

            System.out.println("EMP_ID\tNAME\t\tNET SALARY");

            while (rs.next()) {

                int empId = rs.getInt("EMPLOYEE_ID");
                String name = rs.getString("FIRST_NAME") + " " +
                              rs.getString("LAST_NAME");

                cs = con.prepareCall("{call CAL_NETSAL(?,?)}");

                cs.setInt(1, empId);

                cs.registerOutParameter(2, Types.NUMERIC);

                cs.execute();

                double netSalary = cs.getDouble(2);

                System.out.println(empId + "\t" + name + "\t" + netSalary);

                cs.close();
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (rs != null)
                    rs.close();

                if (st != null)
                    st.close();

                if (con != null)
                    con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}