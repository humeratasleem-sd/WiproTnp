#!/usr/bin/env python3
import os

# DisplayCookiesServlet.java content
display_cookies_content = '''package Servlets.CookiesAndSessionManagement.problem2;

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
'''

# SessionTrackingServlet.java content
session_tracking_content = '''package Servlets.CookiesAndSessionManagement.problem3;

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
'''

# Write the files
file1_path = r'src\Servlets\CookiesAndSessionManagement\problem2\DisplayCookiesServlet.java'
file2_path = r'src\Servlets\CookiesAndSessionManagement\problem3\SessionTrackingServlet.java'

with open(file1_path, 'w', encoding='utf-8') as f:
    f.write(display_cookies_content)
print(f"✓ Written {file1_path}")

with open(file2_path, 'w', encoding='utf-8') as f:
    f.write(session_tracking_content)
print(f"✓ Written {file2_path}")

print("\nAll files written successfully!")
