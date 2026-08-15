package Servlets.CookiesAndSessionManagement.problem3;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionTrackingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            count = 1;
        } else {
            count++;
        }

        session.setAttribute("count", count);

        out.println("<h1>Session Details</h1>");

        out.println("<p>Number of Visits: " + count + "</p>");

        out.println("<p>Session ID: " + session.getId() + "</p>");

        out.println("<p>Creation Time: " + session.getCreationTime() + "</p>");

        out.println("<p>Last Accessed Time: " + session.getLastAccessedTime() + "</p>");

        out.println("<p>Maximum Inactive Interval: "
                + session.getMaxInactiveInterval() + " seconds</p>");
    }
}
