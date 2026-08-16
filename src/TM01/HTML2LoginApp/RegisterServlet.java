package TM01.HTML2LoginApp;

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
        String retype = request.getParameter("retype");

        try {

            if (!password.equals(retype)) {

                response.sendRedirect(
                    "html2/Registration.html"
                );

                return;
            }

            Connection con = DBUtil.getConnection();

            String sql =
                "INSERT INTO USERS(USERID,PASSWORD) VALUES(?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, userid);
            ps.setString(2, password);

            ps.executeUpdate();

            con.close();

            response.sendRedirect("html2/Login.html");

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                "Registration Failed: " + e.getMessage()
            );
        }
    }
}