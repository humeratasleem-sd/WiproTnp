package Servlets.GetAndPostRequests.Problem1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestHeadersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");

        out.println("<h1>Request Headers</h1>");

        Enumeration<String> headers = request.getHeaderNames();

        while (headers.hasMoreElements()) {

            String headerName = headers.nextElement();

            String headerValue = request.getHeader(headerName);

            out.println("<b>" + headerName + "</b> : "
                    + headerValue + "<br>");

        }

        out.println("</body>");
        out.println("</html>");
    }
}
