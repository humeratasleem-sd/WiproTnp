package Servlets.CookiesAndSessionManagement.problem1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstTimeVisitorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        boolean firstTime = true;

        if (cookies != null) {

            for (Cookie cookie : cookies) {

                if (cookie.getName().equals("visited")) {
                    firstTime = false;
                }
            }
        }

        if (firstTime) {

            out.println("<h1>Welcome, you are visiting for the first time</h1>");

            Cookie cookie = new Cookie("visited", "yes");
            response.addCookie(cookie);

        } else {

            out.println("<h1>Welcome Back</h1>");
        }
    }
}