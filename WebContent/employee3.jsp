<%@ page import="Servlets.JavaBeans.Problem3.EmployeeBean" %>

<html>
<head>
    <title>Employee</title>
</head>
<body>

<jsp:useBean id="employee"
    class="Servlets.JavaBeans.Problem3.EmployeeBean"
    scope="request" />

<jsp:setProperty name="employee" property="*" />

<h2>Employee Details</h2>

Name:
<jsp:getProperty name="employee" property="name" />

<br><br>

ID:
<jsp:getProperty name="employee" property="id" />

<br><br>

Designation:
<jsp:getProperty name="employee" property="designation" />

<br><br>

<%
    String name = employee.getName();
    int id = employee.getId();
    String designation = employee.getDesignation();

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        java.sql.Connection con = java.sql.DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:xepdb11",
            "hr",
            "hr"
        );

        java.sql.PreparedStatement ps = con.prepareStatement(
            "INSERT INTO emp(name, id, designation) VALUES (?, ?, ?)"
        );

        ps.setString(1, name);
        ps.setInt(2, id);
        ps.setString(3, designation);

        ps.executeUpdate();

        out.println("<h3>Employee details stored successfully.</h3>");

        ps.close();
        con.close();

    } catch (Exception e) {
        out.println("<h3>Error: " + e.getMessage() + "</h3>");
    }
%>

</body>
</html>