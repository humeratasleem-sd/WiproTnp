package Servlets.CookiesAndSessionManagement.problem2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DisplayCookiesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        if (cookies == null || cookies.length == 0) {

            out.println("<h1>No Cookies</h1>");

        } else {

            out.println("<h1>Available Cookies</h1>");

            out.println("<table border='1'>");

            out.println("<tr>");
            out.println("<th>Cookie Name</th>");
            out.println("<th>Cookie Value</th>");
            out.println("</tr>");

            for (Cookie cookie : cookies) {

                out.println("<tr>");

                out.println("<td>" + cookie.getName() + "</td>");

                out.println("<td>" + cookie.getValue() + "</td>");

                out.println("</tr>");
            }

            out.println("</table>");
        }
    }
}
