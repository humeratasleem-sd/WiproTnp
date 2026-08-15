package Servlets.GetAndPostRequests.problem2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestParametersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");

        out.println("<h1>Request Parameters</h1>");

        Enumeration<String> parameters =
                request.getParameterNames();

        while (parameters.hasMoreElements()) {

            String parameterName = parameters.nextElement();

            String parameterValue =
                    request.getParameter(parameterName);

            out.println("<b>" + parameterName + "</b> : "
                    + parameterValue + "<br>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}