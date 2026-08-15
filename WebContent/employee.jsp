<%@ page import="Servlets.JavaBeans.Problem1.EmployeeBean" %>

<html>
<head>
    <title>Employee Details</title>
</head>
<body>

<jsp:useBean id="employee"
    class="Servlets.JavaBeans.Problem1.EmployeeBean"
    scope="request" />

<jsp:setProperty name="employee" property="*" />

<h2>Employee Details</h2>

Employee Name:
<jsp:getProperty name="employee" property="employeeName" />

<br><br>

Employee ID:
<jsp:getProperty name="employee" property="employeeId" />

</body>
</html>