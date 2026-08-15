package AJAXDatabaseApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckEmailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");

        if (email == null || email.trim().equals("")) {
            out.println("Invalid Email Id");
            return;
        }

        email = email.trim();

        // Check email format
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            out.println("Invalid Email Id");
            return;
        }

        try {

            Connection con = DBUtil.getConnection();

            String sql = "SELECT EMAIL FROM PROFILE " + "WHERE LOWER(EMAIL) = LOWER(?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                out.println("Not Available!");
            } else {
                out.println("Available!");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

            out.println("Database Error");
        }
    }
}