package TM01.HTML2LoginApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ChangePasswordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String userid = request.getParameter("userid");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword =
                request.getParameter("confirmPassword");

        try {

            Connection con = DBUtil.getConnection();

            /*
             * Check username and old password
             */
            String checkSql =
                "SELECT * FROM USERS WHERE USERID=? AND PASSWORD=?";

            PreparedStatement ps =
                con.prepareStatement(checkSql);

            ps.setString(1, userid);
            ps.setString(2, oldPassword);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {

                response.getWriter().println(
                    "<h3>Invalid username or old password</h3>"
                );

                return;
            }

            /*
             * Check new password and confirm password
             */
            if (!newPassword.equals(confirmPassword)) {

                response.getWriter().println(
                    "<h3>New password and Retype password are not same</h3>"
                );

                return;
            }

            /*
             * Update password
             */
            String updateSql =
                "UPDATE USERS SET PASSWORD=? WHERE USERID=?";

            PreparedStatement ps2 =
                con.prepareStatement(updateSql);

            ps2.setString(1, newPassword);
            ps2.setString(2, userid);

            ps2.executeUpdate();

            con.close();

            response.sendRedirect("html2/Login.html");

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                "Password Change Failed: " + e.getMessage()
            );
        }
    }
}