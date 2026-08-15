package Servlets.ServletConfigAndContext.Problem1;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConfigContextServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ServletConfig config = getServletConfig();
        ServletContext context = getServletContext();
        out.println("<html><body>");
        out.println("<h1>Servlet Config Parameters</h1>");
        String servletName = config.getInitParameter("servletName");
        String servletValue = config.getInitParameter("servletValue");
        out.println("Servlet Name: " + servletName + "<br>");
        out.println("Servlet Value: " + servletValue + "<br>");
        out.println("<h1>Servlet Context Parameters</h1>");
        String contextName = context.getInitParameter("contextName");
        String contextValue = context.getInitParameter("contextValue");
        out.println("Context Name: " + contextName + "<br>");
        out.println("Context Value: " + contextValue + "<br>");
        out.println("</body></html>");
    }
}
