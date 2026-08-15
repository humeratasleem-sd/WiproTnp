@echo off
REM Write DisplayCookiesServlet.java
(
echo package Servlets.CookiesAndSessionManagement.problem2;
echo.
echo import java.io.IOException;
echo import java.io.PrintWriter;
echo.
echo import jakarta.servlet.ServletException;
echo import jakarta.servlet.http.Cookie;
echo import jakarta.servlet.http.HttpServlet;
echo import jakarta.servlet.http.HttpServletRequest;
echo import jakarta.servlet.http.HttpServletResponse;
echo.
echo public class DisplayCookiesServlet extends HttpServlet {
echo.
echo     protected void doGet^(HttpServletRequest request, HttpServletResponse response^)
echo             throws ServletException, IOException {
echo.
echo         response.setContentType^("text/html"^);
echo.
echo         PrintWriter out = response.getWriter^(^);
echo.
echo         Cookie^[^] cookies = request.getCookies^(^);
echo.
echo         if ^(cookies == null ^|^| cookies.length == 0^) {
echo.
echo             out.println^("^<h1^>No Cookies^</h1^>"^);
echo.
echo         } else {
echo.
echo             out.println^("^<h1^>Available Cookies^</h1^>"^);
echo.
echo             out.println^("^<table border='1'^>"^);
echo.
echo             out.println^("^<tr^>"^);
echo             out.println^("^<th^>Cookie Name^</th^>"^);
echo             out.println^("^<th^>Cookie Value^</th^>"^);
echo             out.println^("^</tr^>"^);
echo.
echo             for /F %%%%I in ^('echo dummy'^) do ^(
echo                 out.println^("^<tr^>"^);
echo                 out.println^("^<td^>" + cookie.getName^(^) + "^</td^>"^);
echo                 out.println^("^<td^>" + cookie.getValue^(^) + "^</td^>"^);
echo                 out.println^("^</tr^>"^);
echo             ^)
echo.
echo             out.println^("^</table^>"^);
echo         }
echo     }
echo }
) > "src\Servlets\CookiesAndSessionManagement\problem2\DisplayCookiesServlet.java"

echo DisplayCookiesServlet.java file created
