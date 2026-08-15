package AJAXApplication.Problem1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CityServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String state = request.getParameter("state");

        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>City</th>");
        out.println("</tr>");

        if (state.equals("Telangana")) {

            out.println("<tr><td>Hyderabad</td></tr>");
            out.println("<tr><td>Warangal</td></tr>");
            out.println("<tr><td>Nizamabad</td></tr>");
            out.println("<tr><td>Karimnagar</td></tr>");

        } else if (state.equals("Karnataka")) {

            out.println("<tr><td>Bangalore</td></tr>");
            out.println("<tr><td>Mysore</td></tr>");
            out.println("<tr><td>Mangalore</td></tr>");
            out.println("<tr><td>Hubli</td></tr>");

        } else if (state.equals("Maharashtra")) {

            out.println("<tr><td>Mumbai</td></tr>");
            out.println("<tr><td>Pune</td></tr>");
            out.println("<tr><td>Nagpur</td></tr>");
            out.println("<tr><td>Nashik</td></tr>");

        } else if (state.equals("Tamil Nadu")) {

            out.println("<tr><td>Chennai</td></tr>");
            out.println("<tr><td>Coimbatore</td></tr>");
            out.println("<tr><td>Madurai</td></tr>");
            out.println("<tr><td>Salem</td></tr>");
        }

        out.println("</table>");
    }
}