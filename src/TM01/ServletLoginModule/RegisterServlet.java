package TM01.ServletLoginModule;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        if (!password.equals(repassword)) {

            response.getWriter().println(
                "<h3>Password and Retype Password are not same</h3>"
            );

            response.getWriter().println(
                "<a href='Registration.html'>Try Again</a>"
            );

            return;
        }

        try {

            Connection con = DBUtil.getConnection();

            String sql =
                "INSERT INTO USERS(USERID,PASSWORD) VALUES(?,?)";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setString(1, userid);
            ps.setString(2, password);

            ps.executeUpdate();

            con.close();

            response.sendRedirect("Login.html");

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                "<h3>Registration Failed</h3>"
            );

            response.getWriter().println(
                "<a href='Registration.html'>Try Again</a>"
            );
        }
    }
}
